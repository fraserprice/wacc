package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.runtimeerror.ThrowOverflowError;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// TODO: ADD ERROR FOR TYPE MISMATCH
public class UnaryOpNode extends ExprNode<WACCParser.ExprContext> {

    private ExprNode argument;
    private String operator;

    private static final Map<String, TypeObj> returnType = new
            HashMap<String, TypeObj>() {{
        put("+", new IntObj());
        put("-", new IntObj());
        put("!", new BoolObj());
        put("len", new IntObj());
        put("chr", new CharObj());
        put("ord", new IntObj());
    }};

    private static final Map<String, Class<? extends TypeObj>> operandType =
            new HashMap<String, Class<? extends TypeObj>>() {{
        put("+", IntObj.class);
        put("-", IntObj.class);
        put("!", BoolObj.class);
        put("len", ArrayObj.class);
        put("chr", IntObj.class);
        put("ord", CharObj.class);
    }};

    public UnaryOpNode(SymbolTable currentST, WACCParser.ExprContext ctx,
                       String op, ExprNode argument) {
        super(currentST, ctx);

        if (argument.hasErrors()) {
            setError();
            return;
        }

        this.argument = argument;
        this.operator = op;

        check();
    }

    public void check() {
        if (!operandType.get(operator).isInstance(argument.getType())) {
            addSemanticError(CompileTimeError.INVALID_OPERANDS, operator,
                    argument.getType().toString());
            return;
        }

        type = returnType.get(operator);
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        Register reg = availableRegisters.get(0);

        List<Instruction> instructions = new LinkedList<Instruction>() {{
            addAll(argument.generateInstructions(codeGenRef, availableRegisters));
        }};

        switch (operator) {
            case "-":
                codeGenRef.useLibFunc(ThrowOverflowError.class);
                instructions.add(new BaseInstruction(Ins.RSBS, reg, reg, new Offset(0)));
                instructions.add(new BaseInstruction(Ins.BLVS, new LabelOp(ThrowOverflowError.FUNC_NAME)));
            case "!":
                instructions.add(new BaseInstruction(Ins.EOR, reg, reg, new Offset(1)));
            case "len":
                instructions.add(new BaseInstruction(Ins.LDR, reg, new StackLocation(reg)));
        }

        return instructions;
    }
}
