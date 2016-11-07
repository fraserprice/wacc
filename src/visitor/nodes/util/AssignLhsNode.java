package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.expr.ArrayElementNode;
import visitor.nodes.expr.IdentNode;

// TODO
public abstract class AssignLhsNode extends Node {

    // assignLhs: IDENT
    public AssignLhsNode(SymbolTable currentST, ParserRuleContext ctx, IdentNode name) {
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
}
