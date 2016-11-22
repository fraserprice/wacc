package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

import java.util.LinkedList;
import java.util.List;

public class ScopeBlockNode extends StatNode<WACCParser.ScopeBlockStatContext> {
    private StatNode body;

    public ScopeBlockNode(SymbolTable currentST, WACCParser
            .ScopeBlockStatContext ctx, StatNode statNode) {
        super(currentST, ctx);

        if (statNode.hasErrors()) {
            setError();
            return;
        }

        this.body = statNode;
    }

    public StatNode getBody() {
        return body;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new LinkedList<>();

        List<Instruction> bodyInstr = body.generateInstructions(codeGenRef, availableRegisters);
        instructions.addAll(CodeGenerator.makeSpaceOnStack(currentST, bodyInstr));

        return instructions;
    }
}
