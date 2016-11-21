package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

public class AssignRhsExprNode extends AssignRhsNode<WACCParser.AssignRhsExprContext> {
    public AssignRhsExprNode(SymbolTable currentST, WACCParser.AssignRhsExprContext ctx, ExprNode rhs) {
        super(currentST, ctx);

        if (rhs.hasErrors()) {
            setError();
            return;
        }

        this.type = rhs.getType();
    }
}
