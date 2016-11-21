package visitor.nodes;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.instructions.BaseInstruction;
import codegen.instructions.Ins;
import codegen.instructions.LabelIns;
import codegen.instructions.Ltorg;
import codegen.operands.Offset;
import codegen.operands.RegList;
import codegen.operands.Register;
import codegen.operands.StackOp;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.TypeObj;
import visitor.Node;
import visitor.nodes.stat.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class FunctionNode extends Node<WACCParser.FuncContext> {

    private FunctionObj fObj;
    private StatNode body;
    private String name;

    public FunctionNode(SymbolTable currentST, WACCParser.FuncContext ctx,
                        FunctionObj fObj, StatNode statNode) {
        super(currentST, ctx);

        if (statNode.hasErrors()) {
            setError();
            return;
        }

        this.fObj = fObj;
        this.body = statNode;
        this.name = ctx.IDENT().getText();

        check();
    }

    private void check() {
        StatNode current = body;
        List<ReturnNode> returnStatList = new LinkedList<>();

        if (!lastStatIsReturn(current, returnStatList)) {
            addSyntacticError(CompileTimeError
                    .RETURN_STATEMENT_MISSING_FROM_LAST_LINE);
        }

        for (ReturnNode retStat : returnStatList) {
            TypeObj returnStatementType = retStat.getReturnType();

            if (!returnStatementType.equals(fObj.getReturnType())) {
                addSemanticError(retStat.getCtx().start.getLine(), retStat
                                .getCtx().start.getCharPositionInLine(),
                        CompileTimeError.RETURN_TYPE_MISMATCH,
                        fObj.getReturnType().toString(), returnStatementType
                                .toString());
                return;
            }
        }
    }

    private boolean lastStatIsReturn(StatNode current, List<ReturnNode>
            returns) {

        while (current instanceof CompositionNode) {
            current = ((CompositionNode) current).getSecondStatNode();
        }

        if (current instanceof IfNode) {
            return lastStatIsReturn(((IfNode) current).getElseBlock(),
                    returns) && lastStatIsReturn(((IfNode) current)
                    .getThenBlock(), returns);
        } else if (current instanceof WhileNode) {
            return lastStatIsReturn(((WhileNode) current).getStatNode(),
                    returns);
        } else if (current instanceof ScopeBlockNode) {
            return lastStatIsReturn(((ScopeBlockNode) current).getBody(),
                    returns);
        } else if (!(current instanceof ExitNode) && !(current instanceof
                ReturnNode)) {
            return false;
        }
        if (current instanceof ReturnNode) {
            returns.add((ReturnNode) current);
        }
        return true;
    }

    @Override
    public List<Instruction> generateInstructions(CodeGenerator codeGenRef, List<Register> availableRegisters) {
        List<Instruction> ins = new ArrayList<>();

        int usedVariableSpace = fObj.getVariableSpace();

        ins.add(new LabelIns("f_" + name));
        ins.add(new BaseInstruction(Ins.PUSH, new RegList(Register.LR)));
        ins.add(new BaseInstruction(Ins.SUB, new StackOp(), new StackOp(),
                new Offset(usedVariableSpace)));
        ins.addAll(body.generateInstructions(codeGenRef, availableRegisters));
        ins.add(new BaseInstruction(Ins.ADD, new StackOp(), new StackOp(),
                new Offset(usedVariableSpace)));
        ins.add(new BaseInstruction(Ins.POP, new RegList(Register.PC)));
        ins.add(new Ltorg());

        return ins;
    }
}
