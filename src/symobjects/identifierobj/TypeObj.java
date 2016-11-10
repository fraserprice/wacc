package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.identifierobj.typeobj.GenericObj;

public abstract class TypeObj extends IdentifierObj {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TypeObj)) {
            return false;
        }

        TypeObj other = (TypeObj) obj;

        if (this instanceof GenericObj) {
            return true;
        }

        if (other instanceof GenericObj) {
            return true;
        }

        return this.getClass().equals(other.getClass());
    }
}
