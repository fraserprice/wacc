package visitor.nodes.expr;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

// TODO
public abstract class LiteralNode extends ExprNode {
    protected TerminalNode representation;

    public LiteralNode(SymbolTable currentST, TerminalNode representation) {
        super(currentST);
        this.representation = representation;
    }
}
