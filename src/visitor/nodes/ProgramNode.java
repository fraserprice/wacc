package visitor.nodes;

import symobjects.SymbolTable;
import visitor.Node;

import java.util.List;

// TODO
public class ProgramNode extends Node {
    public ProgramNode(SymbolTable currentST, List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST);
    }
}
