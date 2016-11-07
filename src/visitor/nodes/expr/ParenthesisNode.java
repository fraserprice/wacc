package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class ParenthesisNode extends ExprNode {

    public ParenthesisNode(SymbolTable currentST, ExprNode argument) {
        super(currentST);
    }
}
