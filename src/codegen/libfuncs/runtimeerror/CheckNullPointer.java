package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class CheckNullPointer extends LibFunc {

    public static final String FUNC_NAME = "lib_check_null_pointer";
    public static final String ERROR_MESSAGE
      = "NullReferenceError: dereference a null reference.\\n\\0";

    public CheckNullPointer(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
    }

    /**
     * lib_check_null_pointer:
     *		PUSH {lr}
     *		CMP r0, #0
     *		LDREQ r0, =msg_0
     *		BLEQ p_throw_runtime_error
     *		POP {pc}
     * @return list of instructions needed for the check_null_pointer label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.CMP, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.LDREQ, Register.R0, new Immediate(dataDir.get(ERROR_MESSAGE))));
            add(new BaseInstruction(Ins.BLEQ, new LabelOp(ThrowRuntimeError.FUNC_NAME)));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public List<Class<? extends LibFunc>> getDependencies() {
        return new ArrayList<Class<? extends LibFunc>>() {{ add(ThrowRuntimeError.class); }};
    }

    @Override
    public String toString() {
        return "CheckNullPointer{}";
    }
}
