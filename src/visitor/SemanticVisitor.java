package visitor;

import antlr.WACCParser;
import antlr.WACCParserVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import symobjects.SymbolTable;

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
    public Node visitArgList(@NotNull WACCParser.ArgListContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitReturnStat(@NotNull WACCParser.ReturnStatContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitArrayElem(@NotNull WACCParser.ArrayElemContext ctx) {
        visitChildren(ctx); return null;
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
    public Node visitArrayLiteral(@NotNull WACCParser.ArrayLiteralContext ctx) {
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
    public Node visitLiteral(@NotNull WACCParser.LiteralContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitPrintlnStat(@NotNull WACCParser.PrintlnStatContext ctx) {
        visitChildren(ctx); return null;
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
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitBinEqExpr(@NotNull WACCParser.BinEqExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitLiteralExpr(@NotNull WACCParser.LiteralExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitBinOrExpr(@NotNull WACCParser.BinOrExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitBinCompExpr(@NotNull WACCParser.BinCompExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitIdentExpr(@NotNull WACCParser.IdentExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitBinMulDivModExpr(@NotNull WACCParser.BinMulDivModExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitBinPlusMinusExpr(@NotNull WACCParser.BinPlusMinusExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitUnPlusExpr(@NotNull WACCParser.UnPlusExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitArrayExpr(@NotNull WACCParser.ArrayExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitUnExpr(@NotNull WACCParser.UnExprContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitParanthesisExpr(@NotNull WACCParser.ParanthesisExprContext ctx) {
        visitChildren(ctx); return null;
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
    public Node visitPairType(@NotNull WACCParser.PairTypeContext ctx) {
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
    public Node visitParamList(@NotNull WACCParser.ParamListContext ctx) {
        visitChildren(ctx); return null;
    }

    @Override
    public Node visitScopeBlockStat(@NotNull WACCParser.ScopeBlockStatContext ctx) {
        visitChildren(ctx); return null;
    }
}
