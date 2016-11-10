package visitor.nodes.expr.literal;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

public class CharNode extends LiteralNode<WACCParser.CharLiteralContext> {
    public CharNode(SymbolTable currentST, WACCParser.CharLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("char", CharObj.class);
    }
}
