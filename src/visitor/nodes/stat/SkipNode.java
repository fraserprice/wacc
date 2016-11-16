package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class SkipNode extends StatNode<WACCParser.SkipStatContext> {
    public SkipNode(SymbolTable currentST, WACCParser.SkipStatContext ctx) {
        super(currentST, ctx);
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
