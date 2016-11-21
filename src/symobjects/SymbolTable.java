package symobjects;

import symobjects.identifierobj.VariableObj;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, IdentifierObj> map;
    private SymbolTable parent;
    private int offsetLocation = 0;

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
    public <T> T lookup(String key, Class<T> classType) {
        IdentifierObj obj = map.get(key);

        if (classType.isInstance(obj)) {
            return (T) obj;
        }

        return null;
    }

    /**
     * Search in current and outer scopes for the IdentifierObj
     * @param key
     * @return IdentifierObj
     */
    public <T> T lookupAll(String key, Class<T> classType) {
        SymbolTable current = this;
        while(current != null) {
            T obj = current.lookup(key, classType);
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

    public void add(String key, IdentifierObj obj) {
        if (obj instanceof VariableObj) {

        }
        this.map.put(key, obj);
    }
}
