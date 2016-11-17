package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ArrayObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class StringNode extends LiteralNode<WACCParser.StrLiteralContext> {

    public StringNode(SymbolTable currentST, WACCParser.StrLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("string", ArrayObj.class);
    }
}
