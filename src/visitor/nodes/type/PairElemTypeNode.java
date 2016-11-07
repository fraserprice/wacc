package visitor.nodes.type;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;

// TODO
public class PairElemTypeNode extends Node {
    // pairElemType: baseType
    public PairElemTypeNode(SymbolTable currentST, ParserRuleContext ctx, BaseTypeNode baseType) {
        super(currentST, ctx);
    }

    // pairElemType: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    public PairElemTypeNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode type) {
        super(currentST, ctx);
    }

    // pairElemType: PAIR
    public PairElemTypeNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
    }
}
