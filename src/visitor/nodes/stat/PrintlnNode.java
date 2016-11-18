package visitor.nodes.stat;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class PrintlnNode extends StatNode<WACCParser.PrintlnStatContext> {

    public PrintlnNode(SymbolTable currentST, WACCParser.PrintlnStatContext
            ctx, ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }
    }
}
