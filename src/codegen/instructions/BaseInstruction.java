package codegen.instructions;

import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.Operand;
import codegen.instructions.Ins;

public class BaseInstruction implements Instruction {
    private Operand[] ops;
    private Ins instr;

    public BaseInstruction(Ins instr, Operand... ops) {
        assert (ops.length >= 1): "BaseInstruction needs at least 1 operand";
        this.ops = ops;
        this.instr = instr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t").append(String.format(CodeGenerator.INSTRUCTION_NAME_FORMAT, instr.toString()));

        for (int i = 0; i < ops.length - 1; i++) {
            sb.append(ops[i].toString()).append(", ");
        }

        sb.append(ops[ops.length - 1]).append("\n");
        return sb.toString();
    }
}
