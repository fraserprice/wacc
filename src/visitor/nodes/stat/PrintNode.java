package visitor.nodes.stat;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.StatNode;

import java.util.List;

public class PrintNode extends StatNode<WACCParser.PrintStatContext> {

    private ExprNode exprNode;

    public PrintNode(SymbolTable currentST, WACCParser.PrintStatContext ctx,
                     ExprNode exprNode) {
        super(currentST, ctx);

        this.exprNode = exprNode;

        if (exprNode.hasErrors()) {
            setError();
            return;
        }
    }

}
