package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class ScopeBlockNode extends StatNode {
    private StatNode body;

    public ScopeBlockNode(SymbolTable currentST, ParserRuleContext ctx, StatNode statNode) {
        super(currentST, ctx);
        this.body = statNode;
    }

    public StatNode getBody() {
        return body;
    }
}
