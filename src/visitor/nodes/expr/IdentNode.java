package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

public class IdentNode extends ExprNode {
    private String represenatation;

    public IdentNode(SymbolTable currentST, ParserRuleContext ctx, String representation) {
        super(currentST, ctx);
        this.represenatation = representation;
    }
}
