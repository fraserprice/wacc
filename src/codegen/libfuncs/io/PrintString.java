package codegen.libfuncs.io;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class PrintString extends LibFunc {

    public static final String FUNC_NAME = "lib_print_string";
    public static final String ARGUMENT_MESSAGE = "%.*s\\0";
    private final String ARGUMENT_MESSAGE_LOCATION;

    public PrintString(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ARGUMENT_MESSAGE);
        this.ARGUMENT_MESSAGE_LOCATION = this.dataDir.getLastMessage();
    }

    /**
     * lib_print_string:
     *		PUSH {lr}
     *		LDR r1, [r0]
     *		ADD r2, r0, #4
     *		LDR r0, =msg_1
     *		ADD r0, r0, #4
     *		BL printf
     *		MOV r0, #0
     *		BL fflush
     *		POP {pc}
     * @return list of instructions needed for the lib_print_string label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.LDR, Register.R1
                    , new StackLocation(Register.R0)));
            add(new BaseInstruction(Ins.ADD, Register.R2, Register.R0
                    , new Offset(4)));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new Immediate(ARGUMENT_MESSAGE_LOCATION)));
            add(new BaseInstruction(Ins.ADD, Register.R0
                    , Register.R0, new Offset(4)));
            add(new BaseInstruction(Ins.BL, new LabelOp("printf")));
            add(new BaseInstruction(Ins.MOV, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.BL, new LabelOp("fflush")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public String toString() {
        return "PrintString{}";
    }
}
