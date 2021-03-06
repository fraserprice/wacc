package visitor.nodes.stat;

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
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;
import visitor.nodes.util.assignlhs.AssignLhsIdentNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssignPairArrayNode extends StatNode<WACCParser
        .AssignPairArrayStatContext> {
    private AssignLhsNode lhs;
    private AssignRhsNode rhs;

    public AssignPairArrayNode(SymbolTable currentST, WACCParser
            .AssignPairArrayStatContext ctx, AssignLhsNode assignLhsNode,
                               AssignRhsNode assignRhsNode) {
        super(currentST, ctx);

        if (assignLhsNode.hasErrors() || assignRhsNode.hasErrors()) {
            setError();
            return;
        }

        this.lhs = assignLhsNode;
        this.rhs = assignRhsNode;

        check();
    }

    private void check() {
        if (!lhs.getType().equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                    "Left hand side: ", lhs.getType().toString(), "Right hand" +
                            " side: ", rhs.getType().toString());
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();
        Register first = availableRegisters.get(0);
        StackLocation stackLocation;

        if (lhs instanceof AssignLhsIdentNode) {
            String identName = ((WACCParser.AssignLhsIdentContext) lhs.getCtx()).IDENT().getText();
            int identOffset = currentST.lookupOffset(identName);
            instructions.addAll(rhs.generateInstructions(codeGenRef, availableRegisters));

            if (identOffset == 0) {
                stackLocation = new StackLocation(Register.SP);
            } else {
                stackLocation = new StackLocation(Register.SP, new Offset(identOffset));
            }
        } else {
            Register second = availableRegisters.get(1);

            instructions.addAll(rhs.generateInstructions(codeGenRef, availableRegisters));
            List<Register> newAvailableRegisters = availableRegisters.stream().skip(1).collect(Collectors.toList());
            instructions.addAll(lhs.generateInstructions(codeGenRef, newAvailableRegisters));
            stackLocation = new StackLocation(second);
        }

        instructions.add(new BaseInstruction(Ins.getStrInstruciton(rhs.getType()), first, stackLocation));

        return instructions;
    }
}
