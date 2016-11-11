package visitor.nodes.expr;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.HashMap;
import java.util.Map;

// TODO: ADD ERROR FOR TYPE MISMATCH
public class UnaryOpNode extends ExprNode<WACCParser.ExprContext> {
    private ExprNode argument;
    private String operator;
    private static final Map<String, TypeObj> returnType = new HashMap<String, TypeObj>() {{
        put("+", new IntObj());
        put("-", new IntObj());
        put("!", new BoolObj());
        put("len", new IntObj());
        put("chr", new CharObj());
        put("ord", new IntObj());
    }};

    private static final Map<String, TypeObj> operandType = new HashMap<String, TypeObj>() {{
        put("+", new IntObj());
        put("-", new IntObj());
        put("!", new BoolObj());
        put("len", new ArrayObj());
        put("chr", new IntObj());
        put("ord", new CharObj());
    }};

    public UnaryOpNode(SymbolTable currentST, WACCParser.ExprContext ctx, String op, ExprNode argument) {
        super(currentST, ctx);
        this.argument = argument;
        this.operator = op;
        check();
    }

    public void check() {
        if (argument == null) {
            return;
        }
        if (argument.getType() == null) {
            return;
        }

        if (!operandType.get(operator).equals(argument.getType())) {
            addSemanticError(CompileTimeError.INVALID_OPERANDS, operator, argument.getType().toString());
            return;
        }

        type = returnType.get(operator);
    }
}
