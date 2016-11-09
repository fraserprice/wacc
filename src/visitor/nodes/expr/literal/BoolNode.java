package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.expr.LiteralNode;

public class BoolNode extends LiteralNode {
    public BoolNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        type = (BoolObj) currentST.lookupAll("bool");
    }
}
