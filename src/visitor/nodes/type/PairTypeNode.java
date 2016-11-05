package visitor.nodes.type;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.Node;

/**
 * Created by Toma Alexandru on 05/11/2016.
 */
public class PairTypeNode extends Node {

    public PairTypeNode(SymbolTable currentST, PairElemTypeNode type1, PairElemTypeNode type2) {
        super(currentST);
    }
}
