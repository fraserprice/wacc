package codegen.operands;

import codegen.Operand;

public class LabelOp implements Operand {

    private String name;

    public LabelOp(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
