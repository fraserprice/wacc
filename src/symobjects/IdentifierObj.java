package symobjects;

public abstract class IdentifierObj {
    protected SymbolTable identifierST;

    public IdentifierObj(SymbolTable identifierST) {
        this.identifierST = identifierST;
    }
}
