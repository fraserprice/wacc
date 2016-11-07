package visitor.nodes.expr;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.UnOp;

// TODO
public class UnaryOpNode extends ExprNode {
    public UnaryOpNode(SymbolTable currentST, UnOp unaryOperator, ExprNode argument) {
        super(currentST);
    }
}
