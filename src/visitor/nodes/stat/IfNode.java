package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class IfNode extends StatNode {
    public IfNode(SymbolTable currentST, ExprNode exprNode, StatNode thenStat, StatNode elseStat) {
        super(currentST);
    }
}
