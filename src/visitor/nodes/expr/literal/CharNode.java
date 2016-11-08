package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

public class CharNode extends LiteralNode {

    private char value;

    public CharNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = new CharObj(currentST);
        check(ctx.getText());
    }

    public void check(String textValue) {
        try {
           this.value = textValue.charAt(0);
        } catch (IllegalArgumentException e) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
            printSyntacticErrors();
            //TODO: maybe need to gieve a system.out
        }
    }

    public char getValue() {
        return this.value;
    }
}
