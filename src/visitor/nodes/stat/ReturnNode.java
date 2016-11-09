package visitor.nodes.stat;

import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.TypeObj;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

public class ReturnNode extends StatNode {
    private TypeObj returnType;

    public ReturnNode(SymbolTable currentST, ParserRuleContext ctx, ExprNode exprNode) {
        super(currentST, ctx);
        this.returnType = exprNode.getType();
    }

    public TypeObj getReturnType() {
        return returnType;
    }
}
