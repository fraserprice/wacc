package visitor.nodes.util;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import visitor.Node;
import visitor.nodes.type.TypeNode;

public class ParamNode extends Node<WACCParser.ParamContext> {
    private VariableObj obj;

    public ParamNode(SymbolTable currentST, WACCParser.ParamContext ctx, TypeNode typeNode) {
        super(currentST, ctx);

        if(typeNode.hasErrors()) {
            setError();
            return;
        }

        check(ctx, typeNode.getType());
    }

    private void check(WACCParser.ParamContext ctx, TypeObj type) {
        if (!IdentifierObj.isValidIdentifierName(ctx.IDENT().getText())) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME, ctx.IDENT().toString());
            return;
        }

        obj = new VariableObj(currentST, type);

        currentST.add(ctx.IDENT().getText(), obj);
    }

    public VariableObj getObj() {
        return obj;
    }
}
