package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.UnOp;

// TODO
public class UnaryOpNode extends ExprNode {
    public UnaryOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode argument) {
        super(currentST, ctx);
        /*switch (op.getText()) {
            case "+": return PLUS;
            case "-": return MINUS;
            case "!": return NOT;
            case "len": return LEN;
            case "chr": return CHR;
            case "ord": return ORD;
            default: return null;
        }*/
    }
}
