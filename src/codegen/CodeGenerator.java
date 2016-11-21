package codegen;

import codegen.libfuncs.io.PrintBool;
import codegen.libfuncs.io.PrintReference;
import codegen.libfuncs.io.PrintString;
import codegen.libfuncs.runtimeerror.CheckArrayBounds;
import codegen.operands.Register;
import visitor.nodes.ProgramNode;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    /**
     * Main class responsible for generation the assembly
     */

    private DataDir dataDir; // contains the labels between .data and .text
    private List<Instruction> mainDir; // contains the labels after .global main
    private List<LibFunc> libDir; // contains all the lib functions used
    private int labelCount;

    public CodeGenerator(ProgramNode start) {
        this.dataDir = new DataDir();
        this.mainDir = start.generateInstructions(this, Register.allRegisters());
        this.libDir = new ArrayList<>();
        this.labelCount = 0;
    }

    public String getNextLabel() {
        String labelName = "LB_" + labelCount;
        labelCount++;
        return labelName;
    }

    public void useLibFunc(Class<? extends LibFunc> funcClass) {
        for (LibFunc func : libDir) {
            if (funcClass.isInstance(func)) {
                return;
            }
        }
        LibFunc func = null;
        try {
            func = funcClass.getConstructor(DataDir.class).newInstance(dataDir);
        } catch(Exception e) { assert(false): "CodeGenerator: Should not get here"; }

        libDir.add(func);

        for (Class<? extends LibFunc> dep : func.getDependencies()) {
            useLibFunc(dep);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(dataDir.toString());

        sb.append(".text\n\n.global main\n");

        for (Instruction ins : mainDir) {
            sb.append(ins.toString());
        }

        for (LibFunc func : libDir) {
            for (Instruction ins : func.getInstructions()) {
                sb.append(ins.toString());
            }
        }

        return sb.toString();
    }
}
