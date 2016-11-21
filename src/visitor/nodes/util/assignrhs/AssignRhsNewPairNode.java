package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

public class AssignRhsNewPairNode extends AssignRhsNode<WACCParser.AssignRhsNewPairContext> {
    // assignRhs: NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    public AssignRhsNewPairNode(SymbolTable currentST, WACCParser.AssignRhsNewPairContext
            ctx, ExprNode first, ExprNode second) {
        super(currentST, ctx);

        if (first.hasErrors() || second.hasErrors()) {
            setError();
            return;
        }

        this.type = new PairObj(first.getType(), second.getType());
    }
}
