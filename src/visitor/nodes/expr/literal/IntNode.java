package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.expr.LiteralNode;

public class IntNode extends LiteralNode {
    public IntNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = (IntObj) currentST.lookupAll("int");
        check(ctx.getText());
    }

    public IntNode(SymbolTable currentST, String value) {
        super(currentST, null);
        this.type = (IntObj) currentST.lookupAll("int");
        check(value);
    }

    private void check(String textValue) {
        try {
            Integer value = Integer.parseInt(textValue);
        } catch (NumberFormatException e) {
            addSyntacticError(CompileTimeError.INTEGER_OVERFLOW);
            System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
        }
    }
}
