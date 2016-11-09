package visitor.nodes.expr;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.lang.reflect.Type;
import java.util.List;

public class ArrayElementNode extends ExprNode {

    private List<ExprNode> exprList;

    public ArrayElementNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> exprList) {
        super(currentST, ctx);
        this.exprList = exprList;
        boolean err = false;
        for (ExprNode expr : exprList) {
            if (expr.hasErrors()) {
                err = true;
            }
        }
        if (!err) {
            check();
        }
    }

    public void check() {
        TypeObj arrayType = (TypeObj) currentST.lookupAll(((WACCParser.ArrayElemContext) ctx).IDENT().getText());

        if (!(arrayType instanceof ArrayObj)) {
            addSemanticError(CompileTimeError.EXPECTED_ARRAY_CALL);
            return;
        }

        ArrayObj arrayT = (ArrayObj) arrayType;
        type = arrayT.getType();

        for(ExprNode expr : exprList) {
            assert(expr != null): "ArrayElem: expr can't be null";
            assert(expr.getType() != null): "ArrayElem: type of expr can't be null";

            if(!expr.getType().equals(new IntObj(currentST))) {
                addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR);
            }
        }
    }
}
