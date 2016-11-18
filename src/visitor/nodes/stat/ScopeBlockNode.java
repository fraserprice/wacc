package visitor.nodes.stat;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class ScopeBlockNode extends StatNode<WACCParser.ScopeBlockStatContext> {
    private StatNode body;

    public ScopeBlockNode(SymbolTable currentST, WACCParser
            .ScopeBlockStatContext ctx, StatNode statNode) {
        super(currentST, ctx);

        if (statNode.hasErrors()) {
            setError();
            return;
        }

        this.body = statNode;
    }

    public StatNode getBody() {
        return body;
    }
}
