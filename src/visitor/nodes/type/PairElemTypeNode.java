package visitor.nodes.type;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.TyplessPairObj;
import visitor.Node;

// TODO
public class PairElemTypeNode extends Node {
    private TypeObj type;

    // pairElemType: baseType
    public PairElemTypeNode(SymbolTable currentST, ParserRuleContext ctx, BaseTypeNode baseType) {
        super(currentST, ctx);
        type = baseType.getType();
    }

    // pairElemType: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public PairElemTypeNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode type) {
        super(currentST, ctx);
        this.type = type.getType();
    }

    // pairElemType: PAIR
    public PairElemTypeNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = new TyplessPairObj(currentST);
    }

    public TypeObj getType() {
        return type;
    }
}
