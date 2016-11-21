package codegen.libfuncs.io;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.*;

import java.util.ArrayList;
import java.util.List;

public class ReadInt extends LibFunc {

    public static final String FUNC_NAME = "lib_read_int";
    public static final String ARGUMENT_MESSAGE = "%d\\0";

    public ReadInt(DataDir dataDir) {
        super(dataDir);
    }

    /**
     * lib_read_int:
     *		PUSH {lr}
     *		MOV r1, r0
     *		LDR r0, =msg_3
     *		ADD r0, r0, #4
     *		BL scanf
     *		POP {pc}
     * @return list of instructions needed for the lib_read_int label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.MOV, Register.R1, Register.R0));
            add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate(dataDir.get(ARGUMENT_MESSAGE))));
            add(new BaseInstruction(Ins.ADD, Register.R0, Register.R0, new Offset(4)));
            add(new BaseInstruction(Ins.BL, new LabelOp("scanf")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public String toString() {
        return "ReadInt{}";
    }
}
