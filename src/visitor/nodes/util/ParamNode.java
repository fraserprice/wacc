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

public class ParamNode extends Node {
    private TypeObj type;

    public ParamNode(SymbolTable currentST, WACCParser.ParamContext ctx, TypeNode typeNode) {
        super(currentST, ctx);
        this.type = typeNode.getType();

        check(ctx);
    }

    private void check(WACCParser.ParamContext ctx) {
        if (!IdentifierObj.isValidIdentifierName(ctx.IDENT().getText())) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME);
            return;
        }

        currentST.add(ctx.IDENT().getText(), new VariableObj(currentST, type));
    }
}
