package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Immediate;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

import java.util.ArrayList;
import java.util.List;

public class SkipNode extends StatNode<WACCParser.SkipStatContext> {
    public SkipNode(SymbolTable currentST, WACCParser.SkipStatContext ctx) {
        super(currentST, ctx);
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return new ArrayList<Instruction>() {{ add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate("0"))); }};
    }
}
