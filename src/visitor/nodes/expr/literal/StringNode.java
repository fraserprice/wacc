package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.StringObj;
import visitor.nodes.expr.LiteralNode;

public class StringNode extends LiteralNode {

    private String value;

    public StringNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = new StringObj(currentST);
        check(ctx.getText());
    }

    public void check(String value) {
        try {
            this.value = value;
        } catch (IllegalArgumentException e) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
            printSyntacticErrors();
            //TODO: maybe need to gieve a system.out
        }
    }

    public String getValue() {
        return this.value;
    }

}
