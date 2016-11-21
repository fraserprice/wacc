package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import main.CompileTimeError;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.ExprNode;

import java.util.LinkedList;
import java.util.List;

public class IdentNode extends ExprNode<WACCParser.IdentExprContext> {

    private String ident;
    private SymbolTable currentST;

    public IdentNode(SymbolTable currentST, WACCParser.IdentExprContext ctx) {
        super(currentST, ctx);

        this.ident = ctx.IDENT().getText();
        this.currentST = currentST;

        check();
    }

    private void check() {
        IdentifierObj obj = currentST.lookupAll(ctx.getText(), IdentifierObj
                .class);

        if (obj == null) {
            addSemanticError(CompileTimeError.UNDEFINED_IDENTIFIER, ctx.IDENT
                    ().toString());
            return;
        }

        if (!(obj instanceof VariableObj)) {
            addSemanticError(CompileTimeError.NOT_VARIABLE, ctx.IDENT()
                    .toString());
            return;
        }

        type = ((VariableObj) obj).getType();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        int offset = currentST.lookupOffset(ident);

        List<Instruction> instructions = new LinkedList<Instruction>() {{
            add(new BaseInstruction(Ins.getLdrInstruction(type), availableRegisters.get(0),
                    new StackLocation(Register.SP, new Offset(offset))));
        }};

        return instructions;
    }
}
