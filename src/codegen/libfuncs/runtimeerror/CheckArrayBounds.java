package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class CheckArrayBounds extends LibFunc {

    public static final String FUNC_NAME = "lib_check_array_bounds";
    public static final String ERROR_MESSAGE
      = "ArrayIndexOutOfBoundsError: negative index/index too large.\n\0";

    public CheckArrayBounds(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
    }

    /**
     * lib_check_array_bounds:
     *		PUSH {lr}
     *		CMP r0, #0
     *		LDRLT r0, =msg_0
     *		BLLT p_throw_runtime_error
     *		LDR r1, [r1]
     *		CMP r0, r1
     *		LDRCS r0, =msg_1
     *		BLCS p_throw_runtime_error
     *		POP {pc}
     * @return list of instructions needed for the check_array_bounds label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.CMP, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.LDRLT, Register.R0, new Immediate(dataDir.get(ERROR_MESSAGE))));
            add(new BaseInstruction(Ins.BLLT, new LabelOp(ThrowRuntimeError.FUNC_NAME)));
            add(new BaseInstruction(Ins.LDR, Register.R1, new StackLocation(Register.R1)));
            add(new BaseInstruction(Ins.CMP, Register.R0, Register.R1));
            add(new BaseInstruction(Ins.LDRCS, Register.R0, new Immediate(dataDir.get(ERROR_MESSAGE))));
            add(new BaseInstruction(Ins.BLCS, new LabelOp(ThrowRuntimeError.FUNC_NAME)));
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
        return "CheckArrayBounds{}";
    }
}
