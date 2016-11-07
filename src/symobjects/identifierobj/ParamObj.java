package symobjects.identifierobj;

import symobjects.SymbolTable;

public class ParamObj extends TypeObj {
    private TypeObj type;

    public ParamObj(SymbolTable identifierST, TypeObj type) {
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
