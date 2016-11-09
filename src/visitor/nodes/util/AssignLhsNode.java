package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.Node;
import visitor.nodes.expr.ArrayElementNode;

public class AssignLhsNode extends Node {

    private TypeObj type;

    // assignLhs: IDENT
    public AssignLhsNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
    }

    // assignLhs: arrayElem
    public AssignLhsNode(SymbolTable currentST, ParserRuleContext ctx, ArrayElementNode arrayElem) {
        super(currentST, ctx);
    }

    // assignLhs; pairElem
    public AssignLhsNode(SymbolTable currentST, ParserRuleContext ctx, PairElemNode pairElem) {
        super(currentST, ctx);
    }

    public TypeObj getType() {
        return type;
    }
}
