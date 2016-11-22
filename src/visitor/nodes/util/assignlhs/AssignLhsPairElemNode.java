package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.runtimeerror.CheckNullPointer;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.PairElemNode;

import java.util.LinkedList;
import java.util.List;

public class AssignLhsPairElemNode extends AssignLhsNode<WACCParser.AssignLhsPairElemContext> {

    private WACCParser.PairElemContext pairCtx;

    // assignLhs; pairElem
    public AssignLhsPairElemNode(SymbolTable currentST, WACCParser.AssignLhsPairElemContext
            ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        if (pairElem.hasErrors()) {
            setError();
            return;
        }

        this.type = pairElem.getType();
        this.pairCtx = pairElem.getCtx();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new LinkedList<>();
        Register reg = availableRegisters.get(0);

        int offset = currentST.lookupOffset(pairCtx.expr().getText());
        StackLocation sl = null;

        if(offset == 0) {
            sl = new StackLocation(Register.SP);
        } else {
            sl = new StackLocation(Register.SP, new Offset(offset));
        }

        instructions.add(new BaseInstruction(Ins.LDR, reg, sl));
        instructions.add(new BaseInstruction(Ins.MOV, Register.R0, reg));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp(CheckNullPointer.FUNC_NAME)));

        if(pairCtx.SND() == null) {
            instructions.add(new BaseInstruction(Ins.LDR, reg, new StackLocation(reg)));
        } else {
            instructions.add(new BaseInstruction(Ins.LDR, reg, new StackLocation(reg, new Offset(4))));
        }

        return instructions;
    }
}
