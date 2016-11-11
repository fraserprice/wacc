package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.GenericObj;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;
import visitor.nodes.type.TypeNode;

public class AssignPrimitiveNode extends StatNode<WACCParser
        .AssignPrimitiveStatContext> {
    private TypeObj type;
    private String ident;
    private AssignRhsNode rhs;

    public AssignPrimitiveNode(SymbolTable currentST, WACCParser
            .AssignPrimitiveStatContext ctx, TypeNode type, AssignRhsNode
            assignRhs) {
        super(currentST, ctx);

        if (type.hasErrors() || assignRhs.hasErrors()) {
            setError();
            return;
        }

        this.type = type.getType();
        this.ident = ctx.IDENT().getText();
        this.rhs = assignRhs;

        check();
    }

    private void check() {

        if (!IdentifierObj.isValidIdentifierName(ident)) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME, ident);
            return;
        }

        if (!type.equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE, ident,
                    type.toString(), "right hand side", rhs.getType()
                            .toString());
            return;
        }

        if (currentST.lookup(ident, VariableObj.class) != null) {
            addSemanticError(CompileTimeError.VARIABLE_ALREADY_DEFINED, ident);
            return;
        }

        // we don't add the array type because it's size is 0
        if (type instanceof ArrayObj && !(rhs.getType() instanceof
                GenericObj)) {
            ((ArrayObj) type).setEmelentsNo(((ArrayObj) rhs.getType())
                    .getElementsNo());
        }
        currentST.add(ident, new VariableObj(currentST, type));
    }
}
