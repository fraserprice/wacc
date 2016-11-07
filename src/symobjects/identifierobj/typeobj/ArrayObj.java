package symobjects.identifierobj.typeobj;

import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;

public class ArrayObj extends TypeObj {
    private TypeObj type;
    private int elementsNo;

    public ArrayObj(SymbolTable identifierST, TypeObj type, int elementsNo) {

        super(identifierST);
        this.type = type;
        this.elementsNo = elementsNo;
    }

    public TypeObj getType() {
        return type;
    }

    public void setType(TypeObj type) {
        this.type = type;
    }

    public int getElementsNo() {
        return elementsNo;
    }

    public void setElementsNo(int elementsNo) {
        this.elementsNo = elementsNo;
    }
}
