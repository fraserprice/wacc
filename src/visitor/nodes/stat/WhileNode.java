package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class WhileNode extends StatNode {
    public WhileNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode exprNode, StatNode statNode) {
        super(currentST, ctx);
    }
}
