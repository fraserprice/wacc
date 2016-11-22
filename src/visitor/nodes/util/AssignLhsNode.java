package visitor.nodes.util;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import visitor.Node;
import visitor.nodes.expr.ArrayElementNode;

public abstract class AssignLhsNode extends Node<WACCParser.AssignLhsContext> {
    protected TypeObj type;

    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext ctx) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }
}
