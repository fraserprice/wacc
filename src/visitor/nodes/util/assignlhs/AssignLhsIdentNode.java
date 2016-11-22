package visitor.nodes.util.assignlhs;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.VariableObj;
import visitor.nodes.util.AssignLhsNode;

public class AssignLhsIdentNode extends AssignLhsNode<WACCParser.AssignLhsIdentContext> {
    // assignLhs: IDENT
    public AssignLhsIdentNode(SymbolTable currentST, WACCParser.AssignLhsIdentContext
            ctx) {
        super(currentST, ctx);

        VariableObj identObj = currentST.lookupAll(ctx.IDENT().getText(),
                VariableObj.class);

        if (identObj == null) {
            addSemanticError(CompileTimeError
                    .VARIABLE_NOT_DECLARED_IN_THIS_SCOPE, ctx.IDENT()
                    .toString());
            return;
        }

        type = identObj.getType();
    }
}
