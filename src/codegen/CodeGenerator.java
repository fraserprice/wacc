package codegen;

import codegen.operands.Register;
import visitor.nodes.ProgramNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CodeGenerator {

    LinkedList<Instruction> instructions;
    Set<RuntimeError> errorSet;

    public CodeGenerator(ProgramNode program) {
        instructions = program.generateInstructions(Register.allRegisters());
        this.errorSet = getErrors();
        addRuntimeErrorChecks();
        addErrorMessages();
    }

    public String generateCode() {
        return "";
    }

    private HashSet<RuntimeError> getErrors() {
        return null;
    }

    private void addRuntimeErrorChecks() {

    }

    private void addErrorMessages() {

    }

}
