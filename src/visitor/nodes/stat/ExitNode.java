package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.LabelOp;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.ArrayList;
import java.util.List;

public class ExitNode extends StatNode<WACCParser.ExitStatContext> {
    private ExprNode expr;

    public ExitNode(SymbolTable currentST, WACCParser.ExitStatContext ctx,
                    ExprNode expr) {
        super(currentST, ctx);

        if (expr.hasErrors()) {
            setError();
            return;
        }

        this.expr = expr;

        check();
    }

    private void check() {
        if (!expr.getType().equals(new IntObj())) {
            addSemanticError(CompileTimeError.INVALID_EXIT_ARGUMENT, expr
                    .getType().toString());
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(expr.generateInstructions(codeGenRef, availableRegisters));
        instructions.add(new BaseInstruction(Ins.MOV, Register.R0,
                availableRegisters.get(0)));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp("exit")));
        return instructions;
    }
}
