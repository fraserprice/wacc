package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.GenericObj;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

import java.util.List;

public class AssignRhsArrayLiteralNode extends AssignRhsNode<WACCParser.AssignRhsArrayLiteralContext> {
    // assignRhs: arrayLiteral
    public AssignRhsArrayLiteralNode(SymbolTable currentST, WACCParser.AssignRhsArrayLiteralContext
            ctx, List<ExprNode> arrayArgs) {
        super(currentST, ctx);

        for (ExprNode arg : arrayArgs) {
            if (arg.hasErrors()) {
                setError();
                return;
            }
        }

        if (arrayArgs.isEmpty()) {
            this.type = new GenericObj();
            return;
        }

        int noSameTypeAsFirst = (int) arrayArgs.stream().filter(expr -> expr
                .getType().equals(arrayArgs.get(0).getType())).count();
        if (noSameTypeAsFirst != arrayArgs.size()) {
            addSemanticError(CompileTimeError.ARRAY_LITERAL_TYPE_DONT_MATCH);
            return;
        }

        this.type = new ArrayObj(arrayArgs.get(0).getType(), arrayArgs.size());
    }
}
