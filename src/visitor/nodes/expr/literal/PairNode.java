package visitor.nodes.expr.literal;

import antlr.WACCParser;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.expr.LiteralNode;

public class PairNode extends LiteralNode<WACCParser.PairLiteralContext> {

    public PairNode(SymbolTable currentST, WACCParser.PairLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("null", PairObj.class);
    }
}
