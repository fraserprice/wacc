package codegen.operands;

import codegen.Operand;

public class Immediate implements Operand {

    private String value;

    public Immediate(int value) {
        this.value = "=" + Integer.toString(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
