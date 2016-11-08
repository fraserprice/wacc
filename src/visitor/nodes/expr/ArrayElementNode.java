package visitor.nodes.expr;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.List;

// TODO
public class ArrayElementNode extends ExprNode {

    private List<ExprNode> exprList;

    public ArrayElementNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> exprList) {
        super(currentST, ctx);
        assert(!exprList.isEmpty()): "ArrayElementNode: exprList has at least 1 element";
        this.exprList = exprList;
        //TODO: this.type = get type of array somehow?
        check();
    }

    public void check() {
        for(ExprNode expr : exprList) {
            if(expr.getType().getClass() != IntObj.class) {
                addError(CompileTimeError.TYPE_MISMATCH_ERROR);
            }
        }
    }


}
