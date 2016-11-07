package visitor.nodes.expr.operator;

import org.antlr.v4.runtime.tree.TerminalNode;

public enum BinOp {
    MULTIPLY, DIVISION, MODULO, PLUS, MINUS, GREATER, GREATER_EQ, SMALLER, SMALLER_EQ, EQ, NOT_EQ, AND, OR;

    public static BinOp make(TerminalNode op) {
        switch (op.getText()) {
            case "*": return MULTIPLY;
            case "/": return DIVISION;
            case "%": return MODULO;
            case "+": return PLUS;
            case "-": return MINUS;
            case ">": return GREATER;
            case ">=": return GREATER_EQ;
            case "<": return SMALLER;
            case "<=": return SMALLER_EQ;
            case "==": return EQ;
            case "!=": return NOT_EQ;
            case "&&": return AND;
            case "||": return OR;
            default: return null;
        }
    }
}
