package codegen.operands;

import codegen.Operand;

public class StackLocation implements Operand {

    private int offset;

    public StackLocation(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[sp, #").append(offset).append("]");
        return sb.toString();
    }

}
