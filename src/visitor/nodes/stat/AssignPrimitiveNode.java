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

public class AssignPrimitiveNode extends StatNode<WACCParser.AssignPrimitiveStatContext> {
    private TypeObj type;
    private String ident;
    private AssignRhsNode rhs;

    public AssignPrimitiveNode(SymbolTable currentST, WACCParser.AssignPrimitiveStatContext ctx, TypeNode type, AssignRhsNode assignRhs) {
        super(currentST, ctx);
        this.type = type.getType();
        this.ident = ctx.IDENT().getText();
        this.rhs = assignRhs;
        check();
    }

    private void check() {
        if (rhs == null) {
            return;
        }
        if (rhs.getType() == null) {
            return;
        }

        if (!IdentifierObj.isValidIdentifierName(ident)) {
            addSemanticError(CompileTimeError.INVALID_VARIABLE_NAME, ident);
            return;
        }

        if (!type.equals(rhs.getType())) {
            addSemanticError(CompileTimeError.INCOMPATIBLE_TYPE, ident,
                type.toString(), "Right hand side: ", rhs.getType().toString());
            return;
        }

        if (currentST.lookup(ident, VariableObj.class) != null) {
            addSemanticError(CompileTimeError.VARIABLE_ALREADY_DEFINED, ident);
            return;
        }

        // we don't add the type because it's size is 0
        currentST.add(ident, new VariableObj(currentST, rhs.getType()));
    }
}
