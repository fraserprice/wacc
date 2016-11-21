package codegen.libfuncs.io;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class ReadChar extends Readable {

    public static final String FUNC_NAME = "lib_read_char";

    public ReadChar(DataDir dataDir) {
        super(dataDir);
    }
}
