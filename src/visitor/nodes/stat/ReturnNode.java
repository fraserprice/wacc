package visitor.nodes.stat;

import antlr.WACCParser;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class ReturnNode extends StatNode<WACCParser.ReturnStatContext> {
    private TypeObj returnType;

    public ReturnNode(SymbolTable currentST, WACCParser.ReturnStatContext
            ctx, ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }

        this.returnType = exprNode.getType();
    }

    public TypeObj getReturnType() {
        return returnType;
    }
}
