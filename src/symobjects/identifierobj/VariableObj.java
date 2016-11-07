package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

public class VariableObj extends IdentifierObj {
    private TypeObj type;

    public VariableObj(SymbolTable identifierST, TypeObj type) {
        super(identifierST);
        this.type = type;
    }

    public TypeObj getType() {
        return type;
    }

    public void setType(TypeObj type) {
        this.type = type;
    }
}
