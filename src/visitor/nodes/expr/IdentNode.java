package visitor.nodes.expr;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.ExprNode;

public class IdentNode extends ExprNode {
    public IdentNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        check();
    }

    private void check() {
        IdentifierObj obj = currentST.lookupAll(ctx.getText());

        if (obj == null) {
            addSemanticError(CompileTimeError.UNDEFINED_IDENTIFIER);
            return;
        }

        if (!(obj instanceof VariableObj)) {
            addSemanticError(CompileTimeError.NOT_VARIABLE);
            return;
        }

        type = (TypeObj) obj;
    }
}
