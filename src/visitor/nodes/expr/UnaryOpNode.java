package visitor.nodes.expr;

import com.sun.org.apache.xpath.internal.operations.Bool;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.UnOp;

import javax.lang.model.type.ArrayType;

// TODO
public class UnaryOpNode extends ExprNode {

    private UnOp unOp;
    private Class<? extends TypeObj> inputType;
    private ExprNode argument;

    public UnaryOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode argument) {
        super(currentST, ctx);
        this.argument = argument;
        switch (getOp(ctx.getText())) {
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
        }
        check();
    }

    public void check() {
        if( argument.getType().getClass() != inputType ) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
        }
    }

    private String getOp(String unExpr) {
        String[] prefixes = {"+", "-", "!", "len", "chr", "ord"};
        String retPrefix = "Error";
        for(String prefix : prefixes) {
            if(unExpr.startsWith(prefix)) {
                retPrefix = prefix;
            }
        }
        return retPrefix;
    }

}
