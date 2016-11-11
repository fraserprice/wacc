package symobjects.identifierobj.typeobj;
import symobjects.identifierobj.TypeObj;

public class PairObj extends TypeObj {
    private TypeObj type1;
    private TypeObj type2;

    public PairObj() {
        type1 = new GenericObj();
        type2 = new GenericObj();
    }

    public PairObj(TypeObj type1, TypeObj type2) {
        this.type1 = type1;
        this.type2 = type2;
    }

    public TypeObj getType1() {
        return type1;
    }

    public TypeObj getType2() {
        return type2;
    }

    @Override
    public String toString() {
        if (type1 instanceof GenericObj && type2 instanceof GenericObj) {
            return "PAIR";
        } else {
            return "PAIR<" + type1 + ", " + type2 + ">";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GenericObj) {
            return true;
        }

        if (!(obj instanceof PairObj)) {
            return false;
        }

        PairObj pairObj = (PairObj) obj;

        return (type1.equals(pairObj.getType1()) && type2.equals(pairObj.getType2()));
    }
}
