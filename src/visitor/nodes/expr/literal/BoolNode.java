package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Immediate;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedList;
import java.util.List;

public class BoolNode extends LiteralNode<WACCParser.BoolLiteralContext> {

    public BoolNode(SymbolTable currentST, WACCParser.BoolLiteralContext ctx) {
        super(currentST, ctx);

        this.type = currentST.lookupAll("bool", BoolObj.class);
        this.value = ctx.BOOL_LITERAL().getText().equals("true") ? "1" : "0";
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.MOV, availableRegisters.get(0), new Immediate(value)));
        }};
    }
}
