package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;

public class ReadNode extends StatNode<WACCParser.ReadStatContext> {

    public ReadNode(SymbolTable currentST, WACCParser.ReadStatContext ctx, AssignLhsNode assignLhsNode) {
        super(currentST, ctx);
        checkRead(assignLhsNode);
    }

    private void checkRead(AssignLhsNode assignLhsNode) {
        if  (assignLhsNode == null) {
            return;
        }
        if (assignLhsNode.getType() != null) {
            return;
        }
        if(assignLhsNode.getType() instanceof PairObj) {
            addSemanticError(CompileTimeError.READ_ERROR);
        }
    }
}