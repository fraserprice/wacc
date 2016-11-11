package visitor.nodes.stat;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class PrintNode extends StatNode<WACCParser.PrintStatContext> {

    public PrintNode(SymbolTable currentST, WACCParser.PrintStatContext ctx, ExprNode expr) {
        super(currentST, ctx);

        if(expr.hasErrors()) {
            setError();
            return;
        }
    }
}
