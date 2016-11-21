package codegen;

import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.io.PrintBool;
import codegen.libfuncs.io.PrintReference;
import codegen.libfuncs.io.PrintString;
import codegen.libfuncs.runtimeerror.CheckArrayBounds;
import codegen.operands.Offset;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.ProgramNode;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    /**
     * Main class responsible for generation the assembly
     */

    private DataDir dataDir; // Contains the labels between .data and .text
    private List<Instruction> mainDir; // Contains the labels after .global main
    private List<LibFunc> libDir; // Contains all the lib functions used
    private int labelCount; // How many labels where defined so far

    public CodeGenerator(ProgramNode start) {
        this.dataDir = new DataDir();
        this.libDir = new ArrayList<>();
        this.labelCount = 0;
        this.mainDir
                = start.generateInstructions(this, Register.allRegisters());
    }

    public void addMessage(String message) {
        dataDir.put(message);
    }

    public String getMessage(String message) {
        return dataDir.get(message);
    }

    public String getNextLabel() {
        String labelName = "LB_" + labelCount;
        labelCount++;
        return labelName;
    }

    public static List<Instruction> makeSpaceOnStack(SymbolTable currentST
            , List<Instruction> inBetween) {

        List<Instruction> ins = new ArrayList<>();
        if (currentST.getOffsetLocation() == 0) {
            return inBetween;
        }
        ins.add(new BaseInstruction(Ins.SUB, Register.SP, Register.SP
                , new Offset(currentST.getOffsetLocation())));
        ins.addAll(inBetween);
        ins.add(new BaseInstruction(Ins.ADD, Register.SP, Register.SP
                , new Offset(currentST.getOffsetLocation())));
        return ins;
    }

    public void useLibFunc(Class<? extends LibFunc> funcClass) {
        for (LibFunc func : libDir) {
            if (funcClass.isInstance(func)) {
                return;
            }
        }

        try {
            LibFunc func = funcClass.getConstructor(DataDir.class).newInstance
                    (dataDir);
            libDir.add(func);

            for (Class<? extends LibFunc> dep : func.getDependencies()) {
                useLibFunc(dep);
            }
        } catch(Exception e) {
            assert(false): "CodeGenerator: Should not get here";
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
