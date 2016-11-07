package visitor.nodes.util;

import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.IdentNode;

import java.util.List;

// TODO
public class AssignRhsNode extends Node {
    // assignRhs: expr
    public AssignRhsNode(SymbolTable currentST, ExprNode rhs) {
        super(currentST);
    }

    // assignRhs: arrayLiteral
    public AssignRhsNode(SymbolTable currentST, List<ExprNode> arrayArgs) {
        super(currentST);
    }

    // assignRhs: NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, ExprNode first, ExprNode second) {
        super(currentST);
    }

    // assignRhs: pairElem
    public AssignRhsNode(SymbolTable currentST, PairElemNode pairElem) {
        super(currentST);
    }

    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, IdentNode name, List<ExprNode> args) {
        super(currentST);
    }
}
