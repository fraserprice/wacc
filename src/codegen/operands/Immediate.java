package codegen.operands;

import codegen.Operand;

public class Immediate implements Operand {

    private String value;

    public Immediate(String value) {
        this.value = "=" + value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
