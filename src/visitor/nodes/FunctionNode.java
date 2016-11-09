package visitor.nodes;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.stat.CompositionNode;
import visitor.nodes.stat.ExitNode;
import visitor.nodes.stat.ReturnNode;
import visitor.nodes.util.ParamNode;
import visitor.nodes.type.TypeNode;

import java.util.List;

public class FunctionNode extends Node {

    private TypeNode returnType;
    private List<ParamNode> paramList;
    private StatNode body;

    public FunctionNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode typeNode,
                        List<ParamNode> paramNodeList, StatNode statNode) {
        super(currentST, ctx);
        this.returnType = typeNode;
        this.paramList = paramNodeList;
        this.body = statNode;
        check();
    }

    private void check() {
        // last statement is either exit or return
        StatNode current = body;
        while (current instanceof CompositionNode) {
            current = ((CompositionNode) current).getSecondStatNode();
        }

        if (!(current instanceof ExitNode) || !(current instanceof ReturnNode)) {
            addSyntacticError(CompileTimeError.RETURN_STATEMENT_MISSING_FROM_LAST_LINE);
        }
    }
}
