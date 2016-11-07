package visitor.nodes.type;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;

// TODO
public class TypeNode extends Node {
    // type: baseType
    public TypeNode(SymbolTable currentST, ParserRuleContext ctx, BaseTypeNode baseType) {
        super(currentST, ctx);
    }

    // type: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public TypeNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode type) {
        super(currentST, ctx);
    }

    // type: PAIR OPEN_PARENTHESES pairElemType COMMA pairElemType CLOSE_PARENTHESES
    public TypeNode(SymbolTable currentST, ParserRuleContext ctx, PairElemTypeNode fstType, PairElemTypeNode sndType) {
        super(currentST, ctx);
    }
}
