package visitor.nodes.util;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.TypeObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.GenericObj;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.Node;
import visitor.nodes.ExprNode;

import java.util.List;

public class AssignRhsNode extends Node<WACCParser.AssignRhsContext> {
    private TypeObj type;

    // assignRhs: expr
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, ExprNode rhs) {
        super(currentST, ctx);

        if(rhs.hasErrors()) {
            setError();
            return;
        }

        this.type = rhs.getType();
    }

    // assignRhs: arrayLiteral
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, List<ExprNode> arrayArgs) {
        super(currentST, ctx);

        for(ExprNode arg : arrayArgs) {
            if(arg.hasErrors()) {
                setError();
                return;
            }
        }

        if (arrayArgs.isEmpty()) {
            this.type = new GenericObj();
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

        if(first.hasErrors() || second.hasErrors()) {
            setError();
            return;
        }

        this.type = new PairObj(first.getType(), second.getType());
    }

    // assignRhs: pairElem
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, PairElemNode pairElem) {
        super(currentST, ctx);

        if(pairElem.hasErrors()) {
            setError();
            return;
        }

        this.type = pairElem.getType();
    }

    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsNode(SymbolTable currentST, WACCParser.AssignRhsContext ctx, List<ExprNode> args, String ident) {
        super(currentST, ctx);

        for (ExprNode exprNode : args) {
            if(exprNode.hasErrors()) {
                setError();
                return;
            }
        }

        FunctionObj func = currentST.lookupAll(ident, FunctionObj.class);

        if (func == null) {
            addSemanticError(CompileTimeError.FUNCTION_NOT_DEFINED, ident);
            return;
        }

        type = func.getReturnType();

        if (func.getParams().size() != args.size()) {
            addSemanticError(CompileTimeError.WRONG_NUMBER_OF_PARAMS, "" + func.getParams().size(), "" + args.size());
            return;
        }

        for (int i = 0; i < func.getParams().size(); i++) {
            TypeObj param = func.getParams().get(i).getType();
            TypeObj argument = args.get(i).getType();

            if (param == null || argument == null) {
                setError();
                return;
            }

            if (!param.equals(argument)) {
                addSemanticError(CompileTimeError.PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE, "" + i,
                        ident, param.toString(), argument.toString());
            }
        }
    }

    public TypeObj getType() {
        return type;
    }
}
