package visitor.nodes.stat;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.ExprNode;
import visitor.nodes.TypeNode;
import visitor.nodes.expr.IdentNode;
import visitor.nodes.stat.assignrhs.CallFunctionNode;
import visitor.nodes.stat.assignrhs.NewPairNode;

import java.util.List;

public abstract class AssignRhsNode extends Node {
    public AssignRhsNode(SymbolTable currentST, ExprNode rhs) {
        super(currentST);
    }

    public AssignRhsNode(SymbolTable currentST, List<ExprNode> arrayArgs) {
        super(currentST);
    }

    public AssignRhsNode(SymbolTable currentST, NewPairNode rhs) {
        super(currentST);
    }

    public AssignRhsNode(SymbolTable currentST, TerminalNode side, ExprNode argument) {
        super(currentST);
    }

    public AssignRhsNode(SymbolTable currentST, CallFunctionNode rhs) {
        super(currentST);
    }
}
