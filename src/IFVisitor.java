import antlr.WACCParser;
import antlr.WACCParserVisitor;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.*;

/**
 * Created by Toma Alexandru on 04/11/2016.
 */
public class IFVisitor extends AbstractParseTreeVisitor<Integer> implements WACCParserVisitor<Integer> {
    @Override
    public Integer visitArgList(@NotNull WACCParser.ArgListContext ctx) {
        System.out.println("prog1");return 0;
    }

    @Override
    public Integer visitReturnStat(@NotNull WACCParser.ReturnStatContext ctx) {
        System.out.println("prog2");return 0;
    }

    @Override
    public Integer visitArrayElem(@NotNull WACCParser.ArrayElemContext ctx) {
        System.out.println("prog3");return 0;
    }

    @Override
    public Integer visitAssignRhs(@NotNull WACCParser.AssignRhsContext ctx) {
        System.out.println("prog4");return 0;
    }

    @Override
    public Integer visitAssignLhs(@NotNull WACCParser.AssignLhsContext ctx) {
        System.out.println("prog5");return 0;
    }

    @Override
    public Integer visitArrayLiteral(@NotNull WACCParser.ArrayLiteralContext ctx) {
        System.out.println("prog6");return 0;
    }

    @Override
    public Integer visitProgram(@NotNull WACCParser.ProgramContext ctx) {
        System.out.println(ctx.getClass());
        System.out.println("prog7");return 0;
    }

    @Override
    public Integer visitType(@NotNull WACCParser.TypeContext ctx) {
        System.out.println("prog8");return 0;
    }

    @Override
    public Integer visitAssignPairArrayStat(@NotNull WACCParser.AssignPairArrayStatContext ctx) {
        System.out.println("prog9");return 0;
    }

    @Override
    public Integer visitReadStat(@NotNull WACCParser.ReadStatContext ctx) {
        System.out.println("prog10");return 0;
    }

    @Override
    public Integer visitBaseType(@NotNull WACCParser.BaseTypeContext ctx) {
        System.out.println("prog11");return 0;
    }

    @Override
    public Integer visitLiteral(@NotNull WACCParser.LiteralContext ctx) {
        System.out.println("prog12");return 0;
    }

    @Override
    public Integer visitPrintlnStat(@NotNull WACCParser.PrintlnStatContext ctx) {
        System.out.println("prog13");return 0;
    }

    @Override
    public Integer visitParam(@NotNull WACCParser.ParamContext ctx) {
        System.out.println("prog14");return 0;
    }

    @Override
    public Integer visitCompositionStat(@NotNull WACCParser.CompositionStatContext ctx) {
        System.out.println("prog15");return 0;
    }

    @Override
    public Integer visitPrintStat(@NotNull WACCParser.PrintStatContext ctx) {
        System.out.println("prog16");return 0;
    }

    @Override
    public Integer visitExpr(@NotNull WACCParser.ExprContext ctx) {
        System.out.println("prog17");return 0;
    }

    @Override
    public Integer visitPairElem(@NotNull WACCParser.PairElemContext ctx) {
        System.out.println("prog18");return 0;
    }

    @Override
    public Integer visitExitStat(@NotNull WACCParser.ExitStatContext ctx) {
        System.out.println("prog19");return 0;
    }

    @Override
    public Integer visitIfStat(@NotNull WACCParser.IfStatContext ctx) {
        System.out.println("prog20");return 0;
    }

    @Override
    public Integer visitFreeStat(@NotNull WACCParser.FreeStatContext ctx) {
        System.out.println("prog21");return 0;
    }

    @Override
    public Integer visitSkipStat(@NotNull WACCParser.SkipStatContext ctx) {
        System.out.println("prog22");return 0;
    }

    @Override
    public Integer visitWhileStat(@NotNull WACCParser.WhileStatContext ctx) {
        System.out.println("prog23");return 0;
    }

    @Override
    public Integer visitPairType(@NotNull WACCParser.PairTypeContext ctx) {
        System.out.println("prog24");return 0;
    }

    @Override
    public Integer visitPairElemType(@NotNull WACCParser.PairElemTypeContext ctx) {
        System.out.println("prog25");return 0;
    }

    @Override
    public Integer visitAssignPrimitiveStat(@NotNull WACCParser.AssignPrimitiveStatContext ctx) {
        System.out.println("prog26");return 0;
    }

    @Override
    public Integer visitFunc(@NotNull WACCParser.FuncContext ctx) {
        System.out.println("prog27");return 0;
    }

    @Override
    public Integer visitParamList(@NotNull WACCParser.ParamListContext ctx) {
        System.out.println("prog28");return 0;
    }

    @Override
    public Integer visitScopeBlockStat(@NotNull WACCParser.ScopeBlockStatContext ctx) {
        System.out.println("prog29");return 0;
    }

    @Override
    public Integer visitChildren(@NotNull RuleNode ruleNode) {
        System.out.println("prog30");return 0;
    }

    @Override
    public Integer visitTerminal(@NotNull TerminalNode terminalNode) {
        System.out.println("prog31");return 0;
    }

    @Override
    public Integer visitErrorNode(@NotNull ErrorNode errorNode) {
        System.out.println("prog32");return 0;
    }
}
