package visitor.nodes.expr;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.gui.TreePostScriptGenerator;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.lang.reflect.Type;
import java.util.List;

public class ArrayElementNode extends ExprNode<WACCParser.ArrayElemContext> {

    private List<ExprNode> exprList;
    private String ident;

    public ArrayElementNode(SymbolTable currentST, WACCParser.ArrayElemContext ctx, List<ExprNode> exprList) {
        super(currentST, ctx);
        this.exprList = exprList;
        this.ident = ctx.IDENT().getText();
        check();
    }

    public void check() {
        VariableObj obj = currentST.lookupAll(ident, VariableObj.class);

        if (obj == null) {
            addSemanticError(CompileTimeError.VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ident);
            return;
        }

        if (obj.getType() == null) {
            return;
        }

        if (!(obj.getType() instanceof ArrayObj)) {
            addSemanticError(CompileTimeError.EXPECTED_ARRAY_CALL, obj.getType().toString());
            return;
        }

        ArrayObj arrayType = (ArrayObj) obj.getType();

        type = arrayType.getTypeOfDim(ctx.CLOSE_SQUARE_BRACKET().size());

        if (type == null) {
            addSemanticError(CompileTimeError.INVALID_DIMENSION_NUMBER_ARRAY);
            return;
        }

        for(ExprNode expr : exprList) {
            if (expr == null) {
                return;
            }
            if (expr.getType() == null) {
                return;
            }

            if(!(expr.getType() instanceof IntObj)) {
                addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR, new IntObj().toString(), expr.getType().toString());
            }
        }
    }

    public String getIdent() {
        return ident;
    }
}
