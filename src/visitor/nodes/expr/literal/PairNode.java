package visitor.nodes.expr.literal;

import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class PairNode extends LiteralNode {

    public PairNode(SymbolTable currentST, String representation) {
        super(currentST, representation);
    }
}
