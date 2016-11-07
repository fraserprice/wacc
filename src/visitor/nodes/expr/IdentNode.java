package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class IdentNode extends ExprNode {
    private String represenatation;

    public IdentNode(SymbolTable currentST, String representation) {
        super(currentST);
        this.represenatation = representation;
    }
}
