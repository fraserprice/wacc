package visitor.nodes.stat;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class PrintlnNode extends StatNode<WACCParser.PrintlnStatContext> {

    public PrintlnNode(SymbolTable currentST, WACCParser.PrintlnStatContext ctx, ExprNode exprNode) {
        super(currentST, ctx);
    }
}
