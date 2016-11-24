package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.operands.Offset;
import codegen.operands.RegList;
import codegen.operands.Register;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.ArrayList;
import java.util.List;

public class ReturnNode extends StatNode<WACCParser.ReturnStatContext> {
    private TypeObj returnType;
    private ExprNode retrunExpr;

    public ReturnNode(SymbolTable currentST, WACCParser.ReturnStatContext
            ctx, ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.returnType = exprNode.getType();
        this.retrunExpr = exprNode;
    }

    public TypeObj getReturnType() {
        return returnType;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();
        instructions.addAll(retrunExpr.generateInstructions(codeGenRef, availableRegisters));
        instructions.add(new BaseInstruction(Ins.MOV, Register.R0,
                availableRegisters.get(0)));
        return instructions;
    }
}
