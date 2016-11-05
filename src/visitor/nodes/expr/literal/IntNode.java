package visitor.nodes.expr.literal;

import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class IntNode extends LiteralNode {

    public IntNode(SymbolTable currentST, String representation) {
        super(currentST, representation);
    }
}
