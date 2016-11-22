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
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedList;
import java.util.List;

public class StringNode extends LiteralNode<WACCParser.StrLiteralContext> {

    public StringNode(SymbolTable currentST, WACCParser.StrLiteralContext ctx) {
        super(currentST, ctx);

        this.value = ctx.STR_LITERAL().getText().substring(1, ctx.STR_LITERAL().getText().length() - 1);
        this.type = new ArrayObj(new CharObj(), this.value.length());
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        codeGenRef.addMessage(value);
        String message = codeGenRef.getLastMessage();

        return new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.getLdrInstruction(type), availableRegisters.get(0), new Immediate(message)));
        }};
    }
}
