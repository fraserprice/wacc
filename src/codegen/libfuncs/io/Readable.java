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

public abstract class Readable extends LibFunc {

    public static final String FUNC_NAME_READ_INT = "lib_read_int";
    public static final String ARGUMENT_MESSAGE_READ_INT = "%d\\0";
    public static final String FUNC_NAME_READ_CHAR = "lib_read_char";
    public static final String ARGUMENT_MESSAGE_READ_CHAR = " %c\\0";

    // Note: Only msg differs between lib_read_int and lib_read_char
    public Readable(DataDir dataDir) {
        super(dataDir);
        this.dataDir.put(ARGUMENT_MESSAGE_READ_CHAR);
        this.dataDir.put(ARGUMENT_MESSAGE_READ_INT);
    }

    /**
     * lib_read_int/char:
     *		PUSH {lr}
     *		MOV r1, r0
     *		LDR r0, =msg_3
     *		ADD r0, r0, #4
     *		BL scanf
     *		POP {pc}
     * @return list of instructions needed for the lib_read label
     */
    @Override
    public List<Instruction> getInstructions() {
        final String argumenMessage = (getClass().equals(ReadInt.class))
                ? ARGUMENT_MESSAGE_READ_INT : ARGUMENT_MESSAGE_READ_CHAR;
        final String labelName = (getClass().equals(ReadInt.class))
                ? FUNC_NAME_READ_INT : FUNC_NAME_READ_CHAR;

        return new ArrayList<Instruction>() {{
            add(new LabelIns(labelName));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.MOV, Register.R1, Register.R0));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new Immediate(dataDir.get(argumenMessage))));
            add(new BaseInstruction(Ins.ADD, Register.R0, Register.R0
                    , new Offset(4)));
            add(new BaseInstruction(Ins.BL, new LabelOp("scanf")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }
        };
    }

    @Override
    public String toString() {
        return (getClass().equals(ReadInt.class)) ? "ReadInt{}" : "ReadChar{}";
    }
}
