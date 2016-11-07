package visitor.nodes.util;

import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.expr.ArrayElementNode;
import visitor.nodes.expr.IdentNode;

// TODO
public abstract class AssignLhsNode extends Node {

    // assignLhs: IDENT
    public AssignLhsNode(SymbolTable currentST, IdentNode name) {
        super(currentST);
    }

    // assignLhs: arrayElem
    public AssignLhsNode(SymbolTable currentST, ArrayElementNode arrayElem) {
        super(currentST);
    }

    // assignLhs; pairElem
    public AssignLhsNode(SymbolTable currentST, PairElemNode pairElem) {
        super(currentST);
    }
}
