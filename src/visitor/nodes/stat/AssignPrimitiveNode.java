package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.StatNode;
import visitor.nodes.type.TypeNode;

public class AssignPrimitiveNode extends StatNode {
    private TypeObj type;
    private String ident;
    private AssignRhsNode rhs;

    public AssignPrimitiveNode(SymbolTable currentST, WACCParser.AssignPrimitiveStatContext ctx, TypeNode type, AssignRhsNode assignRhs) {
        super(currentST, ctx);
        this.type = type.getType();
        this.ident = ctx.IDENT().getText();

        if (!assignRhs.hasErrors()) {
            this.rhs = assignRhs;
            check();
        }
    }

    private void check() {
        assert (rhs != null): "AssignPrimitiveNode: rhs can't be null";
        assert (rhs.getType() != null): "AssignPrimitiveNode: rhs should have a type";

        if (IdentifierObj.isValidIdentifierName(ident)) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME);
            return;
        }

        if (!type.equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE);
            return;
        }

        if (currentST.lookup(ident) != null) {
            addSemanticError(CompileTimeError.VARIABLE_ALREADY_DEFINED);
            return;
        }

        currentST.add(ident, new VariableObj(currentST, type));
    }
}
