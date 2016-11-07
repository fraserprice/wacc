package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.StatNode;

// TODO
public class ScopeBlockNode extends StatNode {
    public ScopeBlockNode(SymbolTable currentST, StatNode statNode) {
        super(currentST);
    }
}
