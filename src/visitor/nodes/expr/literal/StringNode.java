package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.StringObj;
import visitor.nodes.expr.LiteralNode;

public class StringNode extends LiteralNode {

    public StringNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = (StringObj) currentST.lookupAll("string");
    }
}
