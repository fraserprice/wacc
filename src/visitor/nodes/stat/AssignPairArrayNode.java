package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class AssignPairArrayNode extends StatNode<WACCParser
        .AssignPairArrayStatContext> {
    private AssignLhsNode lhs;
    private AssignRhsNode rhs;

    public AssignPairArrayNode(SymbolTable currentST, WACCParser
            .AssignPairArrayStatContext ctx, AssignLhsNode assignLhsNode,
                               AssignRhsNode assignRhsNode) {
        super(currentST, ctx);

        if (assignLhsNode.hasErrors() || assignRhsNode.hasErrors()) {
            setError();
            return;
        }

        this.lhs = assignLhsNode;
        this.rhs = assignRhsNode;

        check();
    }

    private void check() {
        if (!lhs.getType().equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                    "Left hand side: ", lhs.getType().toString(), "Right hand" +
                            " side: ", rhs.getType().toString());
        }
    }
}
