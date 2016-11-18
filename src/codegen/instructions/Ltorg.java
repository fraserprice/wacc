package codegen.instructions;

import codegen.Instruction;

public class Ltorg implements Instruction {
    @Override
    public String toString() {
        return "\t.ltorg\n";
    }
}
