package visitor.nodes.util;

import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.type.TypeNode;
import visitor.nodes.expr.IdentNode;

// TODO
public class ParamNode extends Node {
    public ParamNode(SymbolTable currentST, TypeNode typeNode, IdentNode ident) {
        super(currentST);
    }
}
