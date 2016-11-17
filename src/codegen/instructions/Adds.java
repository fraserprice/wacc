package codegen.instructions;

import codegen.Instruction;
import codegen.Operand;
import codegen.operands.Register;

public class Adds extends Add implements Instruction {

    /**
     * This instruction will do addition, and it will set the S flag in the
     * instruction. This will update the state of the conditional flags.
     * NB: Use this instruction when generation runtime error checking code.
     */
    public Adds(Register dest, Operand src1, Operand src2) {
        super(dest, src1, src2);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ADDS ").append(dest).append(" ").append(src1).append
                (" ").append(src2);
        return sb.toString();
    }
}
