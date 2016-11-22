package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.operands.*;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssignRhsNewPairNode extends AssignRhsNode<WACCParser.AssignRhsNewPairContext> {
    private ExprNode firstExpr;
    private ExprNode secondExpr;

    // assignRhs: NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    public AssignRhsNewPairNode(SymbolTable currentST, WACCParser.AssignRhsNewPairContext
            ctx, ExprNode first, ExprNode second) {
        super(currentST, ctx);

        this.firstExpr = first;
        this.secondExpr = second;

        if (first.hasErrors() || second.hasErrors()) {
            setError();
            return;
        }

        this.type = new PairObj(first.getType(), second.getType());
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

        Register first  = availableRegisters.get(0);
        Register second = availableRegisters.get(1);
        List<Register> newAvailableRegisters = availableRegisters.stream().skip(1).collect(Collectors.toList());

        instructions.add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate(8)));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp("malloc")));
        instructions.add(new BaseInstruction(Ins.MOV, first, Register.R0));
        instructions.addAll(firstExpr.generateInstructions(codeGenRef, newAvailableRegisters));
        instructions.add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate(firstExpr.getType().getSize())));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp("malloc")));
        instructions.add(new BaseInstruction(Ins.getStrInstruciton(firstExpr.getType()),
                second, new StackLocation(Register.R0)));
        instructions.add(new BaseInstruction(Ins.STR, Register.R0, new StackLocation(first)));

        instructions.addAll(secondExpr.generateInstructions(codeGenRef, newAvailableRegisters));
        instructions.add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate(secondExpr.getType().getSize())));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp("malloc")));
        instructions.add(new BaseInstruction(Ins.getStrInstruciton(secondExpr.getType()),
                second, new StackLocation(Register.R0)));
        instructions.add(new BaseInstruction(Ins.STR, Register.R0, new StackLocation(first, new Offset(4))));

        return instructions;
    }
}
