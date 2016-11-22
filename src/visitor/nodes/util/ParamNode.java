package visitor.nodes.util;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import visitor.Node;
import visitor.nodes.type.TypeNode;

public class ParamNode extends Node<WACCParser.ParamContext> {
    private VariableObj obj;

    public ParamNode(SymbolTable currentST, WACCParser.ParamContext ctx,
                     TypeNode typeNode) {
        super(currentST, ctx);

        if (typeNode.hasErrors()) {
            setError();
            return;
        }

        check(ctx, typeNode.getType());
    }

    private void check(WACCParser.ParamContext ctx, TypeObj type) {
        VariableObj duplicate = currentST.lookup(ctx.IDENT().getText(),
                VariableObj.class);

        if (duplicate != null) {
            addSemanticError(CompileTimeError.VARIABLE_ALREADY_DEFINED, ctx
                    .IDENT().getText());
        }

        if (!IdentifierObj.isValidIdentifierName(ctx.IDENT().getText())) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME, ctx
                    .IDENT().toString());
            return;
        }

        obj = new VariableObj(currentST, type);

        currentST.setInitialised(ctx.IDENT().getText());
        currentST.add(ctx.IDENT().getText(), obj);
    }

    public VariableObj getObj() {
        return obj;
    }
}
