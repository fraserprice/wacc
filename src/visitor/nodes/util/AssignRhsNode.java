package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;

public abstract class AssignRhsNode<T extends ParserRuleContext> extends Node<T> {
    protected TypeObj type;

    public AssignRhsNode(SymbolTable currentST, T ctx) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }
}
