package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

import java.util.List;

public class AssignRhsExprNode extends AssignRhsNode<WACCParser.AssignRhsExprContext> {
    private ExprNode rhs;

    public AssignRhsExprNode(SymbolTable currentST, WACCParser.AssignRhsExprContext ctx, ExprNode rhs) {
        super(currentST, ctx);

        this.rhs = rhs;

        if (rhs.hasErrors()) {
            setError();
            return;
        }

        this.type = rhs.getType();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        return rhs.generateInstructions(codeGenRef, availableRegisters);
    }
}
