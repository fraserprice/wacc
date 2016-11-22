package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.PairElemNode;

public class AssignLhsPairElemNode extends AssignLhsNode<WACCParser.AssignLhsPairElemContext> {

    // assignLhs; pairElem
    public AssignLhsPairElemNode(SymbolTable currentST, WACCParser.AssignLhsPairElemContext
            ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        if (pairElem.hasErrors()) {
            setError();
            return;
        }

        type = pairElem.getType();
    }
}
