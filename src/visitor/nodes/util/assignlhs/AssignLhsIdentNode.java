package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Offset;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.util.AssignLhsNode;

import java.util.ArrayList;
import java.util.List;

public class AssignLhsIdentNode extends AssignLhsNode<WACCParser.AssignLhsIdentContext> {
    // assignLhs: IDENT
    public AssignLhsIdentNode(SymbolTable currentST, WACCParser.AssignLhsIdentContext
            ctx) {
        super(currentST, ctx);

        VariableObj identObj = currentST.lookupAll(ctx.IDENT().getText(),
                VariableObj.class);

        if (identObj == null) {
            addSemanticError(CompileTimeError
                    .VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ctx.IDENT()
                    .toString());
            return;
        }

        type = identObj.getType();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

        int identOffset = currentST.lookupOffset(ctx.IDENT().getText());
        Register returnReg = availableRegisters.get(0);

        if (identOffset == 0) {
            instructions.add(new BaseInstruction(Ins.MOV, returnReg, Register.SP));
        } else {
            instructions.add(new BaseInstruction(Ins.MOV, returnReg, Register.SP, new Offset(identOffset)));
        }

        return instructions;
    }
}
