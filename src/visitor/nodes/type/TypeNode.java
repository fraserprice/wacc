package visitor.nodes.type;

import antlr.WACCParser;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;

public class TypeNode extends Node<WACCParser.TypeContext> {
    private TypeObj type;

    // type: baseType
    public TypeNode(SymbolTable currentST, WACCParser.TypeContext ctx,
                    BaseTypeNode baseType) {
        super(currentST, ctx);

        if (baseType.hasErrors()) {
            setError();
            return;
        }

        this.type = baseType.getType();
    }

    // type: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public TypeNode(SymbolTable currentST, WACCParser.TypeContext ctx,
                    TypeNode type) {
        super(currentST, ctx);

        if (type.hasErrors()) {
            setError();
            return;
        }

        this.type = new ArrayObj(type.getType());
    }

    // type: PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType
    // CLOSE_PARENTHESES
    public TypeNode(SymbolTable currentST, WACCParser.TypeContext ctx,
                    PairElemTypeNode fstType, PairElemTypeNode sndType) {
        super(currentST, ctx);

        if (fstType.hasErrors() || sndType.hasErrors()) {
            setError();
            return;
        }

        this.type = new PairObj(fstType.getType(), sndType.getType());
    }

    public TypeObj getType() {
        return type;
    }
}
