package visitor.nodes;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;

public abstract class StatNode<T extends WACCParser.StatContext> extends
        Node<T> {
    public StatNode(SymbolTable currentST, T ctx) {
        super(currentST, ctx);
    }
}
