package visitor.nodes.expr.literal;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.expr.LiteralNode;

public class IntNode extends LiteralNode<WACCParser.IntLiteralContext> {

    public IntNode(SymbolTable currentST, WACCParser.IntLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("int", IntObj.class);
        check(ctx.getText());
    }

    public IntNode(SymbolTable currentST, String value) {
        super(currentST, null);
        this.type = currentST.lookupAll("int", IntObj.class);
        check(value);
    }

    private void check(String textValue) {
        try {
            Integer value = Integer.parseInt(textValue);
        } catch (NumberFormatException e) {
            addSyntacticError(CompileTimeError.INTEGER_OVERFLOW, ctx.getText());
            System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
        }
    }
}
