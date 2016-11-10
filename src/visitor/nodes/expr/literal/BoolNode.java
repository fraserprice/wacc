package visitor.nodes.expr.literal;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.expr.LiteralNode;

public class BoolNode extends LiteralNode<WACCParser.BoolLiteralContext> {
    public BoolNode(SymbolTable currentST, WACCParser.BoolLiteralContext ctx) {
        super(currentST, ctx);

        type = (BoolObj) currentST.lookupAll("bool");
    }
}
