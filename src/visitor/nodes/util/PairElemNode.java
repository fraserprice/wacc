package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.ExprNode;

// TODO
public class PairElemNode extends Node {
    public PairElemNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode fst, ExprNode snd) {
        super(currentST, ctx);
    }
}
