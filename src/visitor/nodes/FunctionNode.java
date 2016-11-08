package visitor.nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.util.ParamNode;
import visitor.nodes.type.TypeNode;

import java.util.List;

// TODO
public class FunctionNode extends Node {
    public FunctionNode(SymbolTable currentST, ParserRuleContext ctx, TypeNode typeNode,
                        List<ParamNode> paramNodeList, StatNode statNode) {
        super(currentST, ctx);
    }

    public void check() {

    }
}
