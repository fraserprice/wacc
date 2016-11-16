package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.NullPairObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class PairNode extends LiteralNode<WACCParser.PairLiteralContext> {

    public PairNode(SymbolTable currentST, WACCParser.PairLiteralContext ctx) {
        super(currentST, ctx);
        this.type = currentST.lookupAll("null", NullPairObj.class);
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
