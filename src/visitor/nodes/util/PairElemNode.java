package visitor.nodes.util;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;
import visitor.nodes.ExprNode;

public class PairElemNode extends Node<WACCParser.PairElemContext> {
    private TypeObj type;
    private ExprNode expr;

    public PairElemNode(SymbolTable currentST, WACCParser.PairElemContext
            ctx, ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.expr = exprNode;

        check();
    }

    private void check() {
        if (!(expr.getType() instanceof PairObj)) {
            addSemanticError(CompileTimeError.INVALID_PAIR_ELEM_TYPE, expr
                    .getType().toString());
            return;
        }

        PairObj pair = (PairObj) expr.getType();

        if (ctx.FST() != null) {
            this.type = pair.getType1();
        } else {
            this.type = pair.getType2();
        }
    }

    public TypeObj getType() {
        return type;
    }
}
