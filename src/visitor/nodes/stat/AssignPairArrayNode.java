package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;

// TODO
public class AssignPairArrayNode extends StatNode {

    public AssignPairArrayNode(SymbolTable currentST, ParserRuleContext ctx, AssignLhsNode assignLhsNode, AssignRhsNode assignRhsNode) {
        super(currentST, ctx);
    }
}
