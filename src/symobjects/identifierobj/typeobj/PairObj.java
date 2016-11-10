package symobjects.identifierobj.typeobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;

public class PairObj extends TypeObj {
    private TypeObj type1;
    private TypeObj type2;

    public PairObj(TypeObj type1, TypeObj type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    public TypeObj getType1() {
        return type1;
    }

    public TypeObj getType2() {
        return type2;
    }
}
