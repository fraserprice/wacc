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
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedList;
import java.util.List;

public class StringNode extends LiteralNode<WACCParser.StrLiteralContext> {

    public StringNode(SymbolTable currentST, WACCParser.StrLiteralContext ctx) {
        super(currentST, ctx);

        this.type = currentST.lookupAll("string", ArrayObj.class);
        this.value = ctx.STR_LITERAL().getText();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        codeGenRef.addMessage(value);

        return new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.LDR, availableRegisters.get(0), new Immediate(codeGenRef.getMessage(value))));
        }};
    }
}
