package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

public abstract class TypeObj extends IdentifierObj {
    public TypeObj(SymbolTable identifierST) {
        super(identifierST);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TypeObj)) {
            return false;
        }

        TypeObj other = (TypeObj) obj;

        return this.getClass().equals(other.getClass());
    }
}
