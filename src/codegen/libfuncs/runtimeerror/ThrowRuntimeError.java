package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.io.PrintString;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;

import java.util.ArrayList;
import java.util.List;

public class ThrowRuntimeError extends LibFunc {

    public static final String FUNC_NAME = "lib_throw_runtime_error";

    public ThrowRuntimeError(DataDir dataDir) {
        super(dataDir);
    }

    /**
     * lib_throw_runtime_error:
     *		BL p_print_string
     *		MOV r0, #-1
     *		BL exit
     * @return list of instructions needed for the lib_throw_runtime_error label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new BaseInstruction(Ins.BL, new LabelOp(PrintString.FUNC_NAME)));
            add(new BaseInstruction(Ins.MOV, Register.R0, new Offset(-1)));
            add(new BaseInstruction(Ins.BL, new LabelOp("exit")));
        }
        };
    }

    @Override
    public List<Class<? extends LibFunc>> getDependencies() {
        return new ArrayList<Class<? extends LibFunc>>() {{ add(PrintString.class); }};
    }

    @Override
    public String toString() {
        return "ThrowRuntimeError{}";
    }
}
