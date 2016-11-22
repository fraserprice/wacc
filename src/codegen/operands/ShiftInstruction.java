package codegen.operands;

import codegen.Operand;
import codegen.instructions.Ins;

public class ShiftInstruction implements Operand {
    private Ins ins;
    private Operand[] ops;

    public ShiftInstruction(Ins ins, Operand... ops) {
        this.ins = ins;
        this.ops = ops;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ins).append(" ");

        for (int i = 0; i < ops.length - 1; i++) {
            sb.append(ops[i].toString()).append(", ");
        }

        sb.append(ops[ops.length - 1]);

        return sb.toString();
    }
}
