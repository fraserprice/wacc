package codegen;

import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.runtimeerror.CheckArrayBounds;
import codegen.operands.*;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.ExprNode;
import visitor.nodes.ProgramNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CodeGenerator {
    /**
     * Main class responsible for generation the assembly
     */

    private DataDir dataDir; // Contains the labels between .data and .text
    private List<Instruction> mainDir; // Contains the labels after .global main
    private List<LibFunc> libDir; // Contains all the lib functions used
    private int labelCount; // How many labels where defined so far

    public CodeGenerator(ProgramNode start) {
        this.dataDir = new DataDir();
        this.libDir = new ArrayList<>();
        this.labelCount = 0;
        List<Register> availableRegisters = Register.allRegisters();
        availableRegisters.remove(Register.R0);
        availableRegisters.remove(Register.R1);
        availableRegisters.remove(Register.R2);
        availableRegisters.remove(Register.R3);
        this.mainDir
                = start.generateInstructions(this, availableRegisters);
    }

    public String addMessage(String message) {
        dataDir.put(message);
        return dataDir.getLargestMessage();
    }

    public String getMessage(String message) {
        return dataDir.get(message);
    }

    public String getNextLabel() {
        String labelName = "LB_" + labelCount;
        labelCount++;
        return labelName;
    }

    public static List<Instruction> makeSpaceOnStack(SymbolTable currentST
            , List<Instruction> inBetween) {

        List<Instruction> ins = new ArrayList<>();
        if (currentST.getOffsetLocation() == 0) {
            return inBetween;
        }
        ins.add(new BaseInstruction(Ins.SUB, Register.SP, Register.SP
                , new Offset(currentST.getOffsetLocation())));
        ins.addAll(inBetween);
        ins.add(new BaseInstruction(Ins.ADD, Register.SP, Register.SP
                , new Offset(currentST.getOffsetLocation())));
        return ins;
    }

    public static List<Instruction> getArrayPointer(
            CodeGenerator codeGenRef, List<Register> availableRegisters,
            List<ExprNode> exprNodeList, TypeObj type, SymbolTable currentST,
            String ident) {

        List<Instruction> instructions = new LinkedList<>();
        Register reg1 = availableRegisters.get(0);
        Register reg2 = availableRegisters.get(1);
        int elemSize = type.getSize();
        int offset = currentST.lookupOffset(ident);

        instructions.add(new BaseInstruction(Ins.ADD, reg1, new Offset(offset)));

        for(int i = 0; i < exprNodeList.size(); i++) {
            List<Register> temp = availableRegisters.stream().skip(1).collect(Collectors.toList());
            instructions.addAll(exprNodeList.get(i).generateInstructions(codeGenRef, temp));
            instructions.add(new BaseInstruction(Ins.LDR, reg1, new StackLocation(reg1)));
            instructions.add(new BaseInstruction(Ins.MOV, Register.R0, reg2));
            instructions.add(new BaseInstruction(Ins.MOV, Register.R1, reg1));
            instructions.add(new BaseInstruction(Ins.BL, new LabelOp(CheckArrayBounds.FUNC_NAME)));
            instructions.add(new BaseInstruction(Ins.AND, reg1, reg1, new Offset(4)));
            if(i == exprNodeList.size() - 1 && elemSize < 4) {
                instructions.add(new BaseInstruction(Ins.ADD, reg1, reg1, reg2));
            } else {
                instructions.add(new BaseInstruction(Ins.ADD, reg1, reg1, reg2,
                        new ShiftInstruction(Ins.LSL, new Offset(2))));
            }
        }

        codeGenRef.useLibFunc(CheckArrayBounds.class);

        return instructions;
    }

    public void useLibFunc(Class<? extends LibFunc> funcClass) {
        for (LibFunc func : libDir) {
            if (funcClass.isInstance(func)) {
                return;
            }
        }

        try {
            LibFunc func = funcClass.getConstructor(DataDir.class).newInstance
                    (dataDir);
            libDir.add(func);

            for (Class<? extends LibFunc> dep : func.getDependencies()) {
                useLibFunc(dep);
            }
        } catch(Exception e) {
            assert(false): "CodeGenerator: Should not get here";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(dataDir.toString());

        sb.append(".text\n\n.global main\n");

        for (Instruction ins : mainDir) {
            sb.append(ins.toString());
        }

        for (LibFunc func : libDir) {
            for (Instruction ins : func.getInstructions()) {
                sb.append(ins.toString());
            }
        }

        return sb.toString();
    }
}
