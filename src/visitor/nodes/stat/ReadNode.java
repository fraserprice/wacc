package visitor.nodes.stat;

import antlr.WACCParser;
import main.CompileTimeError;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import symobjects.identifierobj.typeobj.PairObj;
import symobjects.identifierobj.typeobj.scalarobj.PairLitObj;
import visitor.nodes.StatNode;
import visitor.nodes.util.AssignLhsNode;

public class ReadNode extends StatNode<WACCParser.ReadStatContext> {

    public ReadNode(SymbolTable currentST, WACCParser.ReadStatContext ctx, AssignLhsNode assignLhsNode) {
        super(currentST, ctx);
        if (!assignLhsNode.hasErrors()) {
            checkRead(assignLhsNode);
        }
    }

    private void checkRead(AssignLhsNode assignLhsNode) {
        assert (assignLhsNode != null): "ReadNode: assignLhsNode should not be null";
        assert (assignLhsNode.getType() != null): "ReadNode: assignLhsNode should have a type";
        if(assignLhsNode.getType() instanceof PairObj) {
            addSemanticError(CompileTimeError.READ_ERROR);
        }
    }
}