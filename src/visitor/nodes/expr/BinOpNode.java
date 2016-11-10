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

        if (!lhs.hasErrors() && !rhs.hasErrors()) {
            check();
        }
    }

    private void check() {
        assert(lhs != null): "BinOpNode: lhs can't be null";
        assert(rhs != null): "BinOpNode: rhs can't be null";
        TypeObj lhsType = lhs.getType();
        TypeObj rhsType = rhs.getType();

        if(lhsType == null || rhsType == null || !lhsType.equals(rhsType)) {
            addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR, lhsType.toString(), rhsType.toString());
            return;
        }

        this.type = operatorToType.get(operator);
    }

}
