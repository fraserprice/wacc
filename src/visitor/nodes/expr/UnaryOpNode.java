package visitor.nodes.expr;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class UnaryOpNode extends ExprNode {
    public UnaryOpNode(SymbolTable currentST, TerminalNode operator, ExprNode argument) {
        super(currentST);
    }
}
