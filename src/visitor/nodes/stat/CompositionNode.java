package visitor.nodes.stat;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class CompositionNode extends StatNode<WACCParser
        .CompositionStatContext> {
    private StatNode firstStatNode;
    private StatNode secondStatNode;

    public CompositionNode(SymbolTable currentST, WACCParser
            .CompositionStatContext ctx, StatNode firstStatNode, StatNode
            secondStatNode) {
        super(currentST, ctx);

        if (firstStatNode.hasErrors() || secondStatNode.hasErrors()) {
            setError();
            return;
        }

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
