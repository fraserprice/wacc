package codegen.instructions;

import codegen.Instruction;
import codegen.Operand;
import codegen.operands.Register;

public class Adds implements Instruction {

    private String dest;
    private String src1;
    private String src2;

    /**
     * This instruction will do addition, and it will set the S flag in the
     * instruction. This will update the state of the conditional flags.
     * NB: Use this instruction when generation runtime error checking code.
     */
    public Adds(Register dest, Operand src1, Operand src2) {
        this.dest = dest.toString();
        this.src1 = src1.toString();
        this.src2 = src2.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ADDS ").append(dest).append(" ").append(src1).append
                (" ").append(src2);
        return sb.toString();
    }
}
