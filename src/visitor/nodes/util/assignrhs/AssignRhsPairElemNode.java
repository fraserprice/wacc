package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.util.PairElemNode;

import java.util.ArrayList;
import java.util.List;

public class AssignRhsPairElemNode extends AssignRhsNode<WACCParser.AssignRhsPairElemContext> {
    private PairElemNode pNode;

    // assignRhs: pairElem
    public AssignRhsPairElemNode(SymbolTable currentST, WACCParser.AssignRhsPairElemContext
            ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        this.pNode = pairElem;

        if (pairElem.hasErrors()) {
            setError();
            return;
        }

        this.type = pairElem.getType();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return pNode.generateInstructions(codeGenRef, availableRegisters);
    }
}
