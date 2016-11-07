package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class ExitNode extends StatNode {

    public ExitNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode expr) {
        super(currentST, ctx);
    }

}
