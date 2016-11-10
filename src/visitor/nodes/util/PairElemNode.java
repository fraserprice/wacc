package visitor.nodes.util;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;
import visitor.nodes.ExprNode;

public class PairElemNode extends Node {
    private TypeObj type;
    private ExprNode expr;

    public PairElemNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode expr) {
        super(currentST, ctx);

        if (!expr.hasErrors()) {
            this.expr = expr;
            check();
        }
    }

    private void check() {
        if (expr == null) {
            return;
        }
        if (expr.getType() == null) {
            return;
        }

        if (!(expr.getType() instanceof PairObj)) {
            addSemanticError(CompileTimeError.INVALID_PAIR_ELEM_TYPE);
            return;
        }

        this.type = expr.getType();
    }

    public TypeObj getType() {
        return type;
    }
}
