package visitor.nodes.stat;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class SkipNode extends StatNode<WACCParser.SkipStatContext> {
    public SkipNode(SymbolTable currentST, WACCParser.SkipStatContext ctx) {
        super(currentST, ctx);
    }
}
