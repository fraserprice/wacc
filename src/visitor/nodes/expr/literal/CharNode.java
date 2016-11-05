package visitor.nodes.expr.literal;

import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class CharNode extends LiteralNode {

    public CharNode(SymbolTable currentST, String representation) {
        super(currentST, representation);
    }
}
