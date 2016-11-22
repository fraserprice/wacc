package visitor.nodes.util;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.runtimeerror.CheckNullPointer;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;
import visitor.nodes.ExprNode;

import java.util.ArrayList;
import java.util.List;

public class PairElemNode extends Node<WACCParser.PairElemContext> {
    private TypeObj type;
    private ExprNode expr;

    public PairElemNode(SymbolTable currentST, WACCParser.PairElemContext
            ctx, ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.expr = exprNode;

        check();
    }

    private void check() {
        if (!(expr.getType() instanceof PairObj)) {
            addSemanticError(CompileTimeError.INVALID_PAIR_ELEM_TYPE, expr
                    .getType().toString());
            return;
        }

        PairObj pair = (PairObj) expr.getType();

        if (ctx.FST() != null) {
            this.type = pair.getType1();
        } else {
            this.type = pair.getType2();
        }
    }

    public TypeObj getType() {
        return type;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

        instructions.addAll(expr.generateInstructions(codeGenRef, availableRegisters));
        Register ans = availableRegisters.get(0);

        instructions.add(new BaseInstruction(Ins.MOV, Register.R0, ans));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp(CheckNullPointer.FUNC_NAME)));
        codeGenRef.useLibFunc(CheckNullPointer.class);

        if (ctx.FST() != null) {
            instructions.add(new BaseInstruction(Ins.LDR, ans, new StackLocation(ans)));
        } else {
            instructions.add(new BaseInstruction(Ins.LDR, ans, new StackLocation(ans, new Offset(4))));
        }

        instructions.add(new BaseInstruction(Ins.getLdrInstruction(type), ans, new StackLocation(ans)));

        return instructions;
    }
}
