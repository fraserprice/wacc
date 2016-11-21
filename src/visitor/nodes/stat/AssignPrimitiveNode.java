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
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.GenericObj;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;
import visitor.nodes.type.TypeNode;

import java.util.ArrayList;
import java.util.List;

public class AssignPrimitiveNode extends StatNode<WACCParser
        .AssignPrimitiveStatContext> {
    private TypeObj type;
    private String ident;
    private AssignRhsNode rhs;

    public AssignPrimitiveNode(SymbolTable currentST, WACCParser
            .AssignPrimitiveStatContext ctx, TypeNode type, AssignRhsNode
            assignRhs) {
        super(currentST, ctx);

        if (type.hasErrors() || assignRhs.hasErrors()) {
            setError();
            return;
        }

        this.type = type.getType();
        this.ident = ctx.IDENT().getText();
        this.rhs = assignRhs;

        check();
    }

    private void check() {

        if (!IdentifierObj.isValidIdentifierName(ident)) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME, ident);
            return;
        }

        if (!type.equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE, ident,
                    type.toString(), "right hand side", rhs.getType()
                            .toString());
            return;
        }

        if (currentST.lookup(ident, VariableObj.class) != null) {
            addSemanticError(CompileTimeError.VARIABLE_ALREADY_DEFINED, ident);
            return;
        }

        // we don't add the array type because it's size is 0
        if (type instanceof ArrayObj && !(rhs.getType() instanceof
                GenericObj)) {
            ((ArrayObj) type).setElementsNo(((ArrayObj) rhs.getType())
                    .getElementsNo());
        }
        currentST.add(ident, new VariableObj(currentST, type));
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

        instructions.addAll(rhs.generateInstructions(codeGenRef, availableRegisters));

        int offset = currentST.lookupOffset(ident);
        StackLocation location;
        if (offset == 0) {
            location = new StackLocation(Register.SP);
        } else {
            location = new StackLocation(Register.SP, new Offset(offset));
        }

        instructions.add(new BaseInstruction(Ins.STR, availableRegisters.get(0), location));

        return instructions;

    }
}
