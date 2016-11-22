package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.runtimeerror.CheckDivideByZero;
import codegen.libfuncs.runtimeerror.ThrowOverflowError;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.ShiftOp;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinOpNode extends ExprNode<WACCParser.ExprContext> {
    private ExprNode lhs;
    private ExprNode rhs;
    private String operator;
    private static final Map<String, TypeObj> returnType = new
            HashMap<String, TypeObj>() {{
        put("*", new IntObj());
        put("/", new IntObj());
        put("%", new IntObj());
        put("+", new IntObj());
        put("-", new IntObj());
        put(">", new BoolObj());
        put(">=", new BoolObj());
        put("<", new BoolObj());
        put("<=", new BoolObj());
        put("==", new BoolObj());
        put("!=", new BoolObj());
        put("&&", new BoolObj());
        put("||", new BoolObj());
    }};

    private static final Map<String, List<Class<? extends TypeObj>>>
            operatorType = new HashMap<String, List<Class<? extends
            TypeObj>>>() {{
        put("*", Arrays.asList(IntObj.class));
        put("/", Arrays.asList(IntObj.class));
        put("%", Arrays.asList(IntObj.class));
        put("+", Arrays.asList(IntObj.class));
        put("-", Arrays.asList(IntObj.class));
        put(">", Arrays.asList(CharObj.class, IntObj.class));
        put(">=", Arrays.asList(CharObj.class, IntObj.class));
        put("<", Arrays.asList(CharObj.class, IntObj.class));
        put("<=", Arrays.asList(CharObj.class, IntObj.class));
        put("==", Arrays.asList(CharObj.class, IntObj.class, BoolObj.class,
                ArrayObj.class, PairObj.class));
        put("!=", Arrays.asList(CharObj.class, IntObj.class, BoolObj.class,
                ArrayObj.class, PairObj.class));
        put("&&", Arrays.asList(BoolObj.class));
        put("||", Arrays.asList(BoolObj.class));
    }};

    public BinOpNode(SymbolTable currentST, WACCParser.ExprContext ctx,
                     ExprNode lhs, String op, ExprNode rhs) {
        super(currentST, ctx);

        if (lhs.hasErrors() || rhs.hasErrors()) {
            setError();
            return;
        }

        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = op;

        check();
    }

    private void check() {
        TypeObj lhsType = lhs.getType();
        TypeObj rhsType = rhs.getType();

        if (!lhsType.equals(rhsType)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE, lhs.getCtx()
                    .getText(), lhsType.toString(), rhs.getCtx().getText(),
                    rhsType.toString());
            return;
        }

        if (!operatorType.get(operator).contains(lhsType.getClass())) {
            addSemanticError(CompileTimeError.INVALID_OPERANDS, operator,
                    lhsType.toString());
            return;
        }

        this.type = returnType.get(operator);
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {

        Register lhsR = availableRegisters.get(0);
        Register rhsR = availableRegisters.get(1);

        List<Instruction> instructions = new LinkedList<Instruction>() {{

            boolean lhsFirst = lhs instanceof ParenthesisNode && !(rhs instanceof ParenthesisNode);
            boolean rhsFirst = rhs instanceof ParenthesisNode && !(lhs instanceof ParenthesisNode);

            if(lhsFirst || (lhs.getWeight() >= rhs.getWeight() && !rhsFirst)) {
                addAll(lhs.generateInstructions(codeGenRef, availableRegisters));
                List<Register> availableRhs = availableRegisters.stream().skip(1).collect(Collectors.toList());
                addAll(rhs.generateInstructions(codeGenRef, availableRhs));
            } else {
                List<Register> availableTemp = availableRegisters.stream().skip(1).collect(Collectors.toList());
                availableTemp.add(1, lhsR);
                addAll(rhs.generateInstructions(codeGenRef, availableTemp));
                availableTemp = availableTemp.stream().skip(1).collect(Collectors.toList());
                addAll(lhs.generateInstructions(codeGenRef, availableTemp));
            }
        }};

        switch (operator) {
            case "*":
                codeGenRef.useLibFunc(ThrowOverflowError.class);
                instructions.add(new BaseInstruction(Ins.SMULL, lhsR, rhsR, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.CMP, rhsR, lhsR, new ShiftOp(Ins.ASR, new Offset(31))));
                instructions.add(new BaseInstruction(Ins.BLNE, new LabelOp(ThrowOverflowError.FUNC_NAME)));
                break;
            case "/":
                codeGenRef.useLibFunc(CheckDivideByZero.class);
                instructions.add(new BaseInstruction(Ins.MOV, Register.R0, lhsR));
                instructions.add(new BaseInstruction(Ins.MOV, Register.R1, rhsR));
                instructions.add(new BaseInstruction(Ins.BL, new LabelOp(CheckDivideByZero.FUNC_NAME)));
                instructions.add(new BaseInstruction(Ins.BL, new LabelOp("__aeabi_idiv")));
                instructions.add(new BaseInstruction(Ins.MOV, lhsR, Register.R0));
                break;
            case "%":
                codeGenRef.useLibFunc(CheckDivideByZero.class);
                instructions.add(new BaseInstruction(Ins.MOV, Register.R0, lhsR));
                instructions.add(new BaseInstruction(Ins.MOV, Register.R1, rhsR));
                instructions.add(new BaseInstruction(Ins.BL, new LabelOp(CheckDivideByZero.FUNC_NAME)));
                instructions.add(new BaseInstruction(Ins.BL, new LabelOp("__aeabi_idivmod")));
                instructions.add(new BaseInstruction(Ins.MOV, lhsR, Register.R1));
                break;
            case "+":
                codeGenRef.useLibFunc(ThrowOverflowError.class);
                instructions.add(new BaseInstruction(Ins.ADDS, lhsR, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.BLVS, new LabelOp(ThrowOverflowError.FUNC_NAME)));
                break;
            case "-":
                codeGenRef.useLibFunc(ThrowOverflowError.class);
                instructions.add(new BaseInstruction(Ins.SUBS, lhsR, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.BLVS, new LabelOp(ThrowOverflowError.FUNC_NAME)));
                break;
            case ">":
                instructions.add(new BaseInstruction(Ins.CMP, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.MOVGT, lhsR, new Offset(1)));
                instructions.add(new BaseInstruction(Ins.MOVLE, lhsR, new Offset(0)));
                break;
            case ">=":
                instructions.add(new BaseInstruction(Ins.CMP, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.MOVGE, lhsR, new Offset(1)));
                instructions.add(new BaseInstruction(Ins.MOVLT, lhsR, new Offset(0)));
                break;
            case "<":
                instructions.add(new BaseInstruction(Ins.CMP, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.MOVLT, lhsR, new Offset(1)));
                instructions.add(new BaseInstruction(Ins.MOVGE, lhsR, new Offset(0)));
                break;
            case "<=":
                instructions.add(new BaseInstruction(Ins.CMP, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.MOVLE, lhsR, new Offset(1)));
                instructions.add(new BaseInstruction(Ins.MOVGT, lhsR, new Offset(0)));
                break;
            case "==":
                instructions.add(new BaseInstruction(Ins.CMP, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.MOVEQ, lhsR, new Offset(1)));
                instructions.add(new BaseInstruction(Ins.MOVNE, lhsR, new Offset(0)));
                break;
            case "!=":
                instructions.add(new BaseInstruction(Ins.CMP, lhsR, rhsR));
                instructions.add(new BaseInstruction(Ins.MOVNE, lhsR, new Offset(1)));
                instructions.add(new BaseInstruction(Ins.MOVEQ, lhsR, new Offset(0)));
                break;
            case "&&":
                instructions.add(new BaseInstruction(Ins.AND, lhsR, lhsR, rhsR));
                break;
            case "||":
                instructions.add(new BaseInstruction(Ins.ORR, lhsR, lhsR, rhsR));
                break;
        }

        return instructions;
    }
}
