package visitor.nodes.expr;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class BinOpNode extends ExprNode {
    public BinOpNode(SymbolTable currentST, ExprNode lhs, TerminalNode operator, ExprNode rhs) {
        super(currentST);
    }
}
