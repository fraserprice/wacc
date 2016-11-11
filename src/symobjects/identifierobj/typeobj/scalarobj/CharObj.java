package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.GenericObj;
import symobjects.identifierobj.typeobj.ScalarObj;

public class CharObj extends ScalarObj {

    @Override
    public String toString() {
        return "CHAR";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CharObj || obj instanceof GenericObj;
    }
}
