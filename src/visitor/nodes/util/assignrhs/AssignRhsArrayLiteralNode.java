package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.Operand;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.*;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.GenericObj;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

import java.util.ArrayList;
import java.util.List;

public class AssignRhsArrayLiteralNode extends AssignRhsNode<WACCParser.AssignRhsArrayLiteralContext> {
    private List<ExprNode> args;

    // assignRhs: arrayLiteral
    public AssignRhsArrayLiteralNode(SymbolTable currentST, WACCParser.AssignRhsArrayLiteralContext
            ctx, List<ExprNode> arrayArgs) {
        super(currentST, ctx);

        this.args = arrayArgs;

        for (ExprNode arg : arrayArgs) {
            if (arg.hasErrors()) {
                setError();
                return;
            }
        }

        if (arrayArgs.isEmpty()) {
            this.type = new ArrayObj(new GenericObj());
            return;
        }

        int noSameTypeAsFirst = (int) arrayArgs.stream().filter(expr -> expr
                .getType().equals(arrayArgs.get(0).getType())).count();
        if (noSameTypeAsFirst != arrayArgs.size()) {
            addSemanticError(CompileTimeError.ARRAY_LITERAL_TYPE_DONT_MATCH);
            return;
        }

        this.type = new ArrayObj(arrayArgs.get(0).getType(), arrayArgs.size());
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        assert (type instanceof ArrayObj): "Type should always be an ArrayObj";
        List<Instruction> instructions = new ArrayList<>();

        ArrayObj arrayType = (ArrayObj) type;
        Operand o1 = availableRegisters.get(0);
        Operand o2 = availableRegisters.get(1);
        availableRegisters.remove(o1);

        instructions.add(new BaseInstruction(Ins.LDR, Register.R0, new Immediate(arrayType.getHeapSize())));
        instructions.add(new BaseInstruction(Ins.BL, new LabelOp("malloc")));
        instructions.add(new BaseInstruction(Ins.MOV, o1, Register.R0));
        // load second operand with array size and store it
        instructions.add(new BaseInstruction(Ins.LDR, o2, new Immediate(arrayType.getElementsNo())));
        instructions.add(new BaseInstruction(Ins.STR, o2, new StackLocation(o1)));

        int arrayIndex = 4;
        for (ExprNode arg : args) {
            instructions.addAll(arg.generateInstructions(codeGenRef, availableRegisters));
            instructions.add(new BaseInstruction(Ins.getStrInstruciton(arg.getType()),
                    availableRegisters.get(0), new StackLocation(o1, new Offset(arrayIndex))));
            arrayIndex += arrayType.getType().getSize();
        }

        return instructions;
    }
}
