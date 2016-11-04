package symobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mihai on 04/11/2016.
 */
public class SymbolTable {
    private Map<String, AbstractIdentifierObject> map;
    private List<SymbolTable> children;
    private SymbolTable parent;

    public SymbolTable() {
        this.parent = null;
        this.map = new HashMap<>();
        this.children = new ArrayList<>();
    }

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
        this.map = new HashMap<>();
        this.children = new ArrayList<>();
    }

    public void add(SymbolTable st) {
        // TODO
    }

    public AbstractIdentifierObject lookup(String key) {
        // TODO
        return null;
    }

    public AbstractIdentifierObject lookupAll(String key) {
        // TODO
        return null;
    }
}
