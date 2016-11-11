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

    private static final Map<String, Class<? extends TypeObj>> operandType = new HashMap<String, Class<? extends TypeObj>>() {{
        put("+", IntObj.class);
        put("-", IntObj.class);
        put("!", BoolObj.class);
        put("len", ArrayObj.class);
        put("chr", IntObj.class);
        put("ord", CharObj.class);
    }};

    public UnaryOpNode(SymbolTable currentST, WACCParser.ExprContext ctx, String op, ExprNode argument) {
        super(currentST, ctx);

        if(argument.hasErrors()) {
            setError();
            return;
        }

        this.argument = argument;
        this.operator = op;

        check();
    }

    public void check() {
        if (!operandType.get(operator).isInstance(argument.getType())) {
            addSemanticError(CompileTimeError.INVALID_OPERANDS, operator, argument.getType().toString());
            return;
        }

        type = returnType.get(operator);
    }
}
