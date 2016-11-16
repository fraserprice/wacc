package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class CharNode extends LiteralNode<WACCParser.CharLiteralContext> {
    public CharNode(SymbolTable currentST, WACCParser.CharLiteralContext ctx) {
        super(currentST, ctx);

        this.type = currentST.lookupAll("char", CharObj.class);
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
