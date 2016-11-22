package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.PairElemNode;

import java.util.List;

public class AssignLhsPairElemNode extends AssignLhsNode<WACCParser.AssignLhsPairElemContext> {

    private PairElemNode pairElem;

    // assignLhs; pairElem
    public AssignLhsPairElemNode(SymbolTable currentST, WACCParser.AssignLhsPairElemContext
            ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        if (pairElem.hasErrors()) {
            setError();
            return;
        }

        this.type = pairElem.getType();
        this.pairElem = pairElem;
        this.ident = pairElem.getCtx().expr().getText();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return CodeGenerator.getPairPointer(codeGenRef, availableRegisters,
                pairElem.getExpr(), pairElem.getCtx().FST() != null);
    }
}
