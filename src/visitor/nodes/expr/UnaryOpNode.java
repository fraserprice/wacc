package visitor.nodes.expr;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;


// TODO
public class UnaryOpNode extends ExprNode {
    private ExprNode argument;

    public UnaryOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode argument) {
        super(currentST, ctx);
        /*switch (getOp(ctx.getText())) {
            case "+":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                unOp = UnOp.PLUS;
                break;
            case "-":
                this.type = new IntObj(currentST);
                inputType = IntObj.class;
                unOp = UnOp.MINUS;
                break;
            case "!":
                this.type = new BoolObj(currentST);
                inputType = BoolObj.class;
                unOp = UnOp.NOT;
                break;
            case "len":
                this.type = new IntObj(currentST);
                inputType = ArrayObj.class;
                unOp = UnOp.LEN;
                break;
            case "chr":
                this.type = new CharObj(currentST);
                inputType = IntObj.class;
                unOp = UnOp.CHR;
                break;
            case "ord":
                this.type = new IntObj(currentST);
                inputType = CharObj.class;
                unOp = UnOp.ORD;
                break;
        }*/
        this.argument = argument;
        if (!argument.hasErrors()) {
            check();
        }
    }

    public void check() {
        assert (argument != null): "UnaryOp: argument can't be null";
        assert (argument.getType() != null): "UnaryOp: argument should have a type";

        type = argument.getType();
    }
}
