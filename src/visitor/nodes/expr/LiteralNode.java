package visitor.nodes.expr;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public abstract class LiteralNode<T extends WACCParser.LiteralContext> extends ExprNode<T> {
    public LiteralNode(SymbolTable currentST, T ctx) {
        super(currentST, ctx);
    }
}
