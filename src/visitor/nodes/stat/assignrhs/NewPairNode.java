package visitor.nodes.stat.assignrhs;

import symobjects.SymbolTable;
import visitor.nodes.stat.AssignRhsNode;
import visitor.nodes.ExprNode;

/**
 * Created by Toma Alexandru on 05/11/2016.
 */
public class NewPairNode extends AssignRhsNode {
    public NewPairNode(SymbolTable currentST, ExprNode fst, ExprNode snd) {
        super(currentST);
    }
}
