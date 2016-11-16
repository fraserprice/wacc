package visitor.nodes;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.stat.CompositionNode;
import visitor.nodes.stat.ReturnNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class ProgramNode extends Node<WACCParser.ProgramContext> {
    public ProgramNode(SymbolTable currentST, WACCParser.ProgramContext ctx,
                       List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST, ctx);

        for (FunctionNode fn : functionNodeList) {
            if (fn.hasErrors()) {
                setError();
                return;
            }
        }

        if (statNode.hasErrors()) {
            setError();
            return;
        }

        StatNode current = statNode;

        while (current instanceof CompositionNode) {
            if (((CompositionNode) current).getFirstStatNode() instanceof
                    ReturnNode) {
                addSemanticError(current.getCtx().getStart().getLine(),
                        current.getCtx().getStart().getCharPositionInLine(),
                        CompileTimeError.MAIN_FUNCTION_CONTAINS_RETURN);
                return;
            }

            current = ((CompositionNode) current).getSecondStatNode();
        }

        if (current instanceof ReturnNode) {
            addSemanticError(current.getCtx().getStart().getLine(), current
                            .getCtx().getStart().getCharPositionInLine(),
                    CompileTimeError.MAIN_FUNCTION_CONTAINS_RETURN);
            return;
        }
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
