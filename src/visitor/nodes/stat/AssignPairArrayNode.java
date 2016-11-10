package visitor.nodes.stat;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;

public class AssignPairArrayNode extends StatNode {
    private AssignLhsNode lhs;
    private AssignRhsNode rhs;

    public AssignPairArrayNode(SymbolTable currentST, ParserRuleContext ctx, AssignLhsNode assignLhsNode, AssignRhsNode assignRhsNode) {
        super(currentST, ctx);
        this.lhs = assignLhsNode;
        this.rhs = assignRhsNode;
        check();
    }

    private void check() {
        if (lhs == null) {
            return;
        }
        if (lhs.getType() == null) {
            return;
        }
        if (rhs == null) {
            return;
        }
        if (rhs.getType() == null) {
            return;
        }

        if (!lhs.getType().equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE);
            return;
        }
    }
}
