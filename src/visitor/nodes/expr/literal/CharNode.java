package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

public class CharNode extends LiteralNode {
    public CharNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = (CharObj) currentST.lookupAll("char");
    }
}
