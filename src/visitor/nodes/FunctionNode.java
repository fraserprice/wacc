package visitor.nodes;

import symobjects.SymbolTable;
import visitor.Node;
import visitor.nodes.expr.IdentNode;
import visitor.nodes.util.ParamNode;
import visitor.nodes.type.TypeNode;

import java.util.List;

// TODO
public class FunctionNode extends Node {
    public FunctionNode(SymbolTable currentST, TypeNode typeNode, IdentNode ident,
                        List<ParamNode> paramNodeList, StatNode statNode) {
        super(currentST);
    }
}
