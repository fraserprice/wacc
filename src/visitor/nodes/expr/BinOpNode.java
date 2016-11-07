package visitor.nodes.expr;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.operator.BinOp;

public class BinOpNode extends ExprNode {
    public BinOpNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode lhs, ExprNode rhs) {
        super(currentST, ctx);
            /*
            switch (op.getText()) {
            case "*": return MULTIPLY;
            case "/": return DIVISION;
            case "%": return MODULO;
            case "+": return PLUS;
            case "-": return MINUS;
            case ">": return GREATER;
            case ">=": return GREATER_EQ;
            case "<": return SMALLER;
            case "<=": return SMALLER_EQ;
            case "==": return EQ;
            case "!=": return NOT_EQ;
            case "&&": return AND;
            case "||": return OR;
            default: return null;
        }
     */
    }
}
