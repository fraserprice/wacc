// Generated from ./WACCParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WACCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WACCParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WACCParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(@NotNull WACCParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(@NotNull WACCParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#arrayElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElem(@NotNull WACCParser.ArrayElemContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#assignRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignRhs(@NotNull WACCParser.AssignRhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#assignLhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignLhs(@NotNull WACCParser.AssignLhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(@NotNull WACCParser.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull WACCParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinAndExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinAndExpr(@NotNull WACCParser.BinAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull WACCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignPairArrayStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignPairArrayStat(@NotNull WACCParser.AssignPairArrayStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinEqExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinEqExpr(@NotNull WACCParser.BinEqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadStat(@NotNull WACCParser.ReadStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(@NotNull WACCParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull WACCParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintlnStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintlnStat(@NotNull WACCParser.PrintlnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(@NotNull WACCParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompositionStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositionStat(@NotNull WACCParser.CompositionStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(@NotNull WACCParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(@NotNull WACCParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinOrExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinOrExpr(@NotNull WACCParser.BinOrExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElem(@NotNull WACCParser.PairElemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinCompExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinCompExpr(@NotNull WACCParser.BinCompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExitStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitStat(@NotNull WACCParser.ExitStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentExpr(@NotNull WACCParser.IdentExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinMulDivModExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinMulDivModExpr(@NotNull WACCParser.BinMulDivModExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull WACCParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FreeStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFreeStat(@NotNull WACCParser.FreeStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SkipStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStat(@NotNull WACCParser.SkipStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull WACCParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinPlusMinusExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinPlusMinusExpr(@NotNull WACCParser.BinPlusMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnPlusExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnPlusExpr(@NotNull WACCParser.UnPlusExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairType(@NotNull WACCParser.PairTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#pairElemType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairElemType(@NotNull WACCParser.PairElemTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignPrimitiveStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignPrimitiveStat(@NotNull WACCParser.AssignPrimitiveStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(@NotNull WACCParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(@NotNull WACCParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnExpr(@NotNull WACCParser.UnExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WACCParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(@NotNull WACCParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ScopeBlockStat}
	 * labeled alternative in {@link WACCParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopeBlockStat(@NotNull WACCParser.ScopeBlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParanthesesExpr}
	 * labeled alternative in {@link WACCParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanthesesExpr(@NotNull WACCParser.ParanthesesExprContext ctx);
}