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

    private TypeObj type;

    // assignLhs: IDENT
    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext
            ctx) {
        super(currentST, ctx);

        VariableObj identObj = currentST.lookupAll(ctx.IDENT().getText(),
                VariableObj.class);

        if (identObj == null) {
            addSemanticError(CompileTimeError
                    .VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ctx.IDENT()
                    .toString());
            return;
        }

        type = identObj.getType();
    }

    // assignLhs: arrayElem
    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext
            ctx, ArrayElementNode arrayElem) {
        super(currentST, ctx);

        if (arrayElem.hasErrors()) {
            setError();
            return;
        }

        type = arrayElem.getType();
    }

    // assignLhs; pairElem
    public AssignLhsNode(SymbolTable currentST, WACCParser.AssignLhsContext
            ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        if (pairElem.hasErrors()) {
            setError();
            return;
        }

        type = pairElem.getType();
    }

    public TypeObj getType() {
        return type;
    }
}
