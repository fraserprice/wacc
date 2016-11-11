package visitor;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;

import java.util.LinkedList;
import java.util.List;

public abstract class Node<T extends ParserRuleContext> {
    protected SymbolTable currentST;
    private List<CompileTimeError> errors;
    protected T ctx;

    public Node(SymbolTable currentST, T ctx) {
        this.currentST = currentST;
        this.ctx = ctx;
        this.errors = new LinkedList<>();
    }

    /**
     * Returns weather there are any errors
     * @return boolean
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Returns the list of errors
     * @return List
     */
    public List<CompileTimeError> getErrors() {
        return errors;
    }

    protected void addSyntacticError(CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSyntactic(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), tokens);
        System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
    }

    protected void addSemanticError(CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSemantic(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), tokens);
    }

    protected void addSyntacticError(int line, int characterPos, CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSyntactic(line, characterPos, tokens);
        System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
    }

    protected void addSemanticError(int line, int characterPos, CompileTimeError error, String... tokens) {
        errors.add(error);
        error.printSemantic(line, characterPos, tokens);
    }

    public T getCtx() {
        return ctx;
    }
}
