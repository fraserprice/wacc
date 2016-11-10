package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;

public class AssignPairArrayNode extends StatNode<WACCParser.AssignPairArrayStatContext> {
    private AssignLhsNode lhs;
    private AssignRhsNode rhs;

    public AssignPairArrayNode(SymbolTable currentST, WACCParser.AssignPairArrayStatContext ctx, AssignLhsNode assignLhsNode, AssignRhsNode assignRhsNode) {
        super(currentST, ctx);
        this.lhs = assignLhsNode;
        this.rhs = assignRhsNode;

        if (!assignLhsNode.hasErrors() && !assignRhsNode.hasErrors()) {
            check();
        }
    }

    private void check() {
        assert (lhs != null): "AssignPairArrayNode: lhs can't be null";
        assert (lhs.getType() != null): "AssignPairArrayNode: lhs needs a type";
        assert (rhs != null): "AssignPairArrayNode: rhs can't be null";
        assert (rhs.getType() != null): "AssignPairArrayNode: rhs needs a type";

        if (!lhs.getType().equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE);
            return;
        }
    }
}
