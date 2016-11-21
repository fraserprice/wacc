package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.Ins;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

import java.util.ArrayList;
import java.util.List;

public class CompositionNode extends StatNode<WACCParser
        .CompositionStatContext> {
    private StatNode firstStatNode;
    private StatNode secondStatNode;

    public CompositionNode(SymbolTable currentST, WACCParser
            .CompositionStatContext ctx, StatNode firstStatNode, StatNode
            secondStatNode) {
        super(currentST, ctx);

        if (firstStatNode.hasErrors() || secondStatNode.hasErrors()) {
            setError();
            return;
        }

        this.firstStatNode = firstStatNode;
        this.secondStatNode = secondStatNode;
    }

    public StatNode getFirstStatNode() {
        return firstStatNode;
    }

    public StatNode getSecondStatNode() {
        return secondStatNode;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> firstStatInstructions = firstStatNode.generateInstructions(codeGenRef, availableRegisters);
        List<Instruction> secondStatInstructions = secondStatNode.generateInstructions(codeGenRef, availableRegisters);
        firstStatInstructions.addAll(secondStatInstructions);

        return firstStatInstructions;
    }
}
