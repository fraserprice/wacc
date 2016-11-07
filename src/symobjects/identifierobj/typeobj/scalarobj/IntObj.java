package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ScalarObj;

public class IntObj extends ScalarObj {
    public static final int minValue = Integer.MIN_VALUE;
    public static final int maxValue = Integer.MAX_VALUE;

    public IntObj(SymbolTable identifierST) {
        super(identifierST);
    }
}
