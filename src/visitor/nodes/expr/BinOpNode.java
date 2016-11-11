package visitor.nodes.expr;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinOpNode extends ExprNode<WACCParser.ExprContext> {
    private ExprNode lhs;
    private ExprNode rhs;
    private String operator;
    private static final Map<String, TypeObj> returnType = new HashMap<String, TypeObj>() {{
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

    private static final Map<String, List<TypeObj>> operatorType = new HashMap<String, List<TypeObj>>() {{
        put("*", Arrays.asList(new IntObj()));
        put("/", Arrays.asList(new IntObj()));
        put("%", Arrays.asList(new IntObj()));
        put("+", Arrays.asList(new IntObj()));
        put("-", Arrays.asList(new IntObj()));
        put(">", Arrays.asList(new CharObj(), new IntObj()));
        put(">=", Arrays.asList(new CharObj(), new IntObj()));
        put("<", Arrays.asList(new CharObj(), new IntObj()));
        put("<=", Arrays.asList(new CharObj(), new IntObj()));
        put("==", Arrays.asList(new CharObj(), new IntObj(), new BoolObj()));
        put("!=", Arrays.asList(new CharObj(), new IntObj(), new BoolObj()));
        put("&&", Arrays.asList(new BoolObj()));
        put("||", Arrays.asList(new BoolObj()));
    }};

    public BinOpNode(SymbolTable currentST, WACCParser.ExprContext ctx, ExprNode lhs, String op, ExprNode rhs) {
        super(currentST, ctx);
        this.lhs = lhs;
        this.rhs = rhs;
        this.operator = op;
        check();
    }

    private void check() {
        if (lhs == null) {
            return;
        }

        if (rhs == null) {
            return;
        }

        if (lhs.getType() == null) {
            return;
        }

        if (rhs.getType() == null) {
            return;
        }

        TypeObj lhsType = lhs.getType();
        TypeObj rhsType = rhs.getType();

        if(!lhsType.equals(rhsType)) {
            addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR, lhsType.toString(), rhsType.toString());
            return;
        }

        if (!operatorType.get(operator).contains(lhsType)) {
            addSemanticError(CompileTimeError.INVALID_OPERANDS, operator, lhsType.toString());
            return;
        }

        this.type = returnType.get(operator);
    }

}
