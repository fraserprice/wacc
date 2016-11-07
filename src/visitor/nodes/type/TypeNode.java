package visitor.nodes.type;

import symobjects.SymbolTable;
import visitor.Node;

// TODO
public class TypeNode extends Node {
    // type: baseType
    public TypeNode(SymbolTable currentST, BaseTypeNode baseType) {
        super(currentST);
    }

    // type: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public TypeNode(SymbolTable currentST, TypeNode type) {
        super(currentST);
    }

    // type: PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES
    public TypeNode(SymbolTable currentST, PairElemTypeNode fstType, PairElemTypeNode sndType) {
        super(currentST);
    }
}
