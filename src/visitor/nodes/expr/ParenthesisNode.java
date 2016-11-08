package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class ParenthesisNode extends ExprNode {

    public ParenthesisNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode argument) {
        super(currentST, ctx);
        this.type = argument.getType();
    }
}
