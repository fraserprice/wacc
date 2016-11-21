package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.LibFunc;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.io.*;
import codegen.operands.Immediate;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;
import visitor.nodes.expr.literal.IntNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintNode extends StatNode<WACCParser.PrintStatContext> {

    private ExprNode exprNode;

    public PrintNode(SymbolTable currentST, WACCParser.PrintStatContext ctx,
                     ExprNode exprNode) {
        super(currentST, ctx);

        this.exprNode = exprNode;

        if (exprNode.hasErrors()) {
            setError();
            return;
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();
        TypeObj exprType = exprNode.getType();
        BaseInstruction branch = null;
        if (exprType instanceof IntObj) {
            branch = new BaseInstruction(Ins.BL,
                    new LabelOp(Printable.FUNC_NAME_PRINT_INT));
            codeGenRef.useLibFunc(PrintInt.class);
            instructions.add(new BaseInstruction(Ins.MOV, Register.R0,
                    availableRegisters.get(0)));
        } else if (exprType instanceof CharObj) {
            branch = new BaseInstruction(Ins.BL, new LabelOp("putchar"));
            instructions.add(new BaseInstruction(Ins.MOV, Register.R0,
                    availableRegisters.get(0)));
        } else if (exprType instanceof BoolObj) {
            branch  = new BaseInstruction(Ins.BL, new LabelOp
                    (PrintBool.FUNC_NAME));
            codeGenRef.useLibFunc(PrintBool.class);
            instructions.add(new BaseInstruction(Ins.MOV, Register
                    .R0, availableRegisters.get(0)));
        } else if (exprType instanceof ArrayObj && ((ArrayObj)exprType).isString()) {
            branch = new BaseInstruction(Ins.BL, new LabelOp
                    (PrintString.FUNC_NAME));
            codeGenRef.useLibFunc(PrintString.class);
            instructions.add(new BaseInstruction(Ins.MOV, Register.R0,
                    availableRegisters.get(0)));
        } else {
            branch = new BaseInstruction(Ins.BL, new LabelOp
                    (Printable.FUNC_NAME_PRINT_REFERENCE));
            codeGenRef.useLibFunc(PrintReference.class);
            instructions.add(new BaseInstruction(Ins.MOV,Register.R0 ,
                    availableRegisters.get(0)));
        }
        instructions.add(branch);
        return instructions;
    }
}
