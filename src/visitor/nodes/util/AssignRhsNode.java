package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;
import visitor.nodes.ExprNode;

import java.util.List;

public class AssignRhsNode extends Node {
    private TypeObj type;

    // assignRhs: expr
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode rhs) {
        super(currentST, ctx);
    }

    // assignRhs: arrayLiteral
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> arrayArgs) {
        super(currentST, ctx);
    }

    // assignRhs: NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode first, ExprNode second) {
        super(currentST, ctx);
    }

    // assignRhs: pairElem
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, PairElemNode pairElem) {
        super(currentST, ctx);
    }

    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> args, String ident) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }
}
