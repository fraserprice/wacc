package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Offset;
import codegen.operands.Register;
import codegen.operands.StackLocation;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.util.AssignLhsNode;

import java.util.LinkedList;
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

        this.type = identObj.getType();
        this.ident = ctx.IDENT().getText();
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        int offset = currentST.lookupOffset(ident);

        List<Instruction> instructions = new LinkedList<Instruction>() {{
            if(offset == 0) {
                add(new BaseInstruction(Ins.getLdrInstruction(type), availableRegisters.get(0),
                        new StackLocation(Register.SP)));

            } else {
                add(new BaseInstruction(Ins.getLdrInstruction(type), availableRegisters.get(0),
                        new StackLocation(Register.SP, new Offset(offset))));
            }
        }};

        return instructions;
    }
}
