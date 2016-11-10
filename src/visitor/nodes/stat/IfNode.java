package visitor.nodes.stat;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class IfNode extends StatNode {

    public IfNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode exprNode, StatNode thenStat, StatNode elseStat) {
        super(currentST, ctx);
        checkIfNode(exprNode);
    }

    private void checkIfNode(ExprNode exprNode) {
        if (exprNode == null) {
            return;
        }
        if (exprNode.getType() == null) {
            return;
        }

        if(!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE);
        }
    }
}
