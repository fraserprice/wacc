package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

import java.util.ArrayList;
import java.util.List;

public class AssignRhsCallFuncNode extends AssignRhsNode<WACCParser.AssignRhsCallFuncContext> {
    private List<ExprNode> args;
    private String ident;

    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsCallFuncNode(SymbolTable currentST, WACCParser.AssignRhsCallFuncContext
            ctx, List<ExprNode> args) {
        super(currentST, ctx);
        this.args = args;
        this.ident = ctx.IDENT().getText();

        for (ExprNode exprNode : args) {
            if (exprNode.hasErrors()) {
                setError();
                return;
            }
        }

        FunctionObj func = currentST.lookupAll(this.ident, FunctionObj.class);

        if (func == null) {
            addSemanticError(CompileTimeError.FUNCTION_NOT_DEFINED, ident);
            return;
        }

        this.type = func.getReturnType();

        if (func.getParams().size() != args.size()) {
            addSemanticError(CompileTimeError.WRONG_NUMBER_OF_PARAMS, "" +
                    func.getParams().size(), "" + args.size());
            return;
        }

        for (int i = 0; i < func.getParams().size(); i++) {
            TypeObj param = func.getParams().get(i).getType();
            TypeObj argument = args.get(i).getType();

            if (param == null || argument == null) {
                setError();
                return;
            }

            if (!param.equals(argument)) {
                addSemanticError(CompileTimeError
                        .PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE, "" + (i + 1),
                        this.ident, param.toString(), argument.toString());
            }
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

        int totalSpaceSize = 0;
        for (int i = args.size() - 1; i >= 0; i--) {
            ExprNode arg = args.get(i);
            instructions.addAll(arg.generateInstructions(codeGenRef, availableRegisters));
            instructions.add(new BaseInstruction(Ins.getStrInstruciton(arg.getType()),
                    availableRegisters.get(0),
                    new StackLocation(true, Register.SP, new Offset(-arg.getType().getSize()))));
            totalSpaceSize += arg.getType().getSize();
        }
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp("f_" + ident)));
        // restore space
        instructions.add(new BaseInstruction(Ins.ADD, Register.SP, Register.SP, new Offset(totalSpaceSize)));
        instructions.add(new BaseInstruction(Ins.MOV, availableRegisters.get(0), Register.R0));

        return instructions;
    }
}
