package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ScopeBlockNode extends StatNode<WACCParser.ScopeBlockStatContext> {
    private StatNode body;

    public ScopeBlockNode(SymbolTable currentST, WACCParser
            .ScopeBlockStatContext ctx, StatNode statNode) {
        super(currentST, ctx);

        if (statNode.hasErrors()) {
            setError();
            return;
        }

        this.body = statNode;
    }

    public StatNode getBody() {
        return body;
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
