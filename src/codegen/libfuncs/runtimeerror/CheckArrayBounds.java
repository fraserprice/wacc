package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class CheckArrayBounds extends LibFunc {
    public static final String FUNC_NAME = "lib_check_array_bounds";
    public static final String ERROR_MESSAGE
      = "ArrayIndexOutOfBoundsError: negative index/index too large.\n\0";

    public CheckArrayBounds(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
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
