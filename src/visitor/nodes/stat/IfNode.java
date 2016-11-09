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
        if (!exprNode.hasErrors()) {
            checkIfNode(exprNode);
        }
    }

    private void checkIfNode(ExprNode exprNode) {
        assert (exprNode != null): "IfNode: expr can't be null";
        assert (exprNode.getType() != null): "IfNode: expr needs a type";

        if(!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE);
        }
    }
}
