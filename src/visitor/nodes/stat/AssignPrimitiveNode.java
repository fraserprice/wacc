package visitor.nodes.stat;

import symobjects.SymbolTable;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;
import visitor.nodes.type.TypeNode;
import visitor.nodes.expr.IdentNode;

// TODO
public class AssignPrimitiveNode extends StatNode {
    public AssignPrimitiveNode(SymbolTable currentST, TypeNode type, IdentNode ident, AssignRhsNode assignRhs) {
        super(currentST);
    }
}
