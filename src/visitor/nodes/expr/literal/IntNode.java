package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class IntNode extends LiteralNode {
    private int value;

    public IntNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        check(ctx.getText());
    }

    public IntNode(SymbolTable currentST, String value) {
        super(currentST, null);
        check(value);
    }

    private void check(String textValue) {
        try {
            this.value = Integer.parseInt(textValue);
        } catch (NumberFormatException e) {
            addError(CompileTimeError.INTEGER_OVERFLOW);
            printSyntacticErrors();
            System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
        }
    }

    public int getValue() {
        return value;
    }
}
