package visitor;

import antlr.WACCParser;
import antlr.WACCParserVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.FunctionNode;
import visitor.nodes.ProgramNode;
import visitor.nodes.StatNode;
import visitor.nodes.expr.ArrayElementNode;
import visitor.nodes.expr.BinOpNode;
import visitor.nodes.expr.ParenthesisNode;
import visitor.nodes.expr.UnaryOpNode;
import visitor.nodes.expr.literal.*;
import visitor.nodes.stat.*;
import visitor.nodes.type.BaseTypeNode;
import visitor.nodes.type.PairElemTypeNode;
import visitor.nodes.type.TypeNode;
import visitor.nodes.util.AssignLhsNode;
import visitor.nodes.util.AssignRhsNode;
import visitor.nodes.util.PairElemNode;
import visitor.nodes.util.ParamNode;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SemanticVisitor extends AbstractParseTreeVisitor<Node> implements WACCParserVisitor<Node> {
    /**
     * Holds reference to current scope
     */
    private SymbolTable currentST;

    /**
     * Create a new SymbolTable for the current ST
     * and updates the currentST field
     */
    private void createChildST() {
        SymbolTable newST = new SymbolTable(currentST);
        currentST = newST;
    }

    /**
     * Updates the currentST field to it's parent
     */
    private void closeCurrentScope() {
        currentST = currentST.getParent();
    }

    @Override
    public Node visitReturnStat(@NotNull WACCParser.ReturnStatContext ctx) {
        return new ReturnNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitArrayElem(@NotNull WACCParser.ArrayElemContext ctx) {
        List<ExprNode> exprList = ctx.expr().stream()
                .map(prc -> (ExprNode) visit(prc))
                .collect(Collectors.toList());
        return new ArrayElementNode(currentST, ctx, exprList);
    }

    @Override
    public Node visitAssignRhs(@NotNull WACCParser.AssignRhsContext ctx) {
        if (ctx.OPEN_SQUARE_BRACKET() != null) {
            List<ExprNode> exprNodes = ctx.expr().stream()
                                        .map(e -> (ExprNode) visit(e))
                                        .collect(Collectors.toList());
            return new AssignRhsNode(currentST, ctx, exprNodes);
        } else if (ctx.NEWPAIR() != null) {
            return new AssignRhsNode(currentST, ctx, (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)));
        } else if (ctx.pairElem() != null) {
            return new AssignRhsNode(currentST, ctx, (PairElemNode) visit(ctx.pairElem()));
        } else if (ctx.CALL_FUNC() != null) {
            List<ExprNode> args = ctx.expr().stream()
                    .map(e -> (ExprNode) visit(e))
                    .collect(Collectors.toList());
            return new AssignRhsNode(currentST, ctx, args, ctx.IDENT().getText());
        } else {
            return new AssignRhsNode(currentST, ctx, (ExprNode) visit(ctx.expr(0)));
        }
    }

    @Override
    public Node visitAssignLhs(@NotNull WACCParser.AssignLhsContext ctx) {
        if (ctx.IDENT() != null) {
            return new AssignLhsNode(currentST, ctx);
        } else if (ctx.arrayElem() != null) {
            return new AssignLhsNode(currentST, ctx, (ArrayElementNode) visit(ctx.arrayElem()));
        } else {
            return new AssignLhsNode(currentST, ctx, (PairElemNode) visit(ctx.pairElem()));
        }
    }

    @Override
    public Node visitProgram(@NotNull WACCParser.ProgramContext ctx) {
        createChildST();
        List<FunctionNode> functionNodes = ctx.func().stream()
                                            .map(f -> (FunctionNode) visit(f))
                                            .collect(Collectors.toList());
        return new ProgramNode(currentST, ctx, functionNodes, (StatNode) visit(ctx.stat()));
    }

    @Override
    public Node visitType(@NotNull WACCParser.TypeContext ctx) {
        if (ctx.OPEN_PARENTHESES() != null) {
            // round PARENTHESES
            return new TypeNode(currentST, ctx, (PairElemTypeNode) visit(ctx.pairElemType(0)),
                                        (PairElemTypeNode) visit(ctx.pairElemType(1)));
        } else if (ctx.OPEN_SQUARE_BRACKET() != null) {
            // square PARENTHESES
            return new TypeNode(currentST, ctx, (TypeNode) visit(ctx.type()));
        } else {
            // baseType
            return new TypeNode(currentST, ctx, (BaseTypeNode) visit(ctx.baseType()));
        }
    }

    @Override
    public Node visitAssignPairArrayStat(@NotNull WACCParser.AssignPairArrayStatContext ctx) {
        return new AssignPairArrayNode(currentST, ctx, (AssignLhsNode) visit(ctx.assignLhs()), (AssignRhsNode) visit(ctx.assignRhs()));
    }

    @Override
    public Node visitReadStat(@NotNull WACCParser.ReadStatContext ctx) {
        return new ReadNode(currentST, ctx, (AssignLhsNode) visit(ctx.assignLhs()));
    }

    @Override
    public Node visitBaseType(@NotNull WACCParser.BaseTypeContext ctx) {
        return new BaseTypeNode(currentST, ctx);
    }

    @Override
    public Node visitPrintlnStat(@NotNull WACCParser.PrintlnStatContext ctx) {
        return new PrintlnNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    // WILL RETURN NULL IF CALLED
    @Override
    public Node visitIdentExpr(@NotNull WACCParser.IdentExprContext ctx) {
        return null;
    }

    @Override
    public Node visitBoolLiteral(@NotNull WACCParser.BoolLiteralContext ctx) {
        return new BoolNode(currentST, ctx);
    }

    @Override
    public Node visitIntLiteral(@NotNull WACCParser.IntLiteralContext ctx) {
        return new IntNode(currentST, ctx);
    }

    @Override
    public Node visitCharLiteral(@NotNull WACCParser.CharLiteralContext ctx) {
        return new CharNode(currentST, ctx);
    }

    @Override
    public Node visitStrLiteral(@NotNull WACCParser.StrLiteralContext ctx) {
        return new StringNode(currentST, ctx);
    }

    @Override
    public Node visitPairLiteral(@NotNull WACCParser.PairLiteralContext ctx) {
        return new PairNode(currentST, ctx);
    }

    @Override
    public Node visitParam(@NotNull WACCParser.ParamContext ctx) {
        return new ParamNode(currentST, ctx, (TypeNode) visit(ctx.type()));
    }

    @Override
    public Node visitCompositionStat(@NotNull WACCParser.CompositionStatContext ctx) {
        return new CompositionNode(currentST, ctx, (StatNode) visit(ctx.stat(0)), (StatNode) visit(ctx.stat(1)));
    }

    @Override
    public Node visitPrintStat(@NotNull WACCParser.PrintStatContext ctx) {
        return new PrintNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitBinAndExpr(@NotNull WACCParser.BinAndExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));
        return new BinOpNode(currentST, ctx, lhs, rhs);
    }

    @Override
    public Node visitBinEqExpr(@NotNull WACCParser.BinEqExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, rhs);
    }

    @Override
    public Node visitLiteralExpr(@NotNull WACCParser.LiteralExprContext ctx) {
        return visit(ctx.literal());
    }

    @Override
    public Node visitBinOrExpr(@NotNull WACCParser.BinOrExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, rhs);
    }

    @Override
    public Node visitBinCompExpr(@NotNull WACCParser.BinCompExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, rhs);
    }

    @Override
    public Node visitBinMulDivModExpr(@NotNull WACCParser.BinMulDivModExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, rhs);
    }

    @Override
    public Node visitBinPlusMinusExpr(@NotNull WACCParser.BinPlusMinusExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expr(0));
        ExprNode rhs = (ExprNode) visit(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, rhs);
    }

    @Override
    public Node visitUnPlusExpr(@NotNull WACCParser.UnPlusExprContext ctx) {
        return new UnaryOpNode(currentST, ctx, new IntNode(currentST, ctx.INT_LITERAL().getText()));
    }

    @Override
    public Node visitArrayExpr(@NotNull WACCParser.ArrayExprContext ctx) {
        return visit(ctx.arrayElem());
    }

    @Override
    public Node visitUnExpr(@NotNull WACCParser.UnExprContext ctx) {
        // special case
        if (ctx.MINUS() != null) {
            // might have negative integer
            Pattern p = Pattern.compile("[0-9]+");
            if (p.matcher(ctx.expr().getText()).matches()) {
                // we have int literal
                return new UnaryOpNode(currentST, ctx, new IntNode(currentST, "-" + ctx.expr().getText()));
            }
        }

        return new UnaryOpNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitParanthesisExpr(@NotNull WACCParser.ParanthesisExprContext ctx) {
        return new ParenthesisNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitPairElem(@NotNull WACCParser.PairElemContext ctx) {
        return new PairElemNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitExitStat(@NotNull WACCParser.ExitStatContext ctx) {
        return new ExitNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitIfStat(@NotNull WACCParser.IfStatContext ctx) {
        ExprNode exprBlock = (ExprNode) visit(ctx.expr());

        createChildST();
        StatNode thenBlock = (StatNode) visit(ctx.stat(0));
        closeCurrentScope();

        createChildST();
        StatNode elseBlock = (StatNode) visit(ctx.stat(1));
        closeCurrentScope();

        IfNode ifBlock = new IfNode(currentST, ctx, exprBlock, thenBlock, elseBlock);
        return ifBlock;
    }

    @Override
    public Node visitFreeStat(@NotNull WACCParser.FreeStatContext ctx) {
        return new FreeNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitSkipStat(@NotNull WACCParser.SkipStatContext ctx) {
        return new SkipNode(currentST, ctx);
    }

    @Override
    public Node visitWhileStat(@NotNull WACCParser.WhileStatContext ctx) {
        createChildST();
        WhileNode whileBlock = new WhileNode(currentST, ctx, (ExprNode) visit(ctx.expr()), (StatNode) visit(ctx.stat()));
        closeCurrentScope();
        return whileBlock;
    }

    @Override
    public Node visitPairElemType(@NotNull WACCParser.PairElemTypeContext ctx) {
        if (ctx.baseType() != null) {
            return new PairElemTypeNode(currentST, ctx, (BaseTypeNode) visit(ctx.baseType()));
        } else if (ctx.OPEN_SQUARE_BRACKET() != null) {
            return new PairElemTypeNode(currentST, ctx, (TypeNode) visit(ctx.type()));
        } else {
            return new PairElemTypeNode(currentST, ctx);
        }
    }

    @Override
    public AssignPrimitiveNode visitAssignPrimitiveStat(@NotNull WACCParser.AssignPrimitiveStatContext ctx) {
        return new AssignPrimitiveNode(currentST, ctx, (TypeNode) visit(ctx.type()), (AssignRhsNode) visit(ctx.assignRhs()));
    }

    @Override
    public Node visitFunc(@NotNull WACCParser.FuncContext ctx) {
        createChildST();
        TypeNode returnType = (TypeNode) visit(ctx.type());
        List<ParamNode> params = ctx.param().stream()
                                .map(p -> (ParamNode) visit(p))
                                .collect(Collectors.toList());
        StatNode statBlock = (StatNode) visit(ctx.stat());
        closeCurrentScope();
        return new FunctionNode(currentST, ctx, returnType, params, statBlock);
    }

    @Override
    public Node visitScopeBlockStat(@NotNull WACCParser.ScopeBlockStatContext ctx) {
        createChildST();
        ScopeBlockNode block = new ScopeBlockNode(currentST, ctx, (StatNode) visit(ctx.stat()));
        closeCurrentScope();
        return block;
    }
}
