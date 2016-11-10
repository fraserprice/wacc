package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class IfNode extends StatNode<WACCParser.IfStatContext> {

    private StatNode thenStat;
    private StatNode elseStat;

    public IfNode(SymbolTable currentST, WACCParser.IfStatContext ctx, ExprNode exprNode, StatNode thenStat, StatNode elseStat) {
        super(currentST, ctx);
        checkIfNode(exprNode);
        this.elseStat = elseStat;
        this.thenStat = thenStat;
    }

    private void checkIfNode(ExprNode exprNode) {
        if (exprNode == null) {
            return;
        }
        if (exprNode.getType() == null) {
            return;
        }

        if(!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                "If statement", "bool", "actual", exprNode.getType().toString());
        }
    }

    public StatNode getThenBlock() {
        return thenStat;
    }

    public StatNode getElseBlock() {
        return elseStat;
    }
}
