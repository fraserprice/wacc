package codegen;

import codegen.operands.Register;

import java.util.LinkedList;

public class RegisterSet {

    LinkedList<Register> registers;

    public RegisterSet(LinkedList<Register> registers) {
        this.registers = registers;
    }

    public RegisterSet registersBeingUsed(RegisterSet registersNotInUse) {
        return null;
    }

}
