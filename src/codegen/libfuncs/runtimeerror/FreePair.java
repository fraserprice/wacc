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

public class FreePair extends LibFunc {

    public static final String FUNC_NAME = "lib_free_pair";
    public static final String ERROR_MESSAGE
      = "NullReferenceError: dereference a null reference.\\n\\0";
    private final String ERROR_MESSAGE_LOCATION;

    /**
     * Constructor for FreePair
     * Has a label for throwing an error if user tries to free an address which
     * doesn't contain anything.
     */
    public FreePair(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ERROR_MESSAGE);
        this.ERROR_MESSAGE_LOCATION = this.dataDir.getLastMessage();
    }

    /**
     * lib_free_pair:
     *		PUSH {lr}
     *		CMP r0, #0
     *		LDREQ r0, =msg_n
     *		BEQ p_throw_runtime_error
     *		PUSH {r0}
     *		LDR r0, [r0]
     *		BL free
     *		LDR r0, [sp]
     *		LDR r0, [r0, #4]
     *		BL free
     *		POP {r0}
     *		BL free
     *		POP {pc}
     * @return list of instructions needed for the free_pair label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.CMP, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.LDREQ, Register.R0
                    , new Immediate(ERROR_MESSAGE_LOCATION)));
            add(new BaseInstruction(Ins.BEQ
                    , new LabelOp(ThrowRuntimeError.FUNC_NAME)));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.R0)));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new StackLocation(Register.R0)));
            add(new BaseInstruction(Ins.BL, new LabelOp("free")));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new StackLocation(Register.SP)));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new StackLocation(Register.R0, new Offset(4))));
            add(new BaseInstruction(Ins.BL, new LabelOp("free")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.R0)));
            add(new BaseInstruction(Ins.BL, new LabelOp("free")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public List<Class<? extends LibFunc>> getDependencies() {
        return new ArrayList<Class<? extends LibFunc>>() {{
            add(ThrowRuntimeError.class);
        }};
    }

    @Override
    public String toString() {
        return "FreePair{}";
    }
}
