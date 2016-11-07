package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;

// TODO
public class AssignPairArrayNode extends StatNode {

    public AssignPairArrayNode(SymbolTable currentST, AssignLhsNode assignLhsNode, AssignRhsNode assignRhsNode) {
        super(currentST);
    }
}
