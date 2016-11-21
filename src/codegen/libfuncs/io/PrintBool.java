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

public class PrintBool extends LibFunc {

    public static final String FUNC_NAME = "lib_print_bool";
    public static final String ARGUMENT_MESSAGE_TRUE = "true\\0";
    public static final String ARGUMENT_MESSAGE_FALSE = "false\\0";

    public PrintBool(DataDir dataDir) {
        super(dataDir);
    }

    /**
     * lib_print_bool:
     *		PUSH {lr}
     *		CMP r0, #0
     *		LDRNE r0, =msg_3
     *		LDREQ r0, =msg_4
     *		ADD r0, r0, #4
     *		BL printf
     *		MOV r0, #0
     *		BL fflush
     *		POP {pc}
     * @return list of instructions needed for the lib_print_bool label
     */
    @Override
    public List<Instruction> getInstructions() {
        return new ArrayList<Instruction>() {{
            add(new LabelIns(FUNC_NAME));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.CMP, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.LDRNE, Register.R0
                    , new Immediate(dataDir.get(ARGUMENT_MESSAGE_TRUE))));
            add(new BaseInstruction(Ins.LDREQ, Register.R0
                    , new Immediate(dataDir.get(ARGUMENT_MESSAGE_FALSE))));
            add(new BaseInstruction(Ins.ADD, Register.R0, Register.R0
                    , new Offset(4)));
            add(new BaseInstruction(Ins.BL, new LabelOp("printf")));
            add(new BaseInstruction(Ins.MOV, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.BL, new LabelOp("fflush")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public String toString() {
        return "PrintBool{}";
    }
}
