package codegen.instructions;

import codegen.Instruction;
import codegen.operands.Register;

import java.util.List;

public class Push implements Instruction {

    private String registers;

    public Push(List<Register> registers) {
        StringBuffer sb = new StringBuffer();
        sb.append("{").append(registers.get(0).toString());
        for(int i = 1; i < registers.size(); i++) {
            sb.append(", ");
            sb.append(registers.get(i).toString());
        }
        sb.append("}");
        this.registers = sb.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("PUSH ").append(registers);
        return sb.toString();
    }
}
