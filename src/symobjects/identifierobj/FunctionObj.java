package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

import java.util.List;

public class FunctionObj extends IdentifierObj {
    private TypeObj returnType;
    private SymbolTable currentST;
    private SymbolTable functionScope;
    private List<VariableObj> params;

    public FunctionObj(SymbolTable currentST, SymbolTable functionScope,
                       TypeObj returnType, List<VariableObj> params) {
        this.returnType = returnType;
        this.functionScope = functionScope;
        this.currentST = currentST;
        this.params = params;
    }

    public TypeObj getReturnType() {
        return returnType;
    }

    public SymbolTable getCurrentST() {
        return currentST;
    }

    public List<VariableObj> getParams() {
        return params;
    }

    public SymbolTable getFunctionScope() {
        return functionScope;
    }

    @Override
    public String toString() {
        return returnType + " function";
    }
}
