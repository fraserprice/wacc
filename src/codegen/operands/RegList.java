package codegen.operands;

import codegen.Operand;

public class RegList implements Operand {
    private Operand[] ops;

    public RegList(Operand... ops) {
        assert (ops.length >= 1): "RegList should take at least one operand";
        this.ops = ops;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for(int i = 0; i < ops.length - 1; i++) {
            sb.append(ops[i].toString()).append(", ");
        }
        sb.append(ops[ops.length - 1]).append("}");
        return sb.toString();
    }
}
