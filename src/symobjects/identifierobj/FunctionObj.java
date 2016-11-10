package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

import java.util.List;

public class FunctionObj extends IdentifierObj {
    private TypeObj returnType;
    private SymbolTable currentST;
    private List<VariableObj> params;

    public FunctionObj(SymbolTable currentST, TypeObj returnType, List<VariableObj> params) {
        this.returnType = returnType;
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
}
