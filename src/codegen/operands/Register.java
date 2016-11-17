package codegen.operands;

import codegen.Operand;
import java.util.LinkedHashSet;

public enum Register implements Operand {
    R0("r0"), R1("r1"), R2("r2"), R3("R3"), R4("R4"), R5("R5"), R6("R6"), R7("R7"), R8("R8"),
    R9("R9"), R10("R10"), R11("R11"), R12("R12"), R13("R13"), R14("R14"), R15("R15");

    private String representation;

    Register(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }

    public static LinkedHashSet<Register> allRegisters() {
        LinkedHashSet<Register> allRegisters = new LinkedHashSet<>();
        for(Register register : Register.values()) {
            allRegisters.add(register);
        }
        return allRegisters;
    }

}
