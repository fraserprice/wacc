package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class ReturnNode extends StatNode {

    public ReturnNode(SymbolTable currentST, ExprNode exprNode) {
        super(currentST);
    }
}
