package visitor;

import antlr.WACCParser;
import antlr.WACCParserVisitor;
import main.CompileTimeError;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import symobjects.SymbolTable;
import symobjects.identifierobj.FunctionObj;
import symobjects.identifierobj.VariableObj;
import symobjects.identifierobj.typeobj.ArrayObj;
import symobjects.identifierobj.typeobj.NullPairObj;
import symobjects.identifierobj.typeobj.scalarobj.*;
import visitor.nodes.ExprNode;
import visitor.nodes.FunctionNode;
import visitor.nodes.ProgramNode;
import visitor.nodes.StatNode;
import visitor.nodes.expr.*;
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

public class SemanticVisitor extends AbstractParseTreeVisitor<Node>
        implements WACCParserVisitor<Node> {
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

    private ExprNode visitExprNodes(@NotNull WACCParser.ExprContext ctx) {
        return (ExprNode) visit(ctx);
    }

    private StatNode visitStatNode(@NotNull WACCParser.StatContext ctx) {
        return (StatNode) visit(ctx);
    }

    private void parseFunctions(@NotNull WACCParser.ProgramContext ctx) {
        currentST.add("int", new IntObj());
        currentST.add("bool", new BoolObj());
        currentST.add("char", new CharObj());
        currentST.add("null", new NullPairObj());
        currentST.add("string", new ArrayObj(new CharObj()));
        for (WACCParser.FuncContext fCtx : ctx.func()) {
            createChildST();
            SymbolTable functionScope = currentST;
            TypeNode returnType = visitType(fCtx.type());
            List<ParamNode> params = fCtx.param().stream()
                    .map(p -> (ParamNode) visit(p))
                    .collect(Collectors.toList());

            List<VariableObj> paramsObj = params.stream().map
                    (ParamNode::getObj).collect(Collectors.toList());
            closeCurrentScope();

            if (currentST.lookupAll(fCtx.IDENT().getText(), FunctionObj
                    .class) != null) {
                CompileTimeError.FUNCTION_ALREADY_DEFINED.printSemantic(fCtx
                                .getStart().getLine(),
                        fCtx.getStart().getCharPositionInLine(), fCtx.IDENT()
                                .getText());
            }

            currentST.add(fCtx.IDENT().getText(), new FunctionObj(currentST,
                    functionScope, returnType.getType(), paramsObj));
        }
    }

    @Override
    public ProgramNode visitProgram(@NotNull WACCParser.ProgramContext ctx) {
        createChildST();
        parseFunctions(ctx);
        createChildST();
        List<FunctionNode> functionNodes = ctx.func().stream()
                .map(f -> visitFunc(f))
                .collect(Collectors.toList());
        return new ProgramNode(currentST, ctx, functionNodes, visitStatNode
                (ctx.stat()));
    }

    @Override
    public ReturnNode visitReturnStat(@NotNull WACCParser.ReturnStatContext
                                                  ctx) {
        return new ReturnNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public ArrayElementNode visitArrayElem(@NotNull WACCParser
            .ArrayElemContext ctx) {
        List<ExprNode> exprList = ctx.expr().stream()
                .map(prc -> visitExprNodes(prc))
                .collect(Collectors.toList());
        return new ArrayElementNode(currentST, ctx, exprList);
    }

    @Override
    public AssignRhsNode visitAssignRhs(@NotNull WACCParser.AssignRhsContext
                                                    ctx) {
        if (ctx.OPEN_SQUARE_BRACKET() != null) {
            List<ExprNode> exprNodes = ctx.expr().stream()
                    .map(e -> visitExprNodes(e))
                    .collect(Collectors.toList());
            return new AssignRhsNode(currentST, ctx, exprNodes);
        } else if (ctx.NEWPAIR() != null) {
            return new AssignRhsNode(currentST, ctx, visitExprNodes(ctx.expr
                    (0)), visitExprNodes(ctx.expr(1)));
        } else if (ctx.pairElem() != null) {
            return new AssignRhsNode(currentST, ctx, visitPairElem(ctx
                    .pairElem()));
        } else if (ctx.CALL_FUNC() != null) {
            List<ExprNode> args = ctx.expr().stream()
                    .map(e -> visitExprNodes(e))
                    .collect(Collectors.toList());
            return new AssignRhsNode(currentST, ctx, args, ctx.IDENT()
                    .getText());
        } else {
            return new AssignRhsNode(currentST, ctx, visitExprNodes(ctx.expr
                    (0)));
        }
    }

    @Override
    public AssignLhsNode visitAssignLhs(@NotNull WACCParser.AssignLhsContext
                                                    ctx) {
        if (ctx.IDENT() != null) {
            return new AssignLhsNode(currentST, ctx);
        } else if (ctx.arrayElem() != null) {
            return new AssignLhsNode(currentST, ctx, visitArrayElem(ctx
                    .arrayElem()));
        } else {
            return new AssignLhsNode(currentST, ctx, visitPairElem(ctx
                    .pairElem()));
        }
    }

    @Override
    public TypeNode visitType(@NotNull WACCParser.TypeContext ctx) {
        if (ctx.OPEN_PARENTHESES() != null) {
            // round PARENTHESES
            return new TypeNode(currentST, ctx, visitPairElemType(ctx
                    .pairElemType(0)),
                    visitPairElemType(ctx.pairElemType(1)));
        } else if (ctx.OPEN_SQUARE_BRACKET() != null) {
            // square PARENTHESES
            return new TypeNode(currentST, ctx, visitType(ctx.type()));
        } else {
            // baseType
            return new TypeNode(currentST, ctx, visitBaseType(ctx.baseType()));
        }
    }

    @Override
    public AssignPairArrayNode visitAssignPairArrayStat(@NotNull WACCParser
            .AssignPairArrayStatContext ctx) {
        return new AssignPairArrayNode(currentST, ctx, visitAssignLhs(ctx
                .assignLhs()), visitAssignRhs(ctx.assignRhs()));
    }

    @Override
    public ReadNode visitReadStat(@NotNull WACCParser.ReadStatContext ctx) {
        return new ReadNode(currentST, ctx, visitAssignLhs(ctx.assignLhs()));
    }

    @Override
    public BaseTypeNode visitBaseType(@NotNull WACCParser.BaseTypeContext ctx) {
        return new BaseTypeNode(currentST, ctx);
    }

    @Override
    public PrintlnNode visitPrintlnStat(@NotNull WACCParser
            .PrintlnStatContext ctx) {
        return new PrintlnNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public IdentNode visitIdentExpr(@NotNull WACCParser.IdentExprContext ctx) {
        return new IdentNode(currentST, ctx);
    }

    @Override
    public BoolNode visitBoolLiteral(@NotNull WACCParser.BoolLiteralContext
                                                 ctx) {
        return new BoolNode(currentST, ctx);
    }

    @Override
    public IntNode visitIntLiteral(@NotNull WACCParser.IntLiteralContext ctx) {
        return new IntNode(currentST, ctx);
    }

    @Override
    public CharNode visitCharLiteral(@NotNull WACCParser.CharLiteralContext
                                                 ctx) {
        return new CharNode(currentST, ctx);
    }

    @Override
    public StringNode visitStrLiteral(@NotNull WACCParser.StrLiteralContext
                                                  ctx) {
        return new StringNode(currentST, ctx);
    }

    @Override
    public PairNode visitPairLiteral(@NotNull WACCParser.PairLiteralContext
                                                 ctx) {
        return new PairNode(currentST, ctx);
    }

    @Override
    public ParamNode visitParam(@NotNull WACCParser.ParamContext ctx) {
        return new ParamNode(currentST, ctx, visitType(ctx.type()));
    }

    @Override
    public CompositionNode visitCompositionStat(@NotNull WACCParser
            .CompositionStatContext ctx) {
        return new CompositionNode(currentST, ctx, visitStatNode(ctx.stat(0))
                , visitStatNode(ctx.stat(1)));
    }

    @Override
    public PrintNode visitPrintStat(@NotNull WACCParser.PrintStatContext ctx) {
        return new PrintNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public BinOpNode visitBinAndExpr(@NotNull WACCParser.BinAndExprContext
                                                 ctx) {
        ExprNode lhs = visitExprNodes(ctx.expr(0));
        ExprNode rhs = visitExprNodes(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, ctx.AND().getText(), rhs);
    }

    @Override
    public BinOpNode visitBinEqExpr(@NotNull WACCParser.BinEqExprContext ctx) {
        ExprNode lhs = visitExprNodes(ctx.expr(0));
        ExprNode rhs = visitExprNodes(ctx.expr(1));

        if (ctx.EQ() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.EQ().getText(), rhs);
        } else {
            return new BinOpNode(currentST, ctx, lhs, ctx.NOT_EQ().getText(),
                    rhs);
        }
    }

    @Override
    public ExprNode visitLiteralExpr(@NotNull WACCParser.LiteralExprContext
                                                 ctx) {
        return (ExprNode) visit(ctx.literal());
    }

    @Override
    public BinOpNode visitBinOrExpr(@NotNull WACCParser.BinOrExprContext ctx) {
        ExprNode lhs = visitExprNodes(ctx.expr(0));
        ExprNode rhs = visitExprNodes(ctx.expr(1));

        return new BinOpNode(currentST, ctx, lhs, ctx.OR().getText(), rhs);
    }

    @Override
    public BinOpNode visitBinCompExpr(@NotNull WACCParser.BinCompExprContext
                                                  ctx) {
        ExprNode lhs = visitExprNodes(ctx.expr(0));
        ExprNode rhs = visitExprNodes(ctx.expr(1));

        if (ctx.GREATER() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.GREATER().getText()
                    , rhs);
        } else if (ctx.GREATER_EQ() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.GREATER_EQ()
                    .getText(), rhs);
        } else if (ctx.SMALLER() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.SMALLER().getText()
                    , rhs);
        } else {
            return new BinOpNode(currentST, ctx, lhs, ctx.SMALLER_EQ()
                    .getText(), rhs);
        }
    }

    @Override
    public BinOpNode visitBinMulDivModExpr(@NotNull WACCParser
            .BinMulDivModExprContext ctx) {
        ExprNode lhs = visitExprNodes(ctx.expr(0));
        ExprNode rhs = visitExprNodes(ctx.expr(1));

        if (ctx.MULTIPLY() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.MULTIPLY().getText
                    (), rhs);
        } else if (ctx.DIVISION() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.DIVISION().getText
                    (), rhs);
        } else {
            return new BinOpNode(currentST, ctx, lhs, ctx.MODULO().getText(),
                    rhs);
        }
    }

    @Override
    public BinOpNode visitBinPlusMinusExpr(@NotNull WACCParser
            .BinPlusMinusExprContext ctx) {
        ExprNode lhs = visitExprNodes(ctx.expr(0));
        ExprNode rhs = visitExprNodes(ctx.expr(1));

        if (ctx.PLUS() != null) {
            return new BinOpNode(currentST, ctx, lhs, ctx.PLUS().getText(),
                    rhs);
        } else {
            return new BinOpNode(currentST, ctx, lhs, ctx.MINUS().getText(),
                    rhs);
        }
    }

    @Override
    public UnaryOpNode visitUnPlusExpr(@NotNull WACCParser.UnPlusExprContext
                                                   ctx) {
        return new UnaryOpNode(currentST, ctx, ctx.PLUS().getText(), new
                IntNode(currentST, ctx.INT_LITERAL().getText()));
    }

    @Override
    public ExprNode visitArrayExpr(@NotNull WACCParser.ArrayExprContext ctx) {
        return (ExprNode) visit(ctx.arrayElem());
    }

    @Override
    public UnaryOpNode visitUnExpr(@NotNull WACCParser.UnExprContext ctx) {
        // special case
        if (ctx.MINUS() != null) {
            // might have negative integer
            Pattern p = Pattern.compile("[0-9]+");
            if (p.matcher(ctx.expr().getText()).matches()) {
                // we have int literal
                return new UnaryOpNode(currentST, ctx, ctx.MINUS().getText(),
                        new IntNode(currentST, "-" + ctx.expr().getText()));
            }
        }

        if (ctx.MINUS() != null) {
            return new UnaryOpNode(currentST, ctx, ctx.MINUS().getText(),
                    visitExprNodes(ctx.expr()));
        } else if (ctx.NOT() != null) {
            return new UnaryOpNode(currentST, ctx, ctx.NOT().getText(),
                    visitExprNodes(ctx.expr()));
        } else if (ctx.LEN() != null) {
            return new UnaryOpNode(currentST, ctx, ctx.LEN().getText(),
                    visitExprNodes(ctx.expr()));
        } else if (ctx.CHR() != null) {
            return new UnaryOpNode(currentST, ctx, ctx.CHR().getText(),
                    visitExprNodes(ctx.expr()));
        } else {
            return new UnaryOpNode(currentST, ctx, ctx.ORD().getText(),
                    visitExprNodes(ctx.expr()));
        }
    }

    @Override
    public ParenthesisNode visitParanthesisExpr(@NotNull WACCParser
            .ParanthesisExprContext ctx) {
        return new ParenthesisNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public PairElemNode visitPairElem(@NotNull WACCParser.PairElemContext ctx) {
        return new PairElemNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public ExitNode visitExitStat(@NotNull WACCParser.ExitStatContext ctx) {
        return new ExitNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public IfNode visitIfStat(@NotNull WACCParser.IfStatContext ctx) {
        ExprNode exprBlock = visitExprNodes(ctx.expr());

        createChildST();
        StatNode thenBlock = visitStatNode(ctx.stat(0));
        closeCurrentScope();

        createChildST();
        StatNode elseBlock = visitStatNode(ctx.stat(1));
        closeCurrentScope();

        return new IfNode(currentST, ctx, exprBlock, thenBlock, elseBlock);
    }

    @Override
    public FreeNode visitFreeStat(@NotNull WACCParser.FreeStatContext ctx) {
        return new FreeNode(currentST, ctx, visitExprNodes(ctx.expr()));
    }

    @Override
    public SkipNode visitSkipStat(@NotNull WACCParser.SkipStatContext ctx) {
        return new SkipNode(currentST, ctx);
    }

    @Override
    public WhileNode visitWhileStat(@NotNull WACCParser.WhileStatContext ctx) {
        createChildST();
        WhileNode whileBlock = new WhileNode(currentST, ctx, visitExprNodes
                (ctx.expr()), visitStatNode(ctx.stat()));
        closeCurrentScope();
        return whileBlock;
    }

    @Override
    public PairElemTypeNode visitPairElemType(@NotNull WACCParser
            .PairElemTypeContext ctx) {
        if (ctx.baseType() != null) {
            return new PairElemTypeNode(currentST, ctx, visitBaseType(ctx
                    .baseType()));
        } else if (ctx.OPEN_SQUARE_BRACKET() != null) {
            return new PairElemTypeNode(currentST, ctx, visitType(ctx.type()));
        } else {
            return new PairElemTypeNode(currentST, ctx);
        }
    }

    @Override
    public AssignPrimitiveNode visitAssignPrimitiveStat(@NotNull WACCParser
            .AssignPrimitiveStatContext ctx) {
        return new AssignPrimitiveNode(currentST, ctx, visitType(ctx.type()),
                visitAssignRhs(ctx.assignRhs()));
    }

    @Override
    public FunctionNode visitFunc(@NotNull WACCParser.FuncContext ctx) {
        SymbolTable previousST = currentST;
        FunctionObj fObj = currentST.lookupAll(ctx.IDENT().getText(),
                FunctionObj.class);
        assert (fObj != null) : "Should always find a function object";
        currentST = fObj.getFunctionScope();
        StatNode statBlock = visitStatNode(ctx.stat());
        currentST = previousST;

        return new FunctionNode(currentST, ctx, fObj, statBlock);
    }

    @Override
    public ScopeBlockNode visitScopeBlockStat(@NotNull WACCParser
            .ScopeBlockStatContext ctx) {
        createChildST();
        ScopeBlockNode block = new ScopeBlockNode(currentST, ctx,
                visitStatNode(ctx.stat()));
        closeCurrentScope();
        return block;
    }
}
