package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.StatNode;

// TODO
public class CompositionNode extends StatNode {
    public CompositionNode(SymbolTable currentST, StatNode firstStatNode, StatNode secondStatNode) {
        super(currentST);
    }
}
