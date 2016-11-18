package codegen.libfuncs.io;

import codegen.DataDir;
import codegen.BaseInstruction;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class ReadInt extends LibFunc {
    public ReadInt(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        return null;
    }

    @Override
    public String toString() {
        return "ReadInt{}";
    }
}
