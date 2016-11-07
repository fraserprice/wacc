package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

// TODO
public class ScopeBlockNode extends StatNode {
    public ScopeBlockNode(SymbolTable currentST, ParserRuleContext ctx, StatNode statNode) {
        super(currentST, ctx);
    }
}
