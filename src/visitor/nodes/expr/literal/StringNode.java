package visitor.nodes.expr.literal;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ArrayObj;
import visitor.nodes.expr.LiteralNode;

public class StringNode extends LiteralNode<WACCParser.StrLiteralContext> {

    public StringNode(SymbolTable currentST, WACCParser.StrLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("string", ArrayObj.class);
    }
}
