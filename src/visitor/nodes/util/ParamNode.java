package visitor.nodes.util;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.type.TypeNode;

// TODO
public class ParamNode extends Node {
    public ParamNode(SymbolTable currentST, WACCParser.ParamContext ctx, TypeNode typeNode) {
        super(currentST, ctx);
    }
}
