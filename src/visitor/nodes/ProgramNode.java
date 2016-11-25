package visitor.nodes;

import antlr.WACCParser;
import codegen.*;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.instructions.Ltorg;
import codegen.operands.Immediate;
import codegen.operands.RegList;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.stat.CompositionNode;
import visitor.nodes.stat.ReturnNode;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends Node<WACCParser.ProgramContext> {
    private List<FunctionNode> functionNodeList;
    private StatNode body;

    public ProgramNode(SymbolTable currentST, WACCParser.ProgramContext ctx,
                       List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST, ctx);
        this.functionNodeList = functionNodeList;
        this.body = statNode;

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
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> ins = new ArrayList<>();

        for (FunctionNode fn : functionNodeList) {
            ins.addAll(fn.generateInstructions(codeGenRef, availableRegisters));
        }

        ins.add(new LabelIns("main"));
        ins.add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));

        List<Instruction> bodyInsList = body.generateInstructions(codeGenRef, availableRegisters);
        ins.addAll(CodeGenerator.makeSpaceOnStackAndRestore(currentST, bodyInsList));

        ins.add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate("0")));
        ins.add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        ins.add(new Ltorg());

        return ins;
    }
}
