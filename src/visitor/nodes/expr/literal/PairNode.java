package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.PairLitObj;
import visitor.nodes.expr.LiteralNode;

public class PairNode extends LiteralNode {

    public PairNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = (PairLitObj) currentST.lookupAll("pair");
    }
}
