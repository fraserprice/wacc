package symobjects.identifierobj.typeobj;

import symobjects.identifierobj.TypeObj;

public class EmptyArrayObj extends TypeObj {
    @Override
    public boolean equals(Object obj) {
        return obj instanceof ArrayObj;
    }
}
