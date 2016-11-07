package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

// TODO
public class ArrayElementNode extends ExprNode {

    public ArrayElementNode(SymbolTable currentST, ParserRuleContext ctx, IdentNode variable, ExprNode expr) {
        super(currentST, ctx);
    }
}
