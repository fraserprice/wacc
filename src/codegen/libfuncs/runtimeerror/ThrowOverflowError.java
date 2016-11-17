package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.Bl;
import codegen.instructions.LabelIns;
import codegen.instructions.Ldr;
import codegen.operands.Immediate;
import codegen.operands.LabelOp;
import codegen.operands.Register;

import java.util.ArrayList;
import java.util.List;

public class ThrowOverflowError extends LibFunc {
    public static String FUNC_NAME = "lib_throw_overflow_error";
    public static String ERROR_MESSAGE
            = "OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\\0";

    public ThrowOverflowError(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
    }

    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new Ldr(Register.R0, new Immediate(dataDir.get(ERROR_MESSAGE))));
            add(new Bl(new LabelOp(ThrowRuntimeError.FUNC_NAME)));
        }};
    }

    @Override
    public List<Class<? extends LibFunc>> getDependencies() {
        return new ArrayList<Class<? extends LibFunc>>() {{ add(ThrowRuntimeError.class); }};
    }
}
