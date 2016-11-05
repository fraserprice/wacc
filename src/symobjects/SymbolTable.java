package symobjects;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, AbstractIdentifierObject> map;
    private SymbolTable parent;

    public SymbolTable() {
        this.parent = null;
        this.map = new HashMap<>();
    }

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
        this.map = new HashMap<>();
    }

    /**
     * Search in the current scope for the AbstractIdentifierObject
     * @param key
     * @return AbstractIdentifierObject
     */
    public AbstractIdentifierObject lookup(String key) {
        // TODO
        return null;
    }

    /**
     * Search in current and outer scopes for the AbstractIdentifierObject
     * @param key
     * @return AbstractIdentifierObject
     */
    public AbstractIdentifierObject lookupAll(String key) {
        // TODO
        return null;
    }
}
