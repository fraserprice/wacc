package codegen.libfuncs.io;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class PrintReference extends Printable {

    public PrintReference(DataDir dataDir) {
        super(dataDir);
    }
}
