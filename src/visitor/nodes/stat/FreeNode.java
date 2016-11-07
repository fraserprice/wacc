package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class FreeNode extends StatNode {
    public FreeNode(SymbolTable currentST, ExprNode exprNode) {
        super(currentST);
    }
}
