package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class IntNode extends LiteralNode {
    private int value;

    public IntNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);

        try {
            this.value = Integer.parseInt(ctx.getText());
        } catch (NumberFormatException e) {
            addError(CompileTimeError.INTEGER_OVERFLOW);
            printErrors();
            System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
        }
    }

    public int getValue() {
        return value;
    }
}
