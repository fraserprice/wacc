package codegen.operands;

import codegen.Instruction;
import codegen.Operand;
import codegen.instructions.Ins;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ShiftOp implements Operand {

    private Ins instruction;
    private List<Operand> ops;

    public ShiftOp(Ins instruction, Operand... ops) {
        this.instruction = instruction;
        this.ops = new LinkedList<>();
        Collections.addAll(this.ops, ops);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(instruction);
        for(Operand op : ops) {
            sb.append(" ").append(op.toString());
        }
        return sb.toString();
    }
}
