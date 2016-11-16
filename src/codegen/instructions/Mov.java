package codegen.instructions;

import codegen.operands.Register;
import codegen.Instruction;

public class Mov implements Instruction {

    private Register dest;
    private Register src;

    public Mov(Register dest, Register src) {
        this.dest = dest;
        this.src = src;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("MOV ").append(dest.toString()).append(", ").append(src.toString());
        return sb.toString();
    }
}
