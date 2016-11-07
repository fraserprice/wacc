package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

public abstract class TypeObj extends IdentifierObj {
    public TypeObj(SymbolTable identifierST) {
        super(identifierST);
    }
}
