package codegen.operands;

import codegen.Operand;

public class Offset implements Operand {

    private String value;

    public Offset(int value) {
        this.value = "#" + Integer.toString(value);
    }

    @Override
    public String toString() {
        return this.value;
    }

}
