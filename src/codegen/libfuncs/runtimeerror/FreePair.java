package codegen.libfuncs.runtimeerror;

import codegen.BaseInstruction;
import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class FreePair extends LibFunc {
    public FreePair(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        return null;
    }

    @Override
    public String toString() {
        return "FreePair{}";
    }
}
