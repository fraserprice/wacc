package codegen.libfuncs.runtimeerror;

import codegen.*;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.operands.Immediate;
import codegen.operands.LabelOp;
import codegen.operands.Register;

import java.util.ArrayList;
import java.util.List;

public class ThrowOverflowError extends LibFunc {

    public static final String FUNC_NAME = "lib_throw_overflow_error";
    public static final String ERROR_MESSAGE
            = "OverflowError: the result is too small/large " +
              "to store in a 4-byte signed-integer.\\n\\0";
    private final String ERROR_MESSAGE_LOCATION;

    /**
     * Constructor for CheckDivideByZero
     * Has a label for throwing an error if user tries to use a number which is
     * not in the range -2^31 and 2^31 - 1
     */
    public ThrowOverflowError(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
        this.ERROR_MESSAGE_LOCATION = dataDir.getLastMessage();
    }

    /**
     * lib_throw_overflow_error:
     *		LDR r0, =msg_2
     *		BL p_throw_runtime_error
     * @return list of instructions for throw_overflow_error label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new Immediate(ERROR_MESSAGE_LOCATION)));
            add(new BaseInstruction(Ins.BL
                    , new LabelOp(ThrowRuntimeError.FUNC_NAME)));
        }};
    }

    @Override
    public List<Class<? extends LibFunc>> getDependencies() {
        return new ArrayList<Class<? extends LibFunc>>() {{
            add(ThrowRuntimeError.class);
        }};
    }
}
