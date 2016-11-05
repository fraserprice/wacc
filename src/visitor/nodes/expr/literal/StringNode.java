package visitor.nodes.expr.literal;

import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class StringNode extends LiteralNode {

    public StringNode(SymbolTable currentST, String representation) {
        super(currentST, representation);
    }
}
