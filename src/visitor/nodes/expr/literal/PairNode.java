package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.expr.LiteralNode;

public class PairNode extends LiteralNode {

    public PairNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        //TODO: this.type = new PairObj(currentST)
    }
}
