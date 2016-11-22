package symobjects;

import symobjects.identifierobj.VariableObj;

import java.util.*;

public class SymbolTable {
    public static final String LR_SENTINEL = "$LR_SENTINEL";
    private Map<String, IdentifierObj> map;
    private SymbolTable parent;
    private int offsetLocation = 0;
    private List<String> initialised = new LinkedList<>();

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
            VariableObj varObj = (VariableObj) obj;
            varObj.setOffset(0);
            int varObjTypeSize = varObj.getType().getSize();
            map.entrySet().stream()
                    .filter(e -> e.getValue() instanceof VariableObj)
                    .forEach(e -> {
                        VariableObj elementVarObj = (VariableObj) e.getValue();
                        elementVarObj.setOffset(elementVarObj.getOffset() +
                                varObjTypeSize);
                    });
            offsetLocation += varObjTypeSize;
        }
        this.map.put(key, obj);
    }

    public int lookupOffset(String key) {
        if(initialised.contains(key)) {
            VariableObj vObj = lookup(key, VariableObj.class);
            assert (parent != null || vObj != null) : "parent != null || vObj != null";
            if (vObj != null) {
                return vObj.getOffset();
            }
            return offsetLocation + parent.lookupOffset(key);
        } else {
            return offsetLocation + parent.lookupOffset(key);
        }
    }

    private boolean isParam(String ident) {
        int identOffset = ((VariableObj) map.get(ident)).getOffset();
        int sentinelOffset = ((VariableObj) map.get(LR_SENTINEL)).getOffset();
        return identOffset > sentinelOffset;
    }

    public int getOffsetLocation() {
        return offsetLocation;
    }

    public void setInitialised(String key) {
        initialised.add(key);
    }

    public int getReturnOffsetSize() {
        if(map.containsKey(LR_SENTINEL)) {
            int sum = 0;
            for(Map.Entry<String, IdentifierObj> entry : map.entrySet()) {
                if(entry.getValue() instanceof VariableObj && !entry.getKey().equals(LR_SENTINEL)
                    &&!isParam(entry.getKey())) {
                    sum += ((VariableObj) entry.getValue()).getType().getSize();
                }
            }
            return sum;
        } else {
            int sum = 0;
            for(IdentifierObj obj : map.values()) {
                if(obj instanceof VariableObj) {
                    sum += ((VariableObj) obj).getType().getSize();
                }
            }
            return parent.getReturnOffsetSize() + sum;
        }
    }
}
