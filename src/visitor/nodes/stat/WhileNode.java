package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class WhileNode extends StatNode<WACCParser.WhileStatContext> {

    public WhileNode(SymbolTable currentST, WACCParser.WhileStatContext ctx, ExprNode exprNode, StatNode statNode) {
        super(currentST, ctx);
        if (!exprNode.hasErrors()) {
            checkWhileCondition(exprNode);
        }
    }

    private void checkWhileCondition(ExprNode exprNode) {
        assert (exprNode != null): "WhileNode: expr can't be null";
        assert (exprNode.getType() != null): "WhileNode: expr needs a type";

        if(!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE);
        }
    }
}
