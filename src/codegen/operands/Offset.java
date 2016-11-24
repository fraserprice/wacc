package codegen.operands;

import codegen.Operand;

public class Offset implements Operand {
    public static final int MAXIMUM_OFFSET = 1024;

    private String value;

    public Offset(String value) {
        this.value = "#" + value;
    }

    public Offset(int value) {
        this.value = "#" + Integer.toString(value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
