package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class FreeNode extends StatNode<WACCParser.FreeStatContext> {

    public FreeNode(SymbolTable currentST, WACCParser.FreeStatContext ctx,
                    ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        check(exprNode);
    }

    private void check(ExprNode exprNode) {
        if (!(exprNode.getType() instanceof PairObj)) {
            addSemanticError(CompileTimeError.INVALID_FREE_VALUE, exprNode
                    .getType().toString());
        }
    }
}