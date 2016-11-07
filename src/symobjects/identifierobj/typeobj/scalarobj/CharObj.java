package symobjects.identifierobj.typeobj.scalarobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ScalarObj;

public class CharObj extends ScalarObj {
    public static final int minValue = Character.MIN_VALUE;
    public static final int maxValue = Character.MAX_VALUE;

    public CharObj(SymbolTable identifierST) {
        super(identifierST);
    }
}
