package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.Instruction;
import codegen.operands.Register;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class ParenthesisNode extends ExprNode<WACCParser
        .ParanthesisExprContext> {

    public ParenthesisNode(SymbolTable currentST, WACCParser
            .ParanthesisExprContext ctx, ExprNode argument) {
        super(currentST, ctx);

        if (argument.hasErrors()) {
            setError();
        }

        this.type = argument.getType();

    }
}
