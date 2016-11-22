package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.libfuncs.io.PrintInt;
import codegen.libfuncs.io.Printable;
import codegen.libfuncs.io.ReadChar;
import codegen.libfuncs.io.ReadInt;
import codegen.operands.LabelOp;
import codegen.operands.Offset;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.assignlhs.AssignLhsArrayElemNode;
import visitor.nodes.util.assignlhs.AssignLhsIdentNode;
import visitor.nodes.util.assignlhs.AssignLhsPairElemNode;

import java.util.ArrayList;
import java.util.List;

public class ReadNode extends StatNode<WACCParser.ReadStatContext> {

    private TypeObj typeObj;
    private AssignLhsNode lhs;

    public ReadNode(SymbolTable currentST, WACCParser.ReadStatContext ctx,
                    AssignLhsNode assignLhsNode) {
        super(currentST, ctx);

        this.typeObj = assignLhsNode.getType();
        this.lhs = assignLhsNode;

        if (assignLhsNode.hasErrors()) {
            setError();
            return;
        }

        check();
    }

    private void check() {
        if (!(lhs.getType() instanceof IntObj) && !(lhs.getType() instanceof CharObj)) {
            addSemanticError(CompileTimeError.READ_ERROR, lhs.getType().toString());
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();
        Register reg = availableRegisters.get(0);

        LabelOp labelOp = new LabelOp("0");

        if (typeObj instanceof IntObj) {
            codeGenRef.useLibFunc(ReadInt.class);
            labelOp = new LabelOp(ReadInt.FUNC_NAME_READ_INT);
        } else if (typeObj instanceof CharObj) {
            codeGenRef.useLibFunc(ReadChar.class);
            labelOp = new LabelOp(ReadChar.FUNC_NAME_READ_CHAR);
        }

        int offset = currentST.lookupOffset(lhs.getIdent());


        if(lhs instanceof AssignLhsIdentNode) {

            instructions.add(new BaseInstruction(Ins.ADD, reg, Register.SP, new Offset(offset)));
        } else {
            instructions.addAll(lhs.generateInstructions(codeGenRef, availableRegisters));
        }
        instructions.add(new BaseInstruction(Ins.MOV, Register
                .R0, reg));
        instructions.add(new BaseInstruction(Ins.BL, labelOp));
        return instructions;
    }
}