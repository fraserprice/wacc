package visitor.nodes.stat;

import org.antlr.v4.runtime.tree.TerminalNode;
import symobjects.SymbolTable;
import visitor.nodes.StatNode;
import visitor.nodes.expr.ArrayElementNode;

/**
 * Created by Toma Alexandru on 05/11/2016.
 */
public class AssignPairArrayNode extends StatNode {
    public AssignPairArrayNode(SymbolTable currentST, TerminalNode ident) {
        super(currentST);
    }

    public AssignPairArrayNode(SymbolTable currentST, ArrayElementNode arrayElem) {
        super(currentST);
    }

    public AssignPairArrayNode(SymbolTable currentST, TerminalNode ident) {
        super(currentST);
    }
}
