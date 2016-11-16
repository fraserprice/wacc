package codegen.operands;

import codegen.Operand;

public class Offset implements Operand {

    private String value;

    public Offset(int value) {
        this.value = "#" + value;
    }

    @Override
    public String toString() {
        return value;
    }

}
