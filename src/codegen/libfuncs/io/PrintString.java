package codegen.libfuncs.io;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;

import java.util.List;

public class PrintString extends LibFunc {

    public static final String FUNC_NAME = "lib_print_string";

    public PrintString(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        return null;
    }

    @Override
    public String toString() {
        return "PrintString{}";
    }
}
