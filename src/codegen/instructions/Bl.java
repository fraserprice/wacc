package codegen.instructions;

import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.LabelOp;

public class Bl implements Instruction {

    private LabelOp label;

    public Bl(LabelOp label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "\t" + String.format(CodeGenerator.INSTRUCTION_NAME_FORMAT, "BL") + label.toString() + "\n";
    }
}
