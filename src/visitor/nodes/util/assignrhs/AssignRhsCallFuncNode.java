package visitor.nodes.util.assignrhs;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.ExprNode;
import visitor.nodes.util.AssignRhsNode;

import java.util.List;

public class AssignRhsCallFuncNode extends AssignRhsNode<WACCParser.AssignRhsCallFuncContext> {
    // CALL_FUNC IDENT OPEN_PARENTHESES argList? CLOSE_PARENTHESES
    public AssignRhsCallFuncNode(SymbolTable currentST, WACCParser.AssignRhsCallFuncContext
            ctx, List<ExprNode> args) {
        super(currentST, ctx);
        String ident = ctx.IDENT().getText();

        for (ExprNode exprNode : args) {
            if (exprNode.hasErrors()) {
                setError();
                return;
            }
        }

        FunctionObj func = currentST.lookupAll(ident, FunctionObj.class);

        if (func == null) {
            addSemanticError(CompileTimeError.FUNCTION_NOT_DEFINED, ident);
            return;
        }

        this.type = func.getReturnType();

        if (func.getParams().size() != args.size()) {
            addSemanticError(CompileTimeError.WRONG_NUMBER_OF_PARAMS, "" +
                    func.getParams().size(), "" + args.size());
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
                addSemanticError(CompileTimeError
                                .PARAMS_TYPE_DONT_MATCH_WITH_SIGNATURE, "" +
                                (i + 1),
                        ident, param.toString(), argument.toString());
            }
        }
    }
}
