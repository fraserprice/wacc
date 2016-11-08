package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

public class CharNode extends LiteralNode {

    public CharNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = new CharObj(currentST);
    }
}
