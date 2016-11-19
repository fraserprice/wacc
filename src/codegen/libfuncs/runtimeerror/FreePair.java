package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class FreePair extends LibFunc {
    public static final String FUNC_NAME = "lib_free_pair";
    public static final String ERROR_MESSAGE
      = "NullReferenceError: dereference a null reference.\\n\\0";

    public FreePair(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
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
