package symobjects.identifierobj.typeobj;

import symobjects.identifierobj.TypeObj;

public class PairObj extends TypeObj {
    private TypeObj type1;
    private TypeObj type2;

    public PairObj() {
    }

    public PairObj(TypeObj type1, TypeObj type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    public boolean hasTypes() {
        return type1 != null;
    }

    public TypeObj getType1() {
        return type1;
    }

    public TypeObj getType2() {
        return type2;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("pair<" + type1 + ", " + type2 + ">");
        return sb.toString();
    }
}
