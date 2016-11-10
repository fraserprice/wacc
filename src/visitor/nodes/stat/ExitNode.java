package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class ExitNode extends StatNode<WACCParser.ExitStatContext> {
    private ExprNode expr;

    public ExitNode(SymbolTable currentST, WACCParser.ExitStatContext ctx, ExprNode expr) {
        super(currentST, ctx);

        this.expr = expr;
        if (!expr.hasErrors()) {
            check();
        }
    }

    private void check() {
        assert (expr != null): "ExitNode: expr should not be null";
        assert (expr.getType() != null): "ExitNode: expr should have a type";
        if (!expr.getType().equals(new IntObj())) {
            addSemanticError(CompileTimeError.INVALID_EXIT_ARGUMENT);
        }
    }
}
