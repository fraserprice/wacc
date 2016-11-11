package visitor.nodes.type;

import antlr.WACCParser;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;

public class PairElemTypeNode extends Node<WACCParser.PairElemTypeContext> {
    private TypeObj type;

    // pairElemType: baseType
    public PairElemTypeNode(SymbolTable currentST, WACCParser.PairElemTypeContext ctx, BaseTypeNode baseType) {
        super(currentST, ctx);

        if(baseType.hasErrors()) {
            setError();
            return;
        }

        type = baseType.getType();
    }

    // pairElemType: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public PairElemTypeNode(SymbolTable currentST, WACCParser.PairElemTypeContext ctx, TypeNode type) {
        super(currentST, ctx);

        if(type.hasErrors()) {
            setError();
            return;
        }

        this.type = new ArrayObj(type.getType());
    }

    // pairElemType: PAIR
    public PairElemTypeNode(SymbolTable currentST, WACCParser.PairElemTypeContext ctx) {
        super(currentST, ctx);
        this.type = new PairObj();
    }

    public TypeObj getType() {
        return type;
    }
}
