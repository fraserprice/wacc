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
    private String ident;

    public ArrayElementNode(SymbolTable currentST, WACCParser.ArrayElemContext ctx, List<ExprNode> exprList) {
        super(currentST, ctx);
        this.exprList = exprList;
        this.ident = ctx.IDENT().getText();
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
        TypeObj arrayType = (TypeObj) currentST.lookupAll(ident);

        if (!(arrayType instanceof ArrayObj)) {
            addSemanticError(CompileTimeError.EXPECTED_ARRAY_CALL);
            return;
        }

        ArrayObj arrayT = (ArrayObj) arrayType;
        type = arrayT.getType();

        TypeObj arrayEntry = arrayT;
        int dimensionCount = 0;

        while (arrayEntry instanceof ArrayObj) {
            arrayEntry = ((ArrayObj) arrayEntry).getType();
            dimensionCount++;
        }

        if (dimensionCount != exprList.size()) {
            addSemanticError(CompileTimeError.INVALID_DIMENSION_NUMBER_ARRAY);
            return;
        }

        for(ExprNode expr : exprList) {
            assert(expr != null): "ArrayElem: expr can't be null";
            assert(expr.getType() != null): "ArrayElem: type of expr can't be null";

            if(!expr.getType().equals(new IntObj(currentST))) {
                addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR);
            }
        }
    }

    public String getIdent() {
        return ident;
    }
}
