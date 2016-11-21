package codegen.instructions;

import codegen.Instruction;

public class LabelIns implements Instruction {
    private String name;

    /**
     * Constructor for the label instruction
     * @param name of the label
     */
    public LabelIns(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ":\n";
    }
}
