package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Immediate;
import codegen.operands.Offset;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedList;
import java.util.List;

public class IntNode extends LiteralNode<WACCParser.IntLiteralContext> {

    public IntNode(SymbolTable currentST, WACCParser.IntLiteralContext ctx) {
        super(currentST, ctx);

        this.type = currentST.lookupAll("int", IntObj.class);
        this.value = ctx.getText();

        check();
    }

    public IntNode(SymbolTable currentST, String value) {
        super(currentST, null);
        this.type = currentST.lookupAll("int", IntObj.class);
        this.value = value;

        check();
    }

    private void check() {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            addSyntacticError(CompileTimeError.INTEGER_OVERFLOW, ctx.getText());
            System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.LDR, availableRegisters.get(0), new Immediate(value)));
        }};
    }
}
