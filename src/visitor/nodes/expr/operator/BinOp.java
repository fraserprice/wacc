package visitor.nodes.expr.operator;

import org.antlr.v4.runtime.tree.TerminalNode;

public enum BinOp {
    MULTIPLY, DIVISION, MODULO, PLUS, MINUS, GREATER, GREATER_EQ, SMALLER, SMALLER_EQ, EQ, NOT_EQ, AND, OR;
}
