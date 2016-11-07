package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class WhileNode extends StatNode {
    public WhileNode(SymbolTable currentST, ExprNode exprNode, StatNode statNode) {
        super(currentST);
    }
}
