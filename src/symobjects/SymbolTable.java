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
        return map.get(key);
    }

    /**
     * Search in current and outer scopes for the AbstractIdentifierObject
     * @param key
     * @return AbstractIdentifierObject
     */
    public AbstractIdentifierObject lookupAll(String key) {
        SymbolTable current = this;
        while(current != null) {
            AbstractIdentifierObject obj = current.lookup(key);
            if (obj != null) {
                return obj;
            }
            current = current.getParent();
        }
        return null;
    }

    /**
     * Returns the parent SymbolTable
     * @return SymbolTable
     */
    public SymbolTable getParent() {
        return parent;
    }
}
