package visitor;

import antlr.WACCParser;
import antlr.WACCParserVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import symobjects.SymbolTable;
import visitor.nodes.ExprNode;
import visitor.nodes.expr.ArrayElementNode;
import visitor.nodes.expr.BinOpNode;
import visitor.nodes.expr.ParenthesisNode;
import visitor.nodes.expr.UnaryOpNode;
import visitor.nodes.expr.literal.*;
import visitor.nodes.expr.operator.BinOp;

import java.util.List;
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
        visitChildren(ctx); return null;
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
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitAssignLhs(@NotNull WACCParser.AssignLhsContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitProgram(@NotNull WACCParser.ProgramContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitType(@NotNull WACCParser.TypeContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitAssignPairArrayStat(@NotNull WACCParser.AssignPairArrayStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitReadStat(@NotNull WACCParser.ReadStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitBaseType(@NotNull WACCParser.BaseTypeContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitPrintlnStat(@NotNull WACCParser.PrintlnStatContext ctx) {
        visitChildren(ctx); return null;
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
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitCompositionStat(@NotNull WACCParser.CompositionStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitPrintStat(@NotNull WACCParser.PrintStatContext ctx) {
        visitChildren(ctx); return null;
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
        visitChildren(ctx); return null;
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
        return new UnaryOpNode(currentST, ctx, new IntNode(currentST, ctx.INT_LITERAL()));
    }

    @Override
    public Node visitArrayExpr(@NotNull WACCParser.ArrayExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitUnExpr(@NotNull WACCParser.UnExprContext ctx) {
        return new UnaryOpNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitParanthesisExpr(@NotNull WACCParser.ParanthesisExprContext ctx) {
        return new ParenthesisNode(currentST, ctx, (ExprNode) visit(ctx.expr()));
    }

    @Override
    public Node visitPairElem(@NotNull WACCParser.PairElemContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitExitStat(@NotNull WACCParser.ExitStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitIfStat(@NotNull WACCParser.IfStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitFreeStat(@NotNull WACCParser.FreeStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitSkipStat(@NotNull WACCParser.SkipStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitWhileStat(@NotNull WACCParser.WhileStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitPairElemType(@NotNull WACCParser.PairElemTypeContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitAssignPrimitiveStat(@NotNull WACCParser.AssignPrimitiveStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitFunc(@NotNull WACCParser.FuncContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitScopeBlockStat(@NotNull WACCParser.ScopeBlockStatContext ctx) {
        visitChildren(ctx); return null;
    }
}
