package symobjects.identifierobj.typeobj;

import symobjects.identifierobj.TypeObj;

public class ArrayObj extends TypeObj {
    private TypeObj type;
    private int elementsNo;

    public ArrayObj() {
        this.elementsNo = 0;
        this.type = new GenericObj();
    }

    public ArrayObj(TypeObj type) {
        this.type = type;
    }

    public ArrayObj(TypeObj type, int elementsNo) {
        this.type = type;
        this.elementsNo = elementsNo;
    }

    public TypeObj getType() {
        return type;
    }

    public int getElementsNo() {
        return elementsNo;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("array: [");
        sb.append(type).append(" ");
        sb.append("], elementsNo=").append(elementsNo);
        return sb.toString();
    }
}
