package codegen.instructions;

import codegen.Instruction;
import codegen.Operand;

public class BaseInstruction implements Instruction {
    public static final String INSTRUCTION_NAME_FORMAT = "%-6s";
    private Operand[] ops;
    private Ins instr;

    /**
     * BaseInstruction is class which deals with all possible instructions defined
     * for WACC (Example: ADD, ADDS, BEQ, BL, CMP, LDR, etc.)
     * @param instr name
     * @param ops - optional list of operands (Example: immediate operand, constants, etc.)
     */
    public BaseInstruction(Ins instr, Operand... ops) {
        assert (ops.length >= 1): "BaseInstruction needs at least 1 operand";
        this.ops = ops;
        this.instr = instr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(String.format(INSTRUCTION_NAME_FORMAT, instr.toString()));

        for (int i = 0; i < ops.length - 1; i++) {
            sb.append(ops[i].toString()).append(", ");
        }

        sb.append(ops[ops.length - 1]).append("\n");
        return sb.toString();
    }
}
