package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

//TODO
public class ParenthesisNode extends ExprNode {

    //OPEN_PARANTHESIS expr CLOSE_PARANTHESIS
    public ParenthesisNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode argument) {
        super(currentST, ctx);
    }
}
