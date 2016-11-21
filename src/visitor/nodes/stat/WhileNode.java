package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.ArrayList;
import java.util.List;

public class WhileNode extends StatNode<WACCParser.WhileStatContext> {

    private StatNode body;
    private ExprNode condition;

    public WhileNode(SymbolTable currentST, WACCParser.WhileStatContext ctx,
                     ExprNode exprNode, StatNode body) {
        super(currentST, ctx);

        if (exprNode.hasErrors() || body.hasErrors()) {
            setError();
            return;
        }

        this.body = body;
        this.condition = exprNode;

        check();
    }

    private void check() {
        if (!(condition.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                    "while condition", "BOOL", condition.getCtx().getText(),
                    condition.getType().toString());
        }
    }

    public StatNode getBody() {
        return body;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

        String label1 = codeGenRef.getNextLabel();
        String label2 = codeGenRef.getNextLabel();

        instructions.add(new BaseInstruction(Ins.B, new LabelOp(label1)));
        instructions.add(new LabelIns(label2));

        List<Instruction> inBetween = body.generateInstructions(codeGenRef, availableRegisters);
        instructions.addAll(CodeGenerator.makeSpaceOnStack(currentST, inBetween));

        instructions.add(new LabelIns(label1));
        instructions.addAll(condition.generateInstructions(codeGenRef, availableRegisters));
        instructions.add(new BaseInstruction(Ins.CMP, availableRegisters.get(0), new Offset(1)));
        instructions.add(new BaseInstruction(Ins.BEQ, new LabelOp(label2)));

        return instructions;
    }
}
