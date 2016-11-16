package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.scalarobj.BoolObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class IfNode extends StatNode<WACCParser.IfStatContext> {

    private StatNode thenStat;
    private StatNode elseStat;

    public IfNode(SymbolTable currentST, WACCParser.IfStatContext ctx,
                  ExprNode exprNode, StatNode thenStat, StatNode elseStat) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.elseStat = elseStat;
        this.thenStat = thenStat;

        check(exprNode);
    }

    private void check(ExprNode exprNode) {
        if (!(exprNode.getType() instanceof BoolObj)) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE,
                    "If statement", "BOOL", exprNode.getCtx().getText(),
                    exprNode.getType().toString());
        }
    }

    public StatNode getThenBlock() {
        return thenStat;
    }

    public StatNode getElseBlock() {
        return elseStat;
    }

    @Override
    public LinkedList<Instruction> generateInstructions(LinkedHashSet<Register> availableRegisters) {
        return null;
    }
}
