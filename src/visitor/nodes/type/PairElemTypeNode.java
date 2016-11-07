package visitor.nodes.type;

import symobjects.SymbolTable;
import visitor.Node;

// TODO
public class PairElemTypeNode extends Node {
    // pairElemType: baseType
    public PairElemTypeNode(SymbolTable currentST, BaseTypeNode baseType) {
        super(currentST);
    }

    // pairElemType: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public PairElemTypeNode(SymbolTable currentST, TypeNode type) {
        super(currentST);
    }

    // pairElemType: PAIR
    public PairElemTypeNode(SymbolTable currentST) {
        super(currentST);
    }
}
