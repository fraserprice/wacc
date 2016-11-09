package visitor.nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.*;
import visitor.Node;

import java.util.List;

public class ProgramNode extends Node {
    public ProgramNode(SymbolTable currentST, ParserRuleContext ctx, List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST, ctx);
    }
}
