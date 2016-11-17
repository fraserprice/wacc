package codegen.instructions;

import codegen.Instruction;

public class Bl implements Instruction {

    private String label;

    public Bl(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BL " + label;
    }
}
