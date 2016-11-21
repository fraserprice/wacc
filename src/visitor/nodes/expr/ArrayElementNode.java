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

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new LinkedList<>();
        Register reg1 = availableRegisters.get(0);
        Register reg2 = availableRegisters.get(1);
        int elemSize = type.getSize();
        int offset = currentST.lookupOffset(ident);

        instructions.add(new BaseInstruction(Ins.ADD, reg1, new Offset(offset)));

        for(int i = 0; i < exprNodeList.size(); i++) {
            List<Register> temp = availableRegisters;
            temp.remove(0);
            instructions.addAll(exprNodeList.get(i).generateInstructions(codeGenRef, temp));
            instructions.add(new BaseInstruction(Ins.LDR, reg1, new StackLocation(reg1)));
            instructions.add(new BaseInstruction(Ins.MOV, Register.R0, reg2));
            instructions.add(new BaseInstruction(Ins.MOV, Register.R1, reg1));
            instructions.add(new BaseInstruction(Ins.BL, new LabelOp(CheckArrayBounds.FUNC_NAME)));
            instructions.add(new BaseInstruction(Ins.AND, reg1, reg1, new Offset(4)));
            if(i == exprNodeList.size() - 1 && elemSize < 4) {
                instructions.add(new BaseInstruction(Ins.ADD, reg1, reg1, reg2));
            } else {
                instructions.add(new BaseInstruction(Ins.ADD, reg1 , reg1, reg2));
            }
        }

        instructions.add(new BaseInstruction(Ins.LDR, reg1, new StackLocation(reg1)));

        return instructions;
    }
}
