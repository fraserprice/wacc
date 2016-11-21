package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.Ins;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.CharObj;
import symobjects.identifierobj.typeobj.scalarobj.IntObj;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;

import java.util.ArrayList;
import java.util.List;

public class ReadNode extends StatNode<WACCParser.ReadStatContext> {

    public ReadNode(SymbolTable currentST, WACCParser.ReadStatContext ctx,
                    AssignLhsNode assignLhsNode) {
        super(currentST, ctx);

        if (assignLhsNode.hasErrors()) {
            setError();
            return;
        }

        check(assignLhsNode);
    }

    private void check(AssignLhsNode assignLhsNode) {
        if (!(assignLhsNode.getType() instanceof IntObj) && !(assignLhsNode
                .getType() instanceof CharObj)) {
            addSemanticError(CompileTimeError.READ_ERROR, assignLhsNode
                    .getType().toString());
        }
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> instructions = new ArrayList<>();

    }
}