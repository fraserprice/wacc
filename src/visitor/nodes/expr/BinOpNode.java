package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.BinOp;

public class BinOpNode extends ExprNode {
    public BinOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode lhs, BinOp binOperator, ExprNode rhs) {
        super(currentST, ctx);
    }
}
