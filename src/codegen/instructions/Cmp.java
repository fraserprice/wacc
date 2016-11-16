package codegen.instructions;

import codegen.Operand;
import codegen.operands.Register;
import codegen.Instruction;

public class Cmp implements Instruction {

    private String firstOperand;
    private String secondOperand;

    public Cmp(Register r1, Operand operand) {
        this.firstOperand = r1.toString();
        this.secondOperand = operand.toString();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("CMP ").append(firstOperand).append(", ").append(secondOperand);
        return sb.toString();
    }
}
