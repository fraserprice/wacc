package visitor.nodes.expr;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.HashMap;
import java.util.Map;


// TODO
public class UnaryOpNode extends ExprNode {
    private ExprNode argument;
    private String operator;
    private static final Map<String, TypeObj> operatorToType = new HashMap<String, TypeObj>() {{
        put("+", new IntObj(null));
        put("-", new IntObj(null));
        put("!", new BoolObj(null));
        put("len", new IntObj(null));
        put("chr", new CharObj(null));
        put("ord", new IntObj(null));
    }};

    public UnaryOpNode(SymbolTable currentST, ParserRuleContext ctx, String op, ExprNode argument) {
        super(currentST, ctx);
        this.argument = argument;
        this.operator = op;
        if (!argument.hasErrors()) {
            check();
        }
    }

    public void check() {
        assert (argument != null): "UnaryOp: argument can't be null";
        assert (argument.getType() != null): "UnaryOp: argument should have a type";

        type = operatorToType.get(operator);
    }
}
