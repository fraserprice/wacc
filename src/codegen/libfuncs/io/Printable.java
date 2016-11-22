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

public abstract class Printable extends LibFunc {

    public static final String FUNC_NAME_PRINT_INT
            = "lib_print_int";
    public static final String ARGUMENT_MESSAGE_PRINT_INT = "%d\\0";

    public static final String FUNC_NAME_PRINT_REFERENCE
            = "lib_print_reference";
    public static final String ARGUMENT_MESSAGE_PRINT_REFERENCE = "%p\\0";

    private final String messageLocation;

    /**
     * Constructor for PrintInt or PrintReference
     * Note: Only msg differs between lib_print_int and lib_print_reference
     */
    public Printable(DataDir dataDir, String message) {
        super(dataDir);
        dataDir.put(message);
        this.messageLocation = dataDir.getLastMessage();
    }

    /**
     * lib_print_int/reference:
     *		PUSH {lr}
     *		MOV r1, r0
     *		LDR r0, =msg_0
     *		ADD r0, r0, #4
     *		BL printf
     *		MOV r0, #0
     *		BL fflush
     *		POP {pc}
     * @return list of instructions needed for the lib_print_int/reference label
     */
    @Override
    public List<Instruction> getInstructions() {
        final String labelName = (getClass().equals(PrintInt.class))
                ? FUNC_NAME_PRINT_INT : FUNC_NAME_PRINT_REFERENCE;

        return new ArrayList<Instruction>() {{
            add(new LabelIns(labelName));
            add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
            add(new BaseInstruction(Ins.MOV, Register.R1, Register.R0));
            add(new BaseInstruction(Ins.LDR, Register.R0
                    , new Immediate(messageLocation)));
            add(new BaseInstruction(Ins.ADD, Register.R0, Register.R0
                    , new Offset(4)));
            add(new BaseInstruction(Ins.BL, new LabelOp("printf")));
            add(new BaseInstruction(Ins.MOV, Register.R0, new Offset(0)));
            add(new BaseInstruction(Ins.BL, new LabelOp("fflush")));
            add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        }};
    }

    @Override
    public String toString() {
        return (getClass().equals(PrintInt.class))
                ? "PrintInt{}" : "PrintReference{}";
    }
}