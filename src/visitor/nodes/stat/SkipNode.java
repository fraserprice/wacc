package visitor.nodes.stat;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class SkipNode extends StatNode<WACCParser.SkipStatContext> {
    public SkipNode(SymbolTable currentST, WACCParser.SkipStatContext ctx) {
        super(currentST, ctx);
    }
}
