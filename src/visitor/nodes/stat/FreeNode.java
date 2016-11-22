package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.libfuncs.runtimeerror.FreeArray;
import codegen.libfuncs.runtimeerror.FreePair;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.ArrayList;
import java.util.List;

public class FreeNode extends StatNode<WACCParser.FreeStatContext> {

    private ExprNode exprNode;

    public FreeNode(SymbolTable currentST, WACCParser.FreeStatContext ctx,
                    ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.exprNode = exprNode;

        check(exprNode);
    }

    private void check(ExprNode exprNode) {
        if (!(exprNode.getType() instanceof PairObj)) {
            addSemanticError(CompileTimeError.INVALID_FREE_VALUE, exprNode
                    .getType().toString());
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef
            , List<Register> availableRegisters) {

        assert (!availableRegisters.isEmpty())
                : "Available Registers should always have at least one element";
        List<Instruction> instructions = new ArrayList<>();

        instructions.addAll(exprNode.generateInstructions(codeGenRef, availableRegisters));
        instructions.add(new BaseInstruction(Ins.MOV, Register.R0, availableRegisters.get(0)));
        if(exprNode.getType() instanceof ArrayObj) {
            instructions.add(new BaseInstruction(Ins.BL, new LabelOp(FreeArray.FUNC_NAME)));
        } else {
            instructions.add(new BaseInstruction(Ins.BL, new LabelOp(FreePair.FUNC_NAME)));
        }
        return instructions;
    }
}