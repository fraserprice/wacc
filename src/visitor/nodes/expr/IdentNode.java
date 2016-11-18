package visitor.nodes.expr;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.ExprNode;

public class IdentNode extends ExprNode<WACCParser.IdentExprContext> {

    public IdentNode(SymbolTable currentST, WACCParser.IdentExprContext ctx) {
        super(currentST, ctx);

        check();
    }

    private void check() {
        IdentifierObj obj = currentST.lookupAll(ctx.getText(), IdentifierObj
                .class);

        if (obj == null) {
            addSemanticError(CompileTimeError.UNDEFINED_IDENTIFIER, ctx.IDENT
                    ().toString());
            return;
        }

        if (!(obj instanceof VariableObj)) {
            addSemanticError(CompileTimeError.NOT_VARIABLE, ctx.IDENT()
                    .toString());
            return;
        }

        type = ((VariableObj) obj).getType();
    }
}
