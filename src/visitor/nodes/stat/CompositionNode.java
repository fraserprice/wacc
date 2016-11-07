package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

// TODO
public class CompositionNode extends StatNode {
    public CompositionNode(SymbolTable currentST, ParserRuleContext ctx, StatNode firstStatNode, StatNode secondStatNode) {
        super(currentST, ctx);
    }
}
