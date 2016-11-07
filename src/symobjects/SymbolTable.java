package symobjects;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, IdentifierObj> map;
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
     * Search in the current scope for the IdentifierObj
     * @param key
     * @return IdentifierObj
     */
    public IdentifierObj lookup(String key) {
        return map.get(key);
    }

    /**
     * Search in current and outer scopes for the IdentifierObj
     * @param key
     * @return IdentifierObj
     */
    public IdentifierObj lookupAll(String key) {
        SymbolTable current = this;
        while(current != null) {
            IdentifierObj obj = current.lookup(key);
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
