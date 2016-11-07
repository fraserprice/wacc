package visitor.nodes;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.type.PairTypeNode;

/**
 * Created by Toma Alexandru on 05/11/2016.
 */
public class TypeNode extends Node {

    public TypeNode(SymbolTable currentST, TerminalNode baseType) {
        super(currentST);
    }

    public TypeNode(SymbolTable currentST, TypeNode type) {
        super(currentST);
    }

    public TypeNode(SymbolTable currentST, PairTypeNode pair) {
        super(currentST);
    }
}
