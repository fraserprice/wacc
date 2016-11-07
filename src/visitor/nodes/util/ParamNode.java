package visitor.nodes.util;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.type.TypeNode;
import visitor.nodes.expr.IdentNode;

// TODO
public class ParamNode extends Node {
    public ParamNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode typeNode, IdentNode ident) {
        super(currentST, ctx);
    }
}
