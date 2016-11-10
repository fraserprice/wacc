package visitor.nodes.expr.literal;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.PairLitObj;
import visitor.nodes.expr.LiteralNode;

public class PairNode extends LiteralNode<WACCParser.PairLiteralContext> {

    public PairNode(SymbolTable currentST, WACCParser.PairLiteralContext ctx) {
        super(currentST, ctx);
        this.type = (PairLitObj) currentST.lookupAll("pair");
    }
}
