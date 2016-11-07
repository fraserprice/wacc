package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ScalarObj;

public class BoolObj extends ScalarObj {
    public static final boolean minValue = false;
    public static final boolean maxValue = true;

    public BoolObj(SymbolTable identifierST) {
        super(identifierST);
    }
}
