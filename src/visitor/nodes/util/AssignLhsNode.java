package visitor.nodes.util;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;
import visitor.nodes.expr.ArrayElementNode;

public class AssignLhsNode extends Node<WACCParser.AssignLhsContext> {

    private IdentifierObj obj;

    // assignLhs: IDENT
    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext ctx) {
        super(currentST, ctx);

        obj = currentST.lookupAll(ctx.IDENT().getText(), VariableObj.class);

        if (obj == null) {
            addSemanticError(CompileTimeError.VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ctx.IDENT().toString());
            return;
        }

        if (!(obj instanceof VariableObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                "expected", "variable", "actual", obj.toString());
        }
    }

    // assignLhs: arrayElem
    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext ctx, ArrayElementNode arrayElem) {
        super(currentST, ctx);

        obj = currentST.lookupAll(arrayElem.getIdent(), ArrayObj.class);

        if (obj == null) {
            addSemanticError(CompileTimeError.VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ctx.IDENT().toString());
            return;
        }

        if (!(obj instanceof ArrayObj)) {
            System.out.println("here");
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                "expected", "array", "actual", obj.toString());
        }
    }

    // assignLhs; pairElem
    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        obj = pairElem.getType();

        if (pairElem.getType() == null) {
            return;
        }
        assert(obj instanceof PairObj): "AssignLhsNode: Obj from pairElem should always be a PairObj";
    }

    public TypeObj getType() {
        if (obj == null) {
            return null;
        }

        if (obj instanceof VariableObj) {
            return ((VariableObj)obj).getType();
        } else if (obj instanceof ArrayObj) {
            return (TypeObj) obj;
        } else if (obj instanceof PairObj) {
            return (PairObj) obj;
        } else {
            assert(false): "AssignLhsNode: Type couldn't be matched (Should not get here)";
            return null;
        }
    }
}
