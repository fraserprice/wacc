package visitor;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {
    protected SymbolTable currentST;
    private List<CompileTimeError> errors;
    protected ParserRuleContext ctx;

    public Node(SymbolTable currentST, ParserRuleContext ctx) {
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

    protected void addSyntacticError(CompileTimeError error) {
        errors.add(error);
        error.printSyntactic(ctx);
        System.exit(CompileTimeError.EXIT_SYNTAX_ERROR);
    }

    protected void addSemanticError(CompileTimeError error) {
        errors.add(error);
        error.printSemantic(ctx);
    }
}
