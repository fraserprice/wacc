package visitor.nodes.type;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.Node;

// TODO
public class BaseTypeNode extends Node {
    public BaseTypeNode(SymbolTable currentST, TerminalNode type) {
        super(currentST);
    }
}
