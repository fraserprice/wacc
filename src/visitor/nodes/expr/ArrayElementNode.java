package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.runtimeerror.CheckArrayBounds;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.VariableObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayElementNode extends ExprNode<WACCParser.ArrayElemContext> {

    private List<ExprNode> exprNodeList;
    private String ident;

    public ArrayElementNode(SymbolTable currentST, WACCParser
            .ArrayElemContext ctx, List<ExprNode> exprNodeList) {
        super(currentST, ctx);

        for (ExprNode exprNode : exprNodeList) {
            if (exprNode.hasErrors()) {
                setError();
                return;
            }
        }

        this.exprNodeList = exprNodeList;
        this.ident = ctx.IDENT().getText();

        check();
    }

    public void check() {
        VariableObj variableObj = currentST.lookupAll(ident, VariableObj.class);

        if (variableObj == null) {
            addSemanticError(CompileTimeError
                    .VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ident);
            return;
        }

        if (!(variableObj.getType() instanceof ArrayObj)) {
            addSemanticError(CompileTimeError.EXPECTED_ARRAY_CALL,
                    variableObj.getType().toString());
            return;
        }

        ArrayObj arrayType = (ArrayObj) variableObj.getType();

        type = arrayType.getTypeOfDim(ctx.CLOSE_SQUARE_BRACKET().size());

        if (type == null) {
            addSemanticError(CompileTimeError.INVALID_DIMENSION_NUMBER_ARRAY);
            return;
        }

        for (ExprNode expr : exprNodeList) {
            if (!(expr.getType() instanceof IntObj)) {
                addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR, new
                        IntObj().toString(), expr.getType().toString());
                return;
            }
        }
    }

    public String getIdent() {
        return ident;
    }

    public List<ExprNode> getExprNodeList() {
        return exprNodeList;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new LinkedList<>();

        instructions.addAll(CodeGenerator.getArrayPointer(codeGenRef, availableRegisters,
                exprNodeList, type, currentST, ident));
        Register reg1 = availableRegisters.get(0);

        instructions.add(new BaseInstruction(Ins.getLdrInstruction(type), reg1, new StackLocation(reg1)));

        return instructions;
    }
}
