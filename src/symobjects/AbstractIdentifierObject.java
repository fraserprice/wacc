package symobjects;

public abstract class AbstractIdentifierObject {
    protected SymbolTable identifierST;

    public AbstractIdentifierObject(SymbolTable identifierST) {
        this.identifierST = identifierST;
    }
}
