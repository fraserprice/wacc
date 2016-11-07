package visitor.nodes.expr.literal;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.expr.LiteralNode;

public class StringNode extends LiteralNode {

    public StringNode(SymbolTable currentST, TerminalNode representation) {
        super(currentST, representation);
    }
}
