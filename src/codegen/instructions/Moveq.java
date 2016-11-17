package codegen.instructions;

import codegen.Instruction;
import codegen.Operand;
import codegen.operands.Register;

public class Moveq implements Instruction{

    private String dest;
    private String src;

    /**
     * This instruction will move data into register only if the zero flag is
     * set.
     * NB: Use this instruction when generation runtime error checking code.
     */
    public Moveq(Register dest, Operand src) {
        this.dest = dest.toString();
        this.src = src.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("MOVEQ ").append(dest).append(", ").append(src);
        return sb.toString();
    }
}
