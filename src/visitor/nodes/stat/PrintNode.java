package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class PrintNode extends StatNode {

    public PrintNode(SymbolTable currentST, ExprNode expr) {
        super(currentST);
    }
}
