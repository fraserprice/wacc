package visitor.nodes.expr;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.BinOp;

public class BinOpNode extends ExprNode {

    private Class<? extends TypeObj> inputType;
    private BinOp op;
    private ExprNode lhs;
    private ExprNode rhs;

    public BinOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode lhs, ExprNode rhs) {
        super(currentST, ctx);
        this.lhs = lhs;
        this.rhs = rhs;
        switch (ctx.getText()) {
            case "*":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                op = BinOp.MULTIPLY;
                break;
            case "/":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                op = BinOp.DIVISION;
                break;
            case "%":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                op = BinOp.MODULO;
                break;
            case "+":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                op = BinOp.PLUS;
                break;
            case "-":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                op = BinOp.MINUS;
                break;
            case ">":
                this.type = new BoolObj(currentST);
                inputType = IntObj.class;
                op = BinOp.GREATER;
                break;
            case ">=":
                this.type = new BoolObj(currentST);
                inputType = IntObj.class;
                op = BinOp.GREATER_EQ;
                break;
            case "<":
                this.type = new BoolObj(currentST);
                inputType = IntObj.class;
                op = BinOp.SMALLER;
                break;
            case "<=":
                this.type = new BoolObj(currentST);
                inputType = IntObj.class;
                op = BinOp.SMALLER_EQ;
                break;
            case "==":
                this.type = new BoolObj(currentST);
                inputType = IntObj.class;
                op = BinOp.EQ;
                break;
            case "!=":
                this.type = new BoolObj(currentST);
                inputType = IntObj.class;
                op = BinOp.NOT_EQ;
                break;
            case "&&":
                this.type = new BoolObj(currentST);
                inputType = BoolObj.class;
                op = BinOp.AND;
                break;
            case "||":
                this.type = new BoolObj(currentST);
                inputType = BoolObj.class;
                op = BinOp.OR;
                break;
        }
        check();
    }

    private void check() {
        if( lhs.getType().getClass() != inputType || rhs.getType().getClass() != inputType ) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
        }
    }

}
