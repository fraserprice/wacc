package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.StatNode;

public class SkipNode extends StatNode {
    public SkipNode(SymbolTable currentST) {
        super(currentST);
    }
}
