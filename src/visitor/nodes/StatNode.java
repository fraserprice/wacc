package visitor.nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;

import java.util.List;

public abstract class StatNode extends Node {
    public StatNode(SymbolTable currentST, ParserRuleContext ctx) {
        super(currentST, ctx);
    }
}
