package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class PrintlnNode extends StatNode {
    public PrintlnNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode exprNode) {
        super(currentST, ctx);
    }
}
