package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

public class VariableObj extends IdentifierObj {
    private TypeObj type;
    private SymbolTable currentST;
    private int offset;

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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return type.toString() + " variable";
    }
}
