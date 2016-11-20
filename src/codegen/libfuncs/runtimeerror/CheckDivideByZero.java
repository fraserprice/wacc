package codegen.libfuncs.runtimeerror;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class CheckDivideByZero extends LibFunc {

    public static final String FUNC_NAME = "lib_check_divide_by_zero";
    public static final String ERROR_MESSAGE
      = "DivideByZeroError: divide or modulo by zero.\\n\\0";

    public CheckDivideByZero(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
    }

    /**
     * lib_check_divide_by_zero:
     *		PUSH {lr}
     *		CMP r1, #0
     *		LDREQ r0, =msg_0
     *		BLEQ p_throw_runtime_error
     *		POP {pc}
     * @return list of instructions needed for the check_divide_by_zero label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.CMP, Register.R1, new Offset(0)));
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
        return "CheckDivideByZero{}";
    }
}
