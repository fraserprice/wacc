package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class PrintlnNode extends StatNode {
    public PrintlnNode(SymbolTable currentST, ExprNode exprNode) {
        super(currentST);
    }
}
