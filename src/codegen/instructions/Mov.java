package codegen.instructions;

import codegen.operands.Register;
import codegen.Instruction;

public class Mov implements Instruction {

    private String dest;
    private String src;

    public Mov(Register dest, Register src) {
        this.dest = dest.toString();
        this.src = src.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("MOV ").append(dest).append(", ").append(src);
        return sb.toString();
    }
}
