package visitor.nodes.expr.literal;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import symobjects.identifierobj.typeobj.TyplessPairObj;
import visitor.nodes.expr.LiteralNode;

public class PairNode extends LiteralNode {

    private TyplessPairObj fst;
    private TyplessPairObj snd;

    public PairNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
        this.type = new PairObj(currentST, fst, snd);
        //check(ctx.getChild(0).getText(), ctx.getChild(1).getText());
        //TODO: improve check
        check();
    }

    public void check() {
        try {
            this.fst = new TyplessPairObj(currentST);
            this.snd = new TyplessPairObj(currentST);
        } catch (IllegalArgumentException e) {
            addError(CompileTimeError.TYPE_MISMATCH_ERROR);
            printSyntacticErrors();
        }
    }

    public TyplessPairObj getFst() {
        return fst;
    }

    public TyplessPairObj getSnd() {
        return snd;
    }
}
