package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.identifierobj.typeobj.GenericObj;
import symobjects.identifierobj.typeobj.ScalarObj;

public class BoolObj extends ScalarObj {

    @Override
    public String toString() {
        return "BOOL";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BoolObj || obj instanceof GenericObj;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
