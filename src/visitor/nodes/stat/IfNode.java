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

public class IfNode extends StatNode<WACCParser.IfStatContext> {

    private ExprNode exprNode;
    private StatNode thenStat;
    private StatNode elseStat;

    public IfNode(SymbolTable currentST, WACCParser.IfStatContext ctx,
                  ExprNode exprNode, StatNode thenStat, StatNode elseStat) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.exprNode = exprNode;
        this.elseStat = elseStat;
        this.thenStat = thenStat;

        check();
    }

    private void check() {
        if (!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                    "If statement", "BOOL", exprNode.getCtx().getText(),
                    exprNode.getType().toString());
        }
    }

    public StatNode getThenBlock() {
        return thenStat;
    }

    public StatNode getElseBlock() {
        return elseStat;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef
            , List<Register> availableRegisters) {

        assert (!availableRegisters.isEmpty())
                : "Available Registers should always have at least one element";
        List<Instruction> instructions = new ArrayList<>();

        // Get the first and second label names
        String label1 = codeGenRef.getNextLabel();
        String label2 = codeGenRef.getNextLabel();
        // Get every instruction form exprNode and add to result
        instructions.addAll
                (exprNode.generateInstructions(codeGenRef, availableRegisters));
        Register exprResult = availableRegisters.get(0);
        instructions.add(new BaseInstruction(Ins.CMP, exprResult, new Offset(0)));
        instructions.add(new BaseInstruction(Ins.BEQ, new LabelOp(label1)));

        // Get the instructions in the first block
        List<Instruction> inBetweenThen = thenStat.generateInstructions(codeGenRef, availableRegisters);
        instructions.addAll(CodeGenerator.makeSpaceOnStack(thenStat.getCurrentST(), inBetweenThen));

        instructions.add(new BaseInstruction(Ins.BL, new LabelOp(label2)));
        instructions.add(new LabelIns(label1));

        // Get the instructions in the second block
        List<Instruction> inBetweenElse = elseStat.generateInstructions(codeGenRef, availableRegisters);
        instructions.addAll(CodeGenerator.makeSpaceOnStack(elseStat.getCurrentST(), inBetweenElse));

        instructions.add(new LabelIns(label2));

        return instructions;
    }
}
