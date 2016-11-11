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

        if(exprNode.hasErrors()) {
            setError();
            return;
        }

        this.elseStat = elseStat;
        this.thenStat = thenStat;

        checkIfNode(exprNode);
    }

    private void checkIfNode(ExprNode exprNode) {
        if(!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                "If statement", "BOOL", exprNode.getCtx().getText(), exprNode.getType().toString());
        }
    }

    public StatNode getThenBlock() {
        return thenStat;
    }

    public StatNode getElseBlock() {
        return elseStat;
    }
}
