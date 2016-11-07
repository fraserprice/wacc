package visitor;

import main.CompileTimeError;
import symobjects.SymbolTable;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {
    protected SymbolTable currentST;
    private List<CompileTimeError> errors;

    public Node(SymbolTable currentST) {
        this.currentST = currentST;
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

    /**
     * Prints the errors if there are any
     */
    protected void printErrors() {
        errors.forEach(CompileTimeError::print);
    }

    /**
     * Adds an error to the error list
     * @param error
     */
    protected void addError(CompileTimeError error) {
        errors.add(error);
    }
}
