package visitor.nodes;

import symobjects.SymbolTable;
import visitor.Node;

public abstract class ExprNode extends Node {

    public ExprNode(SymbolTable currentST) {
        super(currentST);
    }
}
