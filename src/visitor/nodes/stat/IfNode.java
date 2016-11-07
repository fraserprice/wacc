package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class IfNode extends StatNode {
    public IfNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode exprNode, StatNode thenStat, StatNode elseStat) {
        super(currentST, ctx);
    }
}
