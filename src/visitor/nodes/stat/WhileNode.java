package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class WhileNode extends StatNode<WACCParser.WhileStatContext> {

    private StatNode statNode;

    public WhileNode(SymbolTable currentST, WACCParser.WhileStatContext ctx, ExprNode exprNode, StatNode statNode) {
        super(currentST, ctx);
        checkWhileCondition(exprNode);
        this.statNode = statNode;
    }

    private void checkWhileCondition(ExprNode exprNode) {
        if  (exprNode == null) {
            return;
        }
        if (exprNode.getType() != null) {
            return;
        }

        if(!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                "while condition", "bool", "actual", exprNode.getType().toString());
        }
    }

    public StatNode getStatNode() {
        return statNode;
    }

}
