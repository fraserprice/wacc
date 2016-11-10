package visitor.nodes.stat;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class CompositionNode extends StatNode<WACCParser.CompositionStatContext> {
    private StatNode firstStatNode;
    private StatNode secondStatNode;

    public CompositionNode(SymbolTable currentST, WACCParser.CompositionStatContext ctx, StatNode firstStatNode, StatNode secondStatNode) {
        super(currentST, ctx);
        this.firstStatNode = firstStatNode;
        this.secondStatNode = secondStatNode;
    }

    public StatNode getFirstStatNode() {
        return firstStatNode;
    }

    public StatNode getSecondStatNode() {
        return secondStatNode;
    }
}
