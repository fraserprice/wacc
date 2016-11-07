package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;

// TODO
public class ReadNode extends StatNode{

    public ReadNode(SymbolTable currentST, AssignLhsNode assignLhsNode) {
        super(currentST);
    }
}
