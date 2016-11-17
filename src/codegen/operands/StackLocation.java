package codegen.operands;

import codegen.Operand;

public class StackLocation implements Operand {

    private String offset;

    public StackLocation(Offset offset) {
        this.offset = offset.toString();
    }

    public StackLocation() {
        this.offset = "";
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(offset.equals("")) {
            sb.append("[sp, #").append(offset).append("]");
        } else {
            sb.append("[sp]");
        }
        return sb.toString();
    }

}
