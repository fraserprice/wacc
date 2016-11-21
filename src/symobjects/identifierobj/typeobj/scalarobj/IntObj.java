package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.identifierobj.typeobj.GenericObj;
import symobjects.identifierobj.typeobj.ScalarObj;

public class IntObj extends ScalarObj {

    @Override
    public String toString() {
        return "INT";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntObj || obj instanceof GenericObj;
    }

    @Override
    public int getSize() {
        return 4;
    }
}
