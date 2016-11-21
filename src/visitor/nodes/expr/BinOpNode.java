package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.Ins;
import codegen.operands.Register;
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
        List<Instruction> instructions = new LinkedList<Instruction>() {{
        }};

        return super.generateInstructions(codeGenRef, availableRegisters);
    }
}
