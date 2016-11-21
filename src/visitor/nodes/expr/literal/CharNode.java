package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Immediate;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedList;
import java.util.List;

public class CharNode extends LiteralNode<WACCParser.CharLiteralContext> {

    public CharNode(SymbolTable currentST, WACCParser.CharLiteralContext ctx) {
        super(currentST, ctx);

        this.type = currentST.lookupAll("char", CharObj.class);
        this.value = ctx.getText();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.MOV, availableRegisters.get(0), new Immediate(value)));
        }};
    }
}
