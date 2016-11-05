package visitor.nodes.expr.literal;

import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class BoolNode extends LiteralNode {

    public BoolNode(SymbolTable currentST, String representation) {
        super(currentST, representation);
    }
}
