package visitor.nodes.type;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;

public class TypeNode extends Node<WACCParser.TypeContext> {
    private TypeObj type;

    // type: baseType
    public TypeNode(SymbolTable currentST, WACCParser.TypeContext ctx, BaseTypeNode baseType) {
        super(currentST, ctx);
        this.type = baseType.getType();
        if (type == null) {
            return;
        }
    }

    // type: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public TypeNode(SymbolTable currentST, WACCParser.TypeContext ctx, TypeNode type) {
        super(currentST, ctx);
        this.type = new ArrayObj(type.getType());
        if (type == null) {
            return;
        }
    }

    // type: PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES
    public TypeNode(SymbolTable currentST, WACCParser.TypeContext ctx, PairElemTypeNode fstType, PairElemTypeNode sndType) {
        super(currentST, ctx);
        this.type = new PairObj(fstType.getType(), sndType.getType());
        if (type == null) {
            return;
        }
    }

    public TypeObj getType() {
        return type;
    }
}
