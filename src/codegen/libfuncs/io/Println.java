package codegen.libfuncs.io;

import codegen.BaseInstruction;
import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class Println extends LibFunc {
    public Println(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        return null;
    }

    @Override
    public String toString() {
        return "Println{}";
    }
}
