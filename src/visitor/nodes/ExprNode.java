package visitor.nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;

/**
 * Type might be null if there are semantic errors
 */
public abstract class ExprNode extends Node {
    protected TypeObj type;

    public ExprNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }
}
