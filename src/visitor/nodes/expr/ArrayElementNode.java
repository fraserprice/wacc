package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

import java.util.List;

// TODO
public class ArrayElementNode extends ExprNode {

    public ArrayElementNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> exprList) {
        super(currentST, ctx);
        assert(!exprList.isEmpty()): "ArrayElementNode: exprList has at least 1 element";
    }
}
