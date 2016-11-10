package visitor.nodes.util;

import antlr.WACCParser;
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

public class AssignRhsNode extends Node<WACCParser.AssignRhsContext> {
    private TypeObj type;

    // assignRhs: expr
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, ExprNode rhs) {
        super(currentST, ctx);
        if (rhs.getType() == null) {
            return;
        }
        this.type = rhs.getType();
    }

    // assignRhs: arrayLiteral
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, List<ExprNode> arrayArgs) {
        super(currentST, ctx);

        if (arrayArgs.isEmpty()) {
            this.type = new ArrayObj();
            return;
        }

        int noSameTypeAsFirst = (int) arrayArgs.stream().filter(expr -> expr.getType().equals(arrayArgs.get(0).getType())).count();
        if (noSameTypeAsFirst != arrayArgs.size()) {
            addSemanticError(CompileTimeError.ARRAY_LITERAL_TYPE_DONT_MATCH);
            return;
        }

        this.type = new ArrayObj(arrayArgs.get(0).getType(), arrayArgs.size());
    }

    // assignRhs: NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, ExprNode first, ExprNode second) {
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
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, PairElemNode pairElem) {
        super(currentST, ctx);
        if (pairElem.getType() == null) {
            return;
        }
        this.type = pairElem.getType();
    }

    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, List<ExprNode> args, String ident) {
        super(currentST, ctx);

        FunctionObj obj = currentST.lookupAll(ident, FunctionObj.class);

        if (obj == null) {
            addSemanticError(CompileTimeError.FUNCTION_NOT_DEFINED, ident);
            return;
        }

        if (!(obj instanceof FunctionObj)) {
            addSemanticError(CompileTimeError.NOT_A_FUNCTION, ident);
            return;
        }

        FunctionObj funcObj = (FunctionObj) obj;

        this.type = funcObj.getReturnType();

        if (args.size() != funcObj.getParams().size()) {
            addSemanticError(CompileTimeError.WRONG_NUMBER_OF_PARAMS, "" + funcObj.getParams().size(), "" + args.size());
            return;
        }

        for (int i = 0; i < args.size(); i++) {
            if (!args.get(i).getType().equals(funcObj.getParams().get(i).getType())) {
                addSemanticError(CompileTimeError.PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE, "" + i,
                    ident, funcObj.getParams().get(i).getType().toString(), args.get(i).getType().toString());
            }
        }
    }

    public TypeObj getType() {
        return type;
    }
}
