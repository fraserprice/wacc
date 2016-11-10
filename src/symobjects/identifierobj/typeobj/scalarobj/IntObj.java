package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.identifierobj.typeobj.ScalarObj;

public class IntObj extends ScalarObj {

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntObj;
    }
}
