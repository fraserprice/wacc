package visitor.nodes.stat.assignrhs;

import symobjects.SymbolTable;
import visitor.nodes.stat.AssignRhsNode;
import visitor.nodes.ExprNode;

import java.util.List;

/**
 * Created by Toma Alexandru on 05/11/2016.
 */
public class CallFunctionNode extends AssignRhsNode {
    public CallFunctionNode(SymbolTable currentST, List<ExprNode> params) {
        super(currentST);
    }
}
