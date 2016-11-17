package codegen.instructions;

import codegen.Instruction;
import codegen.Operand;
import codegen.operands.Register;

public class Add implements Instruction {

    private String dest;
    private String src1;
    private String src2;

    /**
     * This instruction will do addition without regardless to the state of
     * the flags and it won't change their state
     */
    public Add(Register r0, Operand src1, Operand r2) {
        this.dest = dest.toString();
        this.src1 = src1.toString();
        this.src2 = src2.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ADD ").append(dest).append(" ").append(src1).append
                (" ").append(src2);
        return sb.toString();
    }
}
