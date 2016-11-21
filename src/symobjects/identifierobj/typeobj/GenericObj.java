package symobjects.identifierobj.typeobj;

import symobjects.identifierobj.TypeObj;

public class GenericObj extends TypeObj {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof TypeObj;
    }

    @Override
    public int getSize() {
        return 4;
    }
}
