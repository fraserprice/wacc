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

    public void setElementsNo(int no) {
        this.elementsNo = no;
    }

    public TypeObj getTypeOfDim(int number) {
        TypeObj current = this;

        while (current instanceof ArrayObj) {
            current = ((ArrayObj) current).getType();
            number--;
            if (number == 0) {
                break;
            }
        }

        if (number == 0) {
            return current;
        }

        return null;
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public String toString() {
        TypeObj current = this;

        String brackets = "";

        do {
            brackets += "[" + ((ArrayObj) current).elementsNo + "]";
            current = ((ArrayObj) current).getType();
        } while(current instanceof ArrayObj);

        return current.toString() + brackets;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GenericObj) {
            return true;
        }

        if (!(obj instanceof ArrayObj)) {
            return false;
        }

        ArrayObj other = (ArrayObj) obj;

        return type.equals(other.getType());
    }
}
