package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;
import visitor.nodes.type.TypeNode;
import visitor.nodes.expr.IdentNode;

// TODO
public class AssignPrimitiveNode extends StatNode {
    public AssignPrimitiveNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode type, IdentNode ident, AssignRhsNode assignRhs) {
        super(currentST, ctx);
    }
}
