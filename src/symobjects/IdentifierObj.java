package symobjects;

import main.CompileTimeError;

public abstract class IdentifierObj {
    protected SymbolTable identifierST;

    public IdentifierObj(SymbolTable identifierST) {
        this.identifierST = identifierST;
    }

    public static boolean isValidIdentifierName(String name) {
        return !CompileTimeError.invalidIdentifierVariableNames.contains(name);
    }
}
