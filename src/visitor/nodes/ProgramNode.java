package visitor.nodes;

import antlr.WACCParser;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.*;
import visitor.Node;

import java.util.List;

public class ProgramNode extends Node<WACCParser.ProgramContext> {
    public ProgramNode(SymbolTable currentST, WACCParser.ProgramContext ctx, List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST, ctx);
    }
}
