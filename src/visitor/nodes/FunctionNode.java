package visitor.nodes;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import visitor.Node;
import visitor.nodes.stat.*;
import visitor.nodes.util.ParamNode;
import visitor.nodes.type.TypeNode;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionNode extends Node<WACCParser.FuncContext> {

    private FunctionObj fObj;
    private StatNode body;
    private String name;

    public FunctionNode(SymbolTable currentST, WACCParser.FuncContext ctx, FunctionObj fObj, StatNode statNode) {
        super(currentST, ctx);

        if(statNode.hasErrors()) {
            setError();
            return;
        }

        this.fObj = fObj;
        this.body = statNode;
        this.name = ctx.IDENT().getText();

        check();
    }

    private void check() {
        StatNode current = body;
        List<ReturnNode> returnStatList = new LinkedList<>();

        if(!lastStatIsReturn(current, returnStatList)) {
            addSyntacticError(CompileTimeError.RETURN_STATEMENT_MISSING_FROM_LAST_LINE);
        }

        for (ReturnNode retStat: returnStatList) {
            TypeObj returnStatementType = retStat.getReturnType();

            if (!returnStatementType.equals(fObj.getReturnType())) {
                addSemanticError(retStat.getCtx().start.getLine(), retStat.getCtx().start.getCharPositionInLine(), CompileTimeError.RETURN_TYPE_MISMATCH,
                                                fObj.getReturnType().toString(), returnStatementType.toString());
                return;
            }
        }
    }

    private boolean lastStatIsReturn(StatNode current, List<ReturnNode> returns) {

        while (current instanceof CompositionNode) {
            current = ((CompositionNode) current).getSecondStatNode();
        }

        if(current instanceof IfNode) {
            return lastStatIsReturn(((IfNode) current).getElseBlock(), returns) && lastStatIsReturn(((IfNode) current).getThenBlock(), returns);
        } else if(current instanceof WhileNode) {
            return lastStatIsReturn(((WhileNode) current).getStatNode(), returns);
        } else if(current instanceof ScopeBlockNode) {
            return lastStatIsReturn(((ScopeBlockNode) current).getBody(), returns);
        } else if (!(current instanceof ExitNode) && !(current instanceof ReturnNode)) {
            return false;
        }
        if (current instanceof ReturnNode) {
            returns.add((ReturnNode) current);
        }
        return true;
    }
}
