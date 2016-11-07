package visitor.nodes.util;

import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.ExprNode;

// TODO
public class PairElemNode extends Node {
    public PairElemNode(SymbolTable currentST, ExprNode fst, ExprNode snd) {
        super(currentST);
    }
}
