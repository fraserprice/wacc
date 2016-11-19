package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class CheckDivideByZero extends LibFunc {
    public static final String FUNC_NAME = "lib_check_divide_by_zero";
    public static final String ERROR_MESSAGE
      = "Invalid operation: dividing by zero is undefined.\\n\\0";

    public CheckDivideByZero(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
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
