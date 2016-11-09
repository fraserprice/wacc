package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;
import visitor.nodes.ExprNode;

public class PairElemNode extends Node {
    private TypeObj type;

    public PairElemNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode expr) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }
}
