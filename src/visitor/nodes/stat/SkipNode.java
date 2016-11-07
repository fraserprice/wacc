package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

// TODO
public class SkipNode extends StatNode {
    public SkipNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
    }
}
