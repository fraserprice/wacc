package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.UnOp;

// TODO
public class UnaryOpNode extends ExprNode {
    public UnaryOpNode(SymbolTable currentST, ParserRuleContext ctx, UnOp unaryOperator, ExprNode argument) {
        super(currentST, ctx);
    }
}
