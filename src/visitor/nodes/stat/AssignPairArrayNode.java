package visitor.nodes.stat;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;
import visitor.nodes.expr.ArrayElementNode;

public class AssignPairArrayNode extends StatNode {

    public AssignPairArrayNode(SymbolTable currentST, AssignLhsNode assignLhsNode, AssignRhsNode assignRhsNode) {
        super(currentST);
    }
}
