package visitor.nodes.util;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.IdentifierObj;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;
import visitor.nodes.ExprNode;

import java.util.List;

public class AssignRhsNode extends Node {
    private TypeObj type;

    // assignRhs: expr
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode rhs) {
        super(currentST, ctx);
        if (rhs.getType() == null) {
            return;
        }
        this.type = rhs.getType();
    }

    // assignRhs: arrayLiteral
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> arrayArgs) {
        super(currentST, ctx);

        // TODO: should implement case where is empty
        if (arrayArgs.isEmpty()) {
            assert(false): "TODODODOODODOD";
            return;
        }

        int noSameTypeAsFirst = (int) arrayArgs.stream().filter(expr -> expr.getType().equals(arrayArgs.get(0).getType())).count();
        if (noSameTypeAsFirst != arrayArgs.size()) {
            addSemanticError(CompileTimeError.TYPE_MISMATCH_ERROR);
            return;
        }

        this.type = new ArrayObj(arrayArgs.get(0).getType(), arrayArgs.size());
    }

    // assignRhs: NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode first, ExprNode second) {
        super(currentST, ctx);
        if (first.getType() == null) {
            return;
        }
        if (second.getType() == null) {
            return;
        }

        this.type = new PairObj(first.getType(), second.getType());
    }

    // assignRhs: pairElem
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, PairElemNode pairElem) {
        super(currentST, ctx);
        if (pairElem.getType() == null) {
            return;
        }
        this.type = pairElem.getType();
    }

    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, ParserRuleContext ctx, List<ExprNode> args, String ident) {
        super(currentST, ctx);

        IdentifierObj obj = currentST.lookupAll(ident);

        if (obj == null) {
            addSemanticError(CompileTimeError.FUNCTION_NOT_DEFINED);
            return;
        }

        if (!(obj instanceof FunctionObj)) {
            addSemanticError(CompileTimeError.NOT_A_FUNCTION);
            return;
        }

        FunctionObj funcObj = (FunctionObj) obj;

        this.type = funcObj.getReturnType();

        if (args.size() != funcObj.getParams().size()) {
            addSemanticError(CompileTimeError.WRONG_NUMBER_OF_PARAMS);
            return;
        }

        for (int i = 0; i < args.size(); i++) {
            if (!args.get(i).getType().equals(funcObj.getParams().get(i).getType())) {
                addSemanticError(CompileTimeError.PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE);
            }
        }
    }

    public TypeObj getType() {
        return type;
    }
}
