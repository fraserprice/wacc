package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.ArrayElementNode;
import visitor.nodes.util.AssignLhsNode;
import java.util.List;

public class AssignLhsArrayElemNode extends AssignLhsNode<WACCParser.AssignLhsArrayElemContext> {
    private ArrayElementNode arrayElementNode;

    // assignLhs: arrayElem
    public AssignLhsArrayElemNode(SymbolTable currentST, WACCParser.AssignLhsArrayElemContext
            ctx, ArrayElementNode arrayElem) {
        super(currentST, ctx);

        this.arrayElementNode = arrayElem;

        if (arrayElem.hasErrors()) {
            setError();
            return;
        }

        this.type = arrayElem.getType();
        this.ident = arrayElem.getIdent();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<ExprNode> exprNodeList = arrayElementNode.getExprNodeList();
        return CodeGenerator.getArrayPointer(codeGenRef, availableRegisters, exprNodeList,
                type, currentST, arrayElementNode.getIdent());
    }
}
