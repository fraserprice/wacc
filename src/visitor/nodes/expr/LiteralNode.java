package visitor.nodes.expr;

import antlr.WACCParser;
import codegen.CodeGenerator;
import codegen.Instruction;
import codegen.operands.Register;
import org.antlr.v4.runtime.ParserRuleContext;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;

import java.util.List;

public abstract class LiteralNode<T extends WACCParser.LiteralContext>
        extends ExprNode<T> {

    protected String value;

    public LiteralNode(SymbolTable currentST, T ctx) {
        super(currentST, ctx);
    }

}
