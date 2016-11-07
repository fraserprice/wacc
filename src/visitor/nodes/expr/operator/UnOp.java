package visitor.nodes.expr.operator;

import org.antlr.v4.runtime.tree.TerminalNode;

public enum UnOp {
    PLUS, MINUS, NOT, LEN, CHR, ORD;

    public static UnOp make(TerminalNode op) {
        switch (op.getText()) {
            case "+": return PLUS;
            case "-": return MINUS;
            case "!": return NOT;
            case "len": return LEN;
            case "chr": return CHR;
            case "ord": return ORD;
            default: return null;
        }
    }
}
