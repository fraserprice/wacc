package visitor.nodes;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;

/**
 * Type might be null if there are semantic errors
 */
public abstract class ExprNode<T extends ParserRuleContext> extends Node<T> {
    protected TypeObj type;
    protected int weight;

    public ExprNode(SymbolTable currentST, T ctx) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}
