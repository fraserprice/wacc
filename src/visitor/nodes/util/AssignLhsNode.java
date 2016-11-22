package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;

public abstract class AssignLhsNode<T extends ParserRuleContext> extends Node<T> {
    protected TypeObj type;
    protected String ident;

    public AssignLhsNode(SymbolTable currentST, T ctx) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }

    public String getIdent() {
        return ident;
    }
}
