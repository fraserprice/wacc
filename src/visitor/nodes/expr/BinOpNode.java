package visitor.nodes.expr;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.BinOp;

public class BinOpNode extends ExprNode {
    private BinOp op;
    private ExprNode lhs;
    private ExprNode rhs;

    public BinOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode lhs, ExprNode rhs) {
        super(currentST, ctx);
        this.lhs = lhs;
        this.rhs = rhs;
        check();

        this.type = lhs.getType();

        /*switch (ctx.getText()) {
            case "*":
                this.type = new IntObj(currentST);
                op = BinOp.MULTIPLY;
                break;
            case "/":
                this.type = new IntObj(currentST);
                op = BinOp.DIVISION;
                break;
            case "%":
                this.type = new IntObj(currentST);
                op = BinOp.MODULO;
                break;
            case "+":
                this.type = new IntObj(currentST);
                op = BinOp.PLUS;
                break;
            case "-":
                this.type = new IntObj(currentST);
                op = BinOp.MINUS;
                break;
            case ">":
                this.type = new BoolObj(currentST);
                op = BinOp.GREATER;
                break;
            case ">=":
                this.type = new BoolObj(currentST);
                op = BinOp.GREATER_EQ;
                break;
            case "<":
                this.type = new BoolObj(currentST);
                op = BinOp.SMALLER;
                break;
            case "<=":
                this.type = new BoolObj(currentST);
                op = BinOp.SMALLER_EQ;
                break;
            case "==":
                this.type = new BoolObj(currentST);
                op = BinOp.EQ;
                break;
            case "!=":
                this.type = new BoolObj(currentST);
                op = BinOp.NOT_EQ;
                break;
            case "&&":
                this.type = new BoolObj(currentST);
                op = BinOp.AND;
                break;
            case "||":
                this.type = new BoolObj(currentST);
                op = BinOp.OR;
                break;
        }*/
    }

    private void check() {
        assert(lhs != null): "BinOpNode: lhs can't be null";
        assert(rhs != null): "BinOpNode: rhs can't be null";
        TypeObj lhsType = lhs.getType();
        TypeObj rhsType = rhs.getType();

        if(lhsType== null || rhsType == null || lhsType.equals(rhsType)) {
            addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR);
        }
    }

}
