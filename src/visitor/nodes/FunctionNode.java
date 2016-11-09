package visitor.nodes;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.stat.ReturnNode;
import visitor.nodes.util.ParamNode;
import visitor.nodes.type.TypeNode;

import java.util.List;

public class FunctionNode extends Node {

    private TypeNode returnType;
    private List<ParamNode> paramList;
    private StatNode statNode;

    public FunctionNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode typeNode,
                        List<ParamNode> paramNodeList, StatNode statNode) {
        super(currentST, ctx);
        this.returnType = typeNode;
        this.paramList = paramNodeList;
        this.statNode = statNode;
        check();
    }

    public void check() {
        if (!(ctx.getChild(paramList.size()) instanceof ReturnNode)) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
            printSyntacticErrors();
        }
    }
}
