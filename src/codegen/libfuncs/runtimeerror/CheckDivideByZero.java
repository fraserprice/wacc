package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.BaseInstruction;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class CheckDivideByZero extends LibFunc {
    public CheckDivideByZero(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        return null;
    }

    @Override
    public String toString() {
        return "CheckDivideByZero{}";
    }
}
