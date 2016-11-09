package visitor.nodes.stat;

import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;

public class ReadNode extends StatNode{

    public ReadNode(SymbolTable currentST, ParserRuleContext ctx, AssignLhsNode assignLhsNode) {
        super(currentST, ctx);
        checkRead(assignLhsNode);
    }

    private void checkRead(AssignLhsNode assignLhsNode) {
        if(assignLhsNode.getType() instanceof PairObj) {
            addSemanticError(CompileTimeError.READ_ERROR);
        }
    }
}