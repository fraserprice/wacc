package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

// TODO
public abstract class LiteralNode extends ExprNode {
    public LiteralNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
    }
}
