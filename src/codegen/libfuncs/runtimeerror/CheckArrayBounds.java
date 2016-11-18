package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.BaseInstruction;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class CheckArrayBounds extends LibFunc {
    public CheckArrayBounds(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        return null;
    }

    @Override
    public String toString() {
        return "CheckArrayBounds{}";
    }
}
