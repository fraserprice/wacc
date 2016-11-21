package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import symobjects.SymbolTable;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.util.PairElemNode;

public class AssignRhsPairElemNode extends AssignRhsNode<WACCParser.AssignRhsPairElemContext> {
    // assignRhs: pairElem
    public AssignRhsPairElemNode(SymbolTable currentST, WACCParser.AssignRhsPairElemContext
            ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        if (pairElem.hasErrors()) {
            setError();
            return;
        }

        this.type = pairElem.getType();
    }

}
