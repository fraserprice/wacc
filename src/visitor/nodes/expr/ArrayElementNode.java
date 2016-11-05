package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class ArrayElementNode extends ExprNode {

    public ArrayElementNode(SymbolTable currentST, IdentNode variable, ExprNode expr) {
        super(currentST);
    }
}
