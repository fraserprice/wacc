package visitor.nodes.stat;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;
import visitor.nodes.TypeNode;
import visitor.nodes.stat.assignrhs.CallFunctionNode;
import visitor.nodes.stat.assignrhs.NewPairNode;
import visitor.nodes.expr.IdentNode;

import java.util.List;

public class AssignPrimitiveNode extends StatNode {
    public AssignPrimitiveNode(SymbolTable currentST, TypeNode type, IdentNode ident, AssignRhsNode assignRhs) {
        super(currentST);
    }
}
