package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class IntNode extends LiteralNode {
    private int value;

    public IntNode(SymbolTable currentST, TerminalNode representation) {
        super(currentST, representation);

        try {
            this.value = Integer.parseInt(representation.getText());
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
