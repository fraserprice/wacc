package visitor.nodes.stat;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class PrintNode extends StatNode<WACCParser.PrintStatContext> {

    public PrintNode(SymbolTable currentST, WACCParser.PrintStatContext ctx,
                     ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }
    }
}
