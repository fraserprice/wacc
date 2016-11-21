package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Immediate;
import codegen.operands.Offset;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.NullPairObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedList;
import java.util.List;

public class PairNode extends LiteralNode<WACCParser.PairLiteralContext> {

    public PairNode(SymbolTable currentST, WACCParser.PairLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("null", NullPairObj.class);
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.LDR, availableRegisters.get(0), new Immediate("0")));
        }};
    }
}
