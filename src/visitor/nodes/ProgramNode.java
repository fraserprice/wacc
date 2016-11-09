package visitor.nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.*;
import visitor.Node;

import java.util.List;

// TODO
public class ProgramNode extends Node {
    public ProgramNode(SymbolTable currentST, ParserRuleContext ctx, List<FunctionNode> functionNodeList, StatNode statNode) {
        super(currentST, ctx);
        currentST.add("int", new IntObj(currentST));
        currentST.add("bool", new BoolObj(currentST));
        currentST.add("char", new CharObj(currentST));
        currentST.add("pair", new PairLitObj(currentST));
        currentST.add("string", new StringObj(currentST));
    }
}
