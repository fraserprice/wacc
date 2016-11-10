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

    private TypeObj returnType;
    private List<ParamNode> paramList;
    private StatNode body;
    private String name;

    public FunctionNode(SymbolTable currentST, WACCParser.FuncContext ctx, TypeNode typeNode,
                        List<ParamNode> paramNodeList, StatNode statNode) {
        super(currentST, ctx);
        this.returnType = typeNode.getType();
        this.paramList = paramNodeList;
        this.body = statNode;
        this.name = ctx.IDENT().getText();
        check();
    }

    private void check() {
        // TODO: check for if as well and statBlock
        // last statement is either exit or return
        StatNode current = body;
        List<ReturnNode> returnStatList = new LinkedList<>();

        if(!lastStatIsReturn(current)) {
            addSyntacticError(CompileTimeError.RETURN_STATEMENT_MISSING_FROM_LAST_LINE);
        }

        for (ReturnNode retStat: returnStatList) {
            TypeObj returnStatementType = retStat.getReturnType();
            if (!returnStatementType.equals(returnType)) {
                addSemanticError(CompileTimeError.RETURN_TYPE_MISMATCH, returnType.toString(), returnStatementType.toString());
                return;
            }
        }
    }

    private boolean lastStatIsReturn(StatNode current) {

        while (current instanceof CompositionNode) {
            current = ((CompositionNode) current).getSecondStatNode();
        }

        if(current instanceof IfNode) {
            return lastStatIsReturn(((IfNode) current).getElseBlock()) && lastStatIsReturn(((IfNode) current).getThenBlock());
        } else if(current instanceof WhileNode) {
            return lastStatIsReturn(((WhileNode) current).getStatNode());
        } else if(current instanceof ScopeBlockNode) {
            return lastStatIsReturn(((ScopeBlockNode) current).getBody());
        } else if (!(current instanceof ExitNode) && !(current instanceof ReturnNode)) {
            return false;
        }
        return true;
    }
}
