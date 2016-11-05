package visitor.nodes;

import symobjects.SymbolTable;
import visitor.Node;

public abstract class StatNode extends Node {
    public StatNode(SymbolTable currentST) {
        super(currentST);
    }
}
