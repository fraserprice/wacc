package symobjects;

import main.CompileTimeError;

public abstract class IdentifierObj {
    public static boolean isValidIdentifierName(String name) {
        return !CompileTimeError.invalidIdentifierVariableNames.contains(name);
    }
}
