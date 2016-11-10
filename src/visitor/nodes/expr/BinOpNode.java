package visitor.nodes.expr;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;

import java.util.HashMap;
import java.util.Map;

public class BinOpNode extends ExprNode<WACCParser.ExprContext> {
    private ExprNode lhs;
    private ExprNode rhs;
    private String operator;
    private static final Map<String, TypeObj> operatorToType = new HashMap<String, TypeObj>() {{
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
        TypeObj lhsType = lhs.getType();
        TypeObj rhsType = rhs.getType();

        if(lhsType == null || rhsType == null || !lhsType.equals(rhsType)) {
            addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR, lhsType.toString(), rhsType.toString());
            return;
        }

        this.type = operatorToType.get(operator);
    }

}
