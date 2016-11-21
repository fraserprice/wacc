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

public class Println extends LibFunc {

    public static final String FUNC_NAME = "lib_print_ln";
    public static final String ARGUMENT_MESSAGE = "\\0";

    public Println(DataDir dataDir) {
        super(dataDir);
    }

    /**
     * lib_print_ln:
     *		PUSH {lr}
     *		LDR r0, =msg_1
     *		ADD r0, r0, #4
     *		BL puts
     *		MOV r0, #0
     *		BL fflush
     *		POP {pc}
     * @return list of instructions needed for the lib_print_ln label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new Immediate(dataDir.get(ARGUMENT_MESSAGE))));
            add(new BaseInstruction(Ins.ADD, Register.R0, Register.R0
                    , new Offset(4)));
            add(new BaseInstruction(Ins.BL, new LabelOp("puts")));
            add(new BaseInstruction(Ins.MOV, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.BL, new LabelOp("fflush")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public String toString() {
        return "Println{}";
    }
}
