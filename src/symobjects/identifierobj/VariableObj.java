package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

public class VariableObj extends IdentifierObj {
    private TypeObj type;
    private SymbolTable currentST;

    public VariableObj(SymbolTable currentST, TypeObj type) {
        this.type = type;
        this.currentST = currentST;
    }

    public TypeObj getType() {
        return type;
    }

    public SymbolTable getCurrentST() {
        return currentST;
    }

    @Override
    public String toString() {
        return type.toString() + " variable";
    }
}
