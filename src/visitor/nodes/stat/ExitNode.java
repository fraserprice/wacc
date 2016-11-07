package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

// TODO
public class ExitNode extends StatNode {

    public ExitNode(SymbolTable currentST, ExprNode expr) {
        super(currentST);
    }

}
