package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import symobjects.identifierobj.typeobj.scalarobj.PairLitObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class FreeNode extends StatNode<WACCParser.FreeStatContext> {

    public FreeNode(SymbolTable currentST, WACCParser.FreeStatContext ctx, ExprNode exprNode) {
        super(currentST, ctx);
        checkFree(exprNode);
    }

    private void checkFree(ExprNode exprNode) {
        if (exprNode == null) {
            return;
        }
        if (exprNode.getType() == null) {
            return;
        }

        if(!(exprNode.getType() instanceof PairObj)) {
            addSemanticError(CompileTimeError.INVALID_FREE_VALUE, exprNode.getType().toString());
        }
    }
}