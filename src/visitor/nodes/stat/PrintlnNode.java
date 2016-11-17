package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class PrintlnNode extends StatNode<WACCParser.PrintlnStatContext> {

    public PrintlnNode(SymbolTable currentST, WACCParser.PrintlnStatContext
            ctx, ExprNode exprNode) {
        super(currentST, ctx);

        if (exprNode.hasErrors()) {
            setError();
            return;
        }
    }
}
