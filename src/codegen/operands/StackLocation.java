package codegen.operands;

import codegen.Operand;

public class StackLocation implements Operand {
    private Operand[] ops;
    private boolean withExclamation;

    public StackLocation(Operand... ops) {
        this(false, ops);
    }

    public StackLocation(boolean withExclamation, Operand... ops) {
        assert (ops.length >= 1): "StackLocation should take at least one operand";
        this.ops = ops;
        this.withExclamation = withExclamation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < ops.length - 1; i++) {
            sb.append(ops[i].toString()).append(", ");
        }
        sb.append(ops[ops.length - 1]).append("]");

        if (withExclamation) {
            sb.append("!");
        }

        return sb.toString();
    }

}
