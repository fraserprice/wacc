package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.expr.ArrayElementNode;

public abstract class AssignLhsNode extends Node {
    public AssignLhsNode(SymbolTable currentST) {
        super(currentST);
    }

    public AssignLhsNode(SymbolTable currentST, ArrayElementNode arrayElem) {
        super(currentST);
    }

    public AssignLhsNode(SymbolTable currentST, ) {
        super(currentST);
    }

}
