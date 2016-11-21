package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.Ins;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

import java.util.LinkedList;
import java.util.List;

public class ParenthesisNode extends ExprNode<WACCParser
        .ParanthesisExprContext> {

    private ExprNode argument;

    public ParenthesisNode(SymbolTable currentST, WACCParser
            .ParanthesisExprContext ctx, ExprNode argument) {
        super(currentST, ctx);

        if (argument.hasErrors()) {
            setError();
        }

        this.type = argument.getType();
        this.argument = argument;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return argument.generateInstructions(codeGenRef, availableRegisters);
    }
}
