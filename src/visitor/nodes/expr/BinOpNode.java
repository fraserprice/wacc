package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.BinOp;

public class BinOpNode extends ExprNode {
    public BinOpNode(SymbolTable currentST, ExprNode lhs, BinOp binOperator, ExprNode rhs) {
        super(currentST);
    }
}
