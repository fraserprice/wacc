package visitor.nodes.expr;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class ParenthesisNode extends ExprNode<WACCParser.ParanthesisExprContext> {

    public ParenthesisNode(SymbolTable currentST, WACCParser.ParanthesisExprContext ctx, ExprNode argument) {
        super(currentST, ctx);

        if (argument.hasErrors()) {
            setError();
        }

        this.type = argument.getType();

    }
}
