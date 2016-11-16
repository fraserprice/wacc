package visitor.nodes.expr.literal;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.expr.LiteralNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class BoolNode extends LiteralNode<WACCParser.BoolLiteralContext> {
    public BoolNode(SymbolTable currentST, WACCParser.BoolLiteralContext ctx) {
        super(currentST, ctx);

        type = currentST.lookupAll("bool", BoolObj.class);
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
