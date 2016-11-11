package symobjects.identifierobj.typeobj;


public class NullPairObj extends PairObj {
    @Override
    public String toString() {
        return "null";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PairObj;
    }
}
