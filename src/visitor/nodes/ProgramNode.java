package visitor.nodes;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.*;
import visitor.Node;
import visitor.nodes.stat.CompositionNode;
import visitor.nodes.stat.ReturnNode;

import java.util.List;

public class ProgramNode extends Node<WACCParser.ProgramContext> {
    public ProgramNode(SymbolTable currentST, WACCParser.ProgramContext ctx, List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST, ctx);

        for(FunctionNode fn : functionNodeList) {
            if(fn.hasErrors()) {
                setError();
                return;
            }
        }

        if(statNode.hasErrors()) {
            setError();
            return;
        }

        StatNode current = statNode;

        while (current instanceof CompositionNode) {
            if (((CompositionNode) current).getFirstStatNode() instanceof ReturnNode) {
                addSemanticError(current.getCtx().getStart().getLine(), current.getCtx().getStart().getCharPositionInLine(),
                        CompileTimeError.MAIN_FUNCTION_CONTAINS_RETURN);
                return;
            }

            current = ((CompositionNode) current).getSecondStatNode();
        }

        if (current instanceof ReturnNode) {
            addSemanticError(current.getCtx().getStart().getLine(), current.getCtx().getStart().getCharPositionInLine(),
                                                            CompileTimeError.MAIN_FUNCTION_CONTAINS_RETURN);
            return;
        }
    }
}
