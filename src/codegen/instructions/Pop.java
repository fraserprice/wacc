package codegen.instructions;

import codegen.Instruction;
import codegen.operands.Register;

import java.util.List;

public class Pop implements Instruction {

    private List<Register> registers;

    public Pop(List<Register> registers) {
        this.registers = registers;
    }

    private String registerString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{").append(registers.get(0).toString());
        for(int i = 1; i < registers.size(); i++) {
            sb.append(", ");
            sb.append(registers.get(i).toString());
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("POP ").append(registerString());
        return sb.toString();
    }
}
