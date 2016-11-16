package visitor;

import codegen.Instruction;
import codegen.RegisterSet;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;

import java.util.LinkedList;
import java.util.List;

public abstract class Node<T extends ParserRuleContext> {
    protected SymbolTable currentST;
    private List<CompileTimeError> errors;
    protected T ctx;
    private boolean hasErrors;

    public Node(SymbolTable currentST, T ctx) {
        this.currentST = currentST;
        this.ctx = ctx;
        this.errors = new LinkedList<>();
    }

    public boolean hasErrors() {
        return hasErrors;
    }


    public void setError() {
        this.hasErrors = true;
    }

    protected void addSyntacticError(CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSyntactic(ctx.getStart().getLine(), ctx.getStart()
                .getCharPositionInLine(), tokens);
        System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
    }

    protected void addSemanticError(CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSemantic(ctx.getStart().getLine(), ctx.getStart()
                .getCharPositionInLine(), tokens);
        setError();
    }

    protected void addSyntacticError(int line, int characterPos,
                                     CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSyntactic(line, characterPos, tokens);
        System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
    }

    protected void addSemanticError(int line, int characterPos,
                                    CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSemantic(line, characterPos, tokens);
        setError();
    }

    public T getCtx() {
        return ctx;
    }

    public abstract LinkedList<Instruction> generateInstructions(RegisterSet availableRegisters);

}
