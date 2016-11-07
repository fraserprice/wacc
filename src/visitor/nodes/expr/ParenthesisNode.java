package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

//TODO
public class ParenthesisNode extends ExprNode {

    //OPEN_PARANTHESIS expr CLOSE_PARANTHESIS
    public ParenthesisNode(SymbolTable currentST, ExprNode argument) {
        super(currentST);
    }
}
