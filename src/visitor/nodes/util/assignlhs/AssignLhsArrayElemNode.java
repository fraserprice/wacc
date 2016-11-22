package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.expr.ArrayElementNode;
import visitor.nodes.util.AssignLhsNode;

public class AssignLhsArrayElemNode extends AssignLhsNode<WACCParser.AssignLhsArrayElemContext> {
    // assignLhs: arrayElem
    public AssignLhsArrayElemNode(SymbolTable currentST, WACCParser.AssignLhsArrayElemContext
            ctx, ArrayElementNode arrayElem) {
        super(currentST, ctx);

        if (arrayElem.hasErrors()) {
            setError();
            return;
        }

        type = arrayElem.getType();
    }
}
