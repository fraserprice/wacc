package codegen.libfuncs;

import codegen.DataDir;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.operands.Immediate;
import codegen.operands.Offset;
import codegen.operands.RegList;
import codegen.operands.Register;

import java.util.ArrayList;
import java.util.List;

public class Modulo extends LibFunc{

    public static final String FUNC_NAME = "lib_modulo";

    public Modulo(DataDir dataDir) {
        super(dataDir);
    }

    @Override
    public List<Instruction> getInstructions() {
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(new LabelIns(FUNC_NAME));
        instructions.add(new BaseInstruction(Ins.PUSH, new RegList(Register
                .LR)));
        instructions.add(new BaseInstruction(Ins.AND, Register.R0, new
                Immediate(255)));
        instructions.add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        return instructions;
    }
}
