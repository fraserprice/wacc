package symobjects.identifierobj;

import symobjects.IdentifierObj;
import symobjects.SymbolTable;

import java.util.List;

public class FunctionObj extends IdentifierObj {
    private TypeObj returnType;
    private List<ParamObj> params;

    public FunctionObj(SymbolTable identifierST, TypeObj returnType, List<ParamObj> params) {
        super(identifierST);
        this.returnType = returnType;
        this.params = params;
    }

    public TypeObj getReturnType() {
        return returnType;
    }

    public void setReturnType(TypeObj returnType) {
        this.returnType = returnType;
    }

    public List<ParamObj> getParams() {
        return params;
    }

    public void setParams(List<ParamObj> params) {
        this.params = params;
    }
}
