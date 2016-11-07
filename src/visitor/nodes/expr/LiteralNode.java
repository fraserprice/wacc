package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

// TODO
public abstract class LiteralNode extends ExprNode {
    protected String representation;

    public LiteralNode(SymbolTable currentST, String representation) {
        super(currentST);
        this.representation = representation;
    }
}
