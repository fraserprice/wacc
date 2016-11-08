package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.expr.LiteralNode;

public class BoolNode extends LiteralNode {

    private boolean value;

    public BoolNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = new BoolObj(currentST);
        check(ctx.getText());
    }

    public void check(String textValue) {
        try {
            this.value = Boolean.parseBoolean(textValue);
        } catch (IllegalArgumentException e) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
            printSyntacticErrors();
            //TODO: maybe need to gieve a system.out
        }
    }

    public boolean getValue() {
        return this.value;
    }

}
