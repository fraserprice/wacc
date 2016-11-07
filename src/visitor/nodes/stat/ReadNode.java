package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;

// TODO
public class ReadNode extends StatNode{

    public ReadNode(SymbolTable currentST, ParserRuleContext ctx, AssignLhsNode assignLhsNode) {
        super(currentST, ctx);
    }
}
