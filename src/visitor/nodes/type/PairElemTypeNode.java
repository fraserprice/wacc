package visitor.nodes.type;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.TypeNode;

/**
 * Created by Toma Alexandru on 05/11/2016.
 */
public class PairElemTypeNode extends Node {

    public PairElemTypeNode(SymbolTable currentST, TerminalNode baseType) {
        super(currentST);
    }

    public PairElemTypeNode(SymbolTable currentST, TypeNode type) {
        super(currentST);
    }

    public PairElemTypeNode(SymbolTable currentST) {
        super(currentST);
    }
}
