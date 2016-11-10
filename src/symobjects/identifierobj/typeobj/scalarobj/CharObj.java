package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ScalarObj;

public class CharObj extends ScalarObj {

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CharObj;
    }
}
