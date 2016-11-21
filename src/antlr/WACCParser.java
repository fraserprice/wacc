// Generated from ./WACCParser.g4 by ANTLR 4.4
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WACCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, OPEN_PARENTHESES=3, CLOSE_PARENTHESES=4, OPEN_SQUARE_BRACKET=5, 
		CLOSE_SQUARE_BRACKET=6, IS=7, COMMA=8, CALL_FUNC=9, SKIP_STAT=10, ASSIGN_STAT=11, 
		READ_STAT=12, FREE_STAT=13, RETURN_STAT=14, EXIT_STAT=15, PRINT_STAT=16, 
		PRINTLN_STAT=17, IF_STAT=18, THEN_STAT=19, ELSE_STAT=20, FI_STAT=21, WHILE_STAT=22, 
		DO_STAT=23, DONE_STAT=24, BEGIN_STAT=25, END_STAT=26, COMPOSITION_STAT=27, 
		INT=28, BOOL=29, CHAR=30, STRING=31, NEWPAIR=32, PAIR=33, FST=34, SND=35, 
		NOT=36, MINUS=37, LEN=38, ORD=39, CHR=40, MULTIPLY=41, DIVISION=42, MODULO=43, 
		PLUS=44, GREATER=45, GREATER_EQ=46, SMALLER=47, SMALLER_EQ=48, EQ=49, 
		NOT_EQ=50, AND=51, OR=52, INT_LITERAL=53, BOOL_LITERAL=54, CHAR_LITERAL=55, 
		STR_LITERAL=56, PAIR_LITERAL=57, IDENT=58;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "COMMENT", "'('", "')'", "'['", "']'", "'is'", "','", 
		"'call'", "'skip'", "'='", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"'begin'", "'end'", "';'", "'int'", "'bool'", "'char'", "'string'", "'newpair'", 
		"'pair'", "'fst'", "'snd'", "'!'", "'-'", "'len'", "'ord'", "'chr'", "'*'", 
		"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", 
		"'||'", "INT_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STR_LITERAL", 
		"'null'", "IDENT"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param = 2, RULE_stat = 3, RULE_assignLhs = 4, 
		RULE_assignRhs = 5, RULE_pairElem = 6, RULE_type = 7, RULE_baseType = 8, 
		RULE_pairElemType = 9, RULE_expr = 10, RULE_literal = 11, RULE_arrayElem = 12;
	public static final String[] ruleNames = {
		"program", "func", "param", "stat", "assignLhs", "assignRhs", "pairElem", 
		"type", "baseType", "pairElemType", "expr", "literal", "arrayElem"
	};

	@Override
	public String getGrammarFileName() { return "WACCParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WACCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode BEGIN_STAT() { return getToken(WACCParser.BEGIN_STAT, 0); }
		public TerminalNode EOF() { return getToken(WACCParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode END_STAT() { return getToken(WACCParser.END_STAT, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26); match(BEGIN_STAT);
			setState(30);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(27); func();
					}
					} 
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(33); stat(0);
			setState(34); match(END_STAT);
			setState(35); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode IS() { return getToken(WACCParser.IS, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public TerminalNode END_STAT() { return getToken(WACCParser.END_STAT, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); type(0);
			setState(38); match(IDENT);
			setState(39); match(OPEN_PARENTHESES);
			setState(48);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(40); param();
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(41); match(COMMA);
					setState(42); param();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(50); match(CLOSE_PARENTHESES);
			setState(51); match(IS);
			setState(52); stat(0);
			setState(53); match(END_STAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); type(0);
			setState(56); match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnStatContext extends StatContext {
		public TerminalNode RETURN_STAT() { return getToken(WACCParser.RETURN_STAT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExitStatContext extends StatContext {
		public TerminalNode EXIT_STAT() { return getToken(WACCParser.EXIT_STAT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExitStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitExitStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE_STAT() { return getToken(WACCParser.ELSE_STAT, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode IF_STAT() { return getToken(WACCParser.IF_STAT, 0); }
		public TerminalNode FI_STAT() { return getToken(WACCParser.FI_STAT, 0); }
		public TerminalNode THEN_STAT() { return getToken(WACCParser.THEN_STAT, 0); }
		public IfStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FreeStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FREE_STAT() { return getToken(WACCParser.FREE_STAT, 0); }
		public FreeStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitFreeStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipStatContext extends StatContext {
		public TerminalNode SKIP_STAT() { return getToken(WACCParser.SKIP_STAT, 0); }
		public SkipStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitSkipStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHILE_STAT() { return getToken(WACCParser.WHILE_STAT, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode DO_STAT() { return getToken(WACCParser.DO_STAT, 0); }
		public TerminalNode DONE_STAT() { return getToken(WACCParser.DONE_STAT, 0); }
		public WhileStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignPairArrayStatContext extends StatContext {
		public AssignLhsContext assignLhs() {
			return getRuleContext(AssignLhsContext.class,0);
		}
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public TerminalNode ASSIGN_STAT() { return getToken(WACCParser.ASSIGN_STAT, 0); }
		public AssignPairArrayStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignPairArrayStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadStatContext extends StatContext {
		public AssignLhsContext assignLhs() {
			return getRuleContext(AssignLhsContext.class,0);
		}
		public TerminalNode READ_STAT() { return getToken(WACCParser.READ_STAT, 0); }
		public ReadStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitReadStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignPrimitiveStatContext extends StatContext {
		public AssignRhsContext assignRhs() {
			return getRuleContext(AssignRhsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGN_STAT() { return getToken(WACCParser.ASSIGN_STAT, 0); }
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public AssignPrimitiveStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignPrimitiveStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintlnStatContext extends StatContext {
		public TerminalNode PRINTLN_STAT() { return getToken(WACCParser.PRINTLN_STAT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintlnStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPrintlnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompositionStatContext extends StatContext {
		public TerminalNode COMPOSITION_STAT() { return getToken(WACCParser.COMPOSITION_STAT, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public CompositionStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitCompositionStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatContext {
		public TerminalNode PRINT_STAT() { return getToken(WACCParser.PRINT_STAT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPrintStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScopeBlockStatContext extends StatContext {
		public TerminalNode BEGIN_STAT() { return getToken(WACCParser.BEGIN_STAT, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode END_STAT() { return getToken(WACCParser.END_STAT, 0); }
		public ScopeBlockStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitScopeBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		return stat(0);
	}

	private StatContext stat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatContext _localctx = new StatContext(_ctx, _parentState);
		StatContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				{
				_localctx = new SkipStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(59); match(SKIP_STAT);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				_localctx = new AssignPrimitiveStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); type(0);
				setState(61); match(IDENT);
				setState(62); match(ASSIGN_STAT);
				setState(63); assignRhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				_localctx = new AssignPairArrayStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65); assignLhs();
				setState(66); match(ASSIGN_STAT);
				setState(67); assignRhs();
				}
				break;
			case READ_STAT:
				{
				_localctx = new ReadStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69); match(READ_STAT);
				setState(70); assignLhs();
				}
				break;
			case FREE_STAT:
				{
				_localctx = new FreeStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71); match(FREE_STAT);
				setState(72); expr(0);
				}
				break;
			case RETURN_STAT:
				{
				_localctx = new ReturnStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73); match(RETURN_STAT);
				setState(74); expr(0);
				}
				break;
			case EXIT_STAT:
				{
				_localctx = new ExitStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75); match(EXIT_STAT);
				setState(76); expr(0);
				}
				break;
			case PRINT_STAT:
				{
				_localctx = new PrintStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77); match(PRINT_STAT);
				setState(78); expr(0);
				}
				break;
			case PRINTLN_STAT:
				{
				_localctx = new PrintlnStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79); match(PRINTLN_STAT);
				setState(80); expr(0);
				}
				break;
			case IF_STAT:
				{
				_localctx = new IfStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81); match(IF_STAT);
				setState(82); expr(0);
				setState(83); match(THEN_STAT);
				setState(84); stat(0);
				setState(85); match(ELSE_STAT);
				setState(86); stat(0);
				setState(87); match(FI_STAT);
				}
				break;
			case WHILE_STAT:
				{
				_localctx = new WhileStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89); match(WHILE_STAT);
				setState(90); expr(0);
				setState(91); match(DO_STAT);
				setState(92); stat(0);
				setState(93); match(DONE_STAT);
				}
				break;
			case BEGIN_STAT:
				{
				_localctx = new ScopeBlockStatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95); match(BEGIN_STAT);
				setState(96); stat(0);
				setState(97); match(END_STAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompositionStatContext(new StatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(101);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(102); match(COMPOSITION_STAT);
					setState(103); stat(2);
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignLhsContext extends ParserRuleContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignLhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignLhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignLhsContext assignLhs() throws RecognitionException {
		AssignLhsContext _localctx = new AssignLhsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignLhs);
		try {
			setState(112);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110); arrayElem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111); pairElem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignRhsContext extends ParserRuleContext {
		public AssignRhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignRhs; }
	 
		public AssignRhsContext() { }
		public void copyFrom(AssignRhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignRhsPairElemContext extends AssignRhsContext {
		public PairElemContext pairElem() {
			return getRuleContext(PairElemContext.class,0);
		}
		public AssignRhsPairElemContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignRhsPairElem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignRhsExprContext extends AssignRhsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignRhsExprContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignRhsExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignRhsNewPairContext extends AssignRhsContext {
		public TerminalNode NEWPAIR() { return getToken(WACCParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public AssignRhsNewPairContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignRhsNewPair(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignRhsArrayLiteralContext extends AssignRhsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public AssignRhsArrayLiteralContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignRhsArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignRhsCallFuncContext extends AssignRhsContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public TerminalNode CALL_FUNC() { return getToken(WACCParser.CALL_FUNC, 0); }
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public AssignRhsCallFuncContext(AssignRhsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssignRhsCallFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignRhsContext assignRhs() throws RecognitionException {
		AssignRhsContext _localctx = new AssignRhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignRhs);
		int _la;
		try {
			setState(149);
			switch (_input.LA(1)) {
			case OPEN_PARENTHESES:
			case NOT:
			case MINUS:
			case LEN:
			case ORD:
			case CHR:
			case PLUS:
			case INT_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STR_LITERAL:
			case PAIR_LITERAL:
			case IDENT:
				_localctx = new AssignRhsExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(114); expr(0);
				}
				break;
			case OPEN_SQUARE_BRACKET:
				_localctx = new AssignRhsArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(115); match(OPEN_SQUARE_BRACKET);
				setState(124);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PARENTHESES) | (1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << PLUS) | (1L << INT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << PAIR_LITERAL) | (1L << IDENT))) != 0)) {
					{
					setState(116); expr(0);
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(117); match(COMMA);
						setState(118); expr(0);
						}
						}
						setState(123);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(126); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case NEWPAIR:
				_localctx = new AssignRhsNewPairContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(127); match(NEWPAIR);
				setState(128); match(OPEN_PARENTHESES);
				setState(129); expr(0);
				setState(130); match(COMMA);
				setState(131); expr(0);
				setState(132); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				_localctx = new AssignRhsPairElemContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134); pairElem();
				}
				break;
			case CALL_FUNC:
				_localctx = new AssignRhsCallFuncContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(135); match(CALL_FUNC);
				setState(136); match(IDENT);
				setState(137); match(OPEN_PARENTHESES);
				setState(146);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PARENTHESES) | (1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << PLUS) | (1L << INT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << PAIR_LITERAL) | (1L << IDENT))) != 0)) {
					{
					setState(138); expr(0);
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(139); match(COMMA);
						setState(140); expr(0);
						}
						}
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(148); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairElemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(WACCParser.SND, 0); }
		public TerminalNode FST() { return getToken(WACCParser.FST, 0); }
		public PairElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemContext pairElem() throws RecognitionException {
		PairElemContext _localctx = new PairElemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pairElem);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(151); match(FST);
				setState(152); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); match(SND);
				setState(154); expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public PairElemTypeContext pairElemType(int i) {
			return getRuleContext(PairElemTypeContext.class,i);
		}
		public List<PairElemTypeContext> pairElemType() {
			return getRuleContexts(PairElemTypeContext.class);
		}
		public TerminalNode PAIR() { return getToken(WACCParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(158); baseType();
				}
				break;
			case PAIR:
				{
				setState(159); match(PAIR);
				setState(160); match(OPEN_PARENTHESES);
				setState(161); pairElemType();
				setState(162); match(COMMA);
				setState(163); pairElemType();
				setState(164); match(CLOSE_PARENTHESES);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(168);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(169); match(OPEN_SQUARE_BRACKET);
					setState(170); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(WACCParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(WACCParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(WACCParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(WACCParser.INT, 0); }
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairElemTypeContext extends ParserRuleContext {
		public TerminalNode PAIR() { return getToken(WACCParser.PAIR, 0); }
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public PairElemTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pairElemType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairElemType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PairElemTypeContext pairElemType() throws RecognitionException {
		PairElemTypeContext _localctx = new PairElemTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pairElemType);
		try {
			setState(184);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178); baseType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179); type(0);
				setState(180); match(OPEN_SQUARE_BRACKET);
				setState(181); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183); match(PAIR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinCompExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode GREATER_EQ() { return getToken(WACCParser.GREATER_EQ, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SMALLER_EQ() { return getToken(WACCParser.SMALLER_EQ, 0); }
		public TerminalNode GREATER() { return getToken(WACCParser.GREATER, 0); }
		public TerminalNode SMALLER() { return getToken(WACCParser.SMALLER, 0); }
		public BinCompExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExprContext {
		public ArrayElemContext arrayElem() {
			return getRuleContext(ArrayElemContext.class,0);
		}
		public ArrayExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentExprContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public IdentExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIdentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnExprContext extends ExprContext {
		public TerminalNode NOT() { return getToken(WACCParser.NOT, 0); }
		public TerminalNode ORD() { return getToken(WACCParser.ORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEN() { return getToken(WACCParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public TerminalNode CHR() { return getToken(WACCParser.CHR, 0); }
		public UnExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitUnExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinMulDivModExprContext extends ExprContext {
		public TerminalNode DIVISION() { return getToken(WACCParser.DIVISION, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MODULO() { return getToken(WACCParser.MODULO, 0); }
		public TerminalNode MULTIPLY() { return getToken(WACCParser.MULTIPLY, 0); }
		public BinMulDivModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinMulDivModExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinAndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(WACCParser.AND, 0); }
		public BinAndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinPlusMinusExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public BinPlusMinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinPlusMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinOrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(WACCParser.OR, 0); }
		public BinOrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanthesisExprContext extends ExprContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public ParanthesisExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParanthesisExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinEqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOT_EQ() { return getToken(WACCParser.NOT_EQ, 0); }
		public TerminalNode EQ() { return getToken(WACCParser.EQ, 0); }
		public BinEqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnPlusExprContext extends ExprContext {
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public TerminalNode INT_LITERAL() { return getToken(WACCParser.INT_LITERAL, 0); }
		public UnPlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitUnPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				_localctx = new UnExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(187);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(188); expr(10);
				}
				break;
			case 2:
				{
				_localctx = new ParanthesisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189); match(OPEN_PARENTHESES);
				setState(190); expr(0);
				setState(191); match(CLOSE_PARENTHESES);
				}
				break;
			case 3:
				{
				_localctx = new UnPlusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); match(PLUS);
				setState(194); match(INT_LITERAL);
				}
				break;
			case 4:
				{
				_localctx = new ArrayExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195); arrayElem();
				}
				break;
			case 5:
				{
				_localctx = new LiteralExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196); literal();
				}
				break;
			case 6:
				{
				_localctx = new IdentExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197); match(IDENT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(218);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new BinMulDivModExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(201);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLY) | (1L << DIVISION) | (1L << MODULO))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(202); expr(10);
						}
						break;
					case 2:
						{
						_localctx = new BinPlusMinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(204);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(205); expr(9);
						}
						break;
					case 3:
						{
						_localctx = new BinCompExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(207);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GREATER) | (1L << GREATER_EQ) | (1L << SMALLER) | (1L << SMALLER_EQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(208); expr(8);
						}
						break;
					case 4:
						{
						_localctx = new BinEqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(210);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NOT_EQ) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(211); expr(7);
						}
						break;
					case 5:
						{
						_localctx = new BinAndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(213); match(AND);
						setState(214); expr(6);
						}
						break;
					case 6:
						{
						_localctx = new BinOrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(216); match(OR);
						setState(217); expr(5);
						}
						break;
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolLiteralContext extends LiteralContext {
		public TerminalNode BOOL_LITERAL() { return getToken(WACCParser.BOOL_LITERAL, 0); }
		public BoolLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralContext extends LiteralContext {
		public TerminalNode CHAR_LITERAL() { return getToken(WACCParser.CHAR_LITERAL, 0); }
		public CharLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLiteralContext extends LiteralContext {
		public TerminalNode INT_LITERAL() { return getToken(WACCParser.INT_LITERAL, 0); }
		public IntLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StrLiteralContext extends LiteralContext {
		public TerminalNode STR_LITERAL() { return getToken(WACCParser.STR_LITERAL, 0); }
		public StrLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStrLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PairLiteralContext extends LiteralContext {
		public TerminalNode PAIR_LITERAL() { return getToken(WACCParser.PAIR_LITERAL, 0); }
		public PairLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPairLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_literal);
		try {
			setState(228);
			switch (_input.LA(1)) {
			case INT_LITERAL:
				_localctx = new IntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(223); match(INT_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(224); match(BOOL_LITERAL);
				}
				break;
			case CHAR_LITERAL:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225); match(CHAR_LITERAL);
				}
				break;
			case STR_LITERAL:
				_localctx = new StrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(226); match(STR_LITERAL);
				}
				break;
			case PAIR_LITERAL:
				_localctx = new PairLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(227); match(PAIR_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayElemContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> OPEN_SQUARE_BRACKET() { return getTokens(WACCParser.OPEN_SQUARE_BRACKET); }
		public TerminalNode OPEN_SQUARE_BRACKET(int i) {
			return getToken(WACCParser.OPEN_SQUARE_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_SQUARE_BRACKET() { return getTokens(WACCParser.CLOSE_SQUARE_BRACKET); }
		public TerminalNode CLOSE_SQUARE_BRACKET(int i) {
			return getToken(WACCParser.CLOSE_SQUARE_BRACKET, i);
		}
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public ArrayElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayElem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArrayElem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayElemContext arrayElem() throws RecognitionException {
		ArrayElemContext _localctx = new ArrayElemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayElem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230); match(IDENT);
			setState(235); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(231); match(OPEN_SQUARE_BRACKET);
					setState(232); expr(0);
					setState(233); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(237); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return stat_sempred((StatContext)_localctx, predIndex);
		case 7: return type_sempred((TypeContext)_localctx, predIndex);
		case 10: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 9);
		case 3: return precpred(_ctx, 8);
		case 4: return precpred(_ctx, 7);
		case 5: return precpred(_ctx, 6);
		case 6: return precpred(_ctx, 5);
		case 7: return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u00f2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\5\3\63\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5f\n\5\3"+
		"\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\3\6\3\6\3\6\5\6s\n\6\3\7\3\7\3\7\3"+
		"\7\3\7\7\7z\n\7\f\7\16\7}\13\7\5\7\177\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0090\n\7\f\7\16\7\u0093\13\7\5\7"+
		"\u0095\n\7\3\7\5\7\u0098\n\7\3\b\3\b\3\b\3\b\5\b\u009e\n\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a9\n\t\3\t\3\t\3\t\7\t\u00ae\n\t\f\t\16"+
		"\t\u00b1\13\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bb\n\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c9\n\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00dd"+
		"\n\f\f\f\16\f\u00e0\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00e7\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\6\16\u00ee\n\16\r\16\16\16\u00ef\3\16\2\5\b\20\26\17\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\2\b\3\2\36!\3\2&*\3\2+-\4\2\'\'..\3\2/\62"+
		"\3\2\63\64\u0112\2\34\3\2\2\2\4\'\3\2\2\2\69\3\2\2\2\be\3\2\2\2\nr\3\2"+
		"\2\2\f\u0097\3\2\2\2\16\u009d\3\2\2\2\20\u00a8\3\2\2\2\22\u00b2\3\2\2"+
		"\2\24\u00ba\3\2\2\2\26\u00c8\3\2\2\2\30\u00e6\3\2\2\2\32\u00e8\3\2\2\2"+
		"\34 \7\33\2\2\35\37\5\4\3\2\36\35\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3"+
		"\2\2\2!#\3\2\2\2\" \3\2\2\2#$\5\b\5\2$%\7\34\2\2%&\7\2\2\3&\3\3\2\2\2"+
		"\'(\5\20\t\2()\7<\2\2)\62\7\5\2\2*/\5\6\4\2+,\7\n\2\2,.\5\6\4\2-+\3\2"+
		"\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\62*\3"+
		"\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\6\2\2\65\66\7\t\2\2\66\67\5"+
		"\b\5\2\678\7\34\2\28\5\3\2\2\29:\5\20\t\2:;\7<\2\2;\7\3\2\2\2<=\b\5\1"+
		"\2=f\7\f\2\2>?\5\20\t\2?@\7<\2\2@A\7\r\2\2AB\5\f\7\2Bf\3\2\2\2CD\5\n\6"+
		"\2DE\7\r\2\2EF\5\f\7\2Ff\3\2\2\2GH\7\16\2\2Hf\5\n\6\2IJ\7\17\2\2Jf\5\26"+
		"\f\2KL\7\20\2\2Lf\5\26\f\2MN\7\21\2\2Nf\5\26\f\2OP\7\22\2\2Pf\5\26\f\2"+
		"QR\7\23\2\2Rf\5\26\f\2ST\7\24\2\2TU\5\26\f\2UV\7\25\2\2VW\5\b\5\2WX\7"+
		"\26\2\2XY\5\b\5\2YZ\7\27\2\2Zf\3\2\2\2[\\\7\30\2\2\\]\5\26\f\2]^\7\31"+
		"\2\2^_\5\b\5\2_`\7\32\2\2`f\3\2\2\2ab\7\33\2\2bc\5\b\5\2cd\7\34\2\2df"+
		"\3\2\2\2e<\3\2\2\2e>\3\2\2\2eC\3\2\2\2eG\3\2\2\2eI\3\2\2\2eK\3\2\2\2e"+
		"M\3\2\2\2eO\3\2\2\2eQ\3\2\2\2eS\3\2\2\2e[\3\2\2\2ea\3\2\2\2fl\3\2\2\2"+
		"gh\f\3\2\2hi\7\35\2\2ik\5\b\5\4jg\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2"+
		"\2m\t\3\2\2\2nl\3\2\2\2os\7<\2\2ps\5\32\16\2qs\5\16\b\2ro\3\2\2\2rp\3"+
		"\2\2\2rq\3\2\2\2s\13\3\2\2\2t\u0098\5\26\f\2u~\7\7\2\2v{\5\26\f\2wx\7"+
		"\n\2\2xz\5\26\f\2yw\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2"+
		"}{\3\2\2\2~v\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0098\7\b\2"+
		"\2\u0081\u0082\7\"\2\2\u0082\u0083\7\5\2\2\u0083\u0084\5\26\f\2\u0084"+
		"\u0085\7\n\2\2\u0085\u0086\5\26\f\2\u0086\u0087\7\6\2\2\u0087\u0098\3"+
		"\2\2\2\u0088\u0098\5\16\b\2\u0089\u008a\7\13\2\2\u008a\u008b\7<\2\2\u008b"+
		"\u0094\7\5\2\2\u008c\u0091\5\26\f\2\u008d\u008e\7\n\2\2\u008e\u0090\5"+
		"\26\f\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u008c\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\7\6\2\2\u0097"+
		"t\3\2\2\2\u0097u\3\2\2\2\u0097\u0081\3\2\2\2\u0097\u0088\3\2\2\2\u0097"+
		"\u0089\3\2\2\2\u0098\r\3\2\2\2\u0099\u009a\7$\2\2\u009a\u009e\5\26\f\2"+
		"\u009b\u009c\7%\2\2\u009c\u009e\5\26\f\2\u009d\u0099\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\17\3\2\2\2\u009f\u00a0\b\t\1\2\u00a0\u00a9\5\22\n\2\u00a1"+
		"\u00a2\7#\2\2\u00a2\u00a3\7\5\2\2\u00a3\u00a4\5\24\13\2\u00a4\u00a5\7"+
		"\n\2\2\u00a5\u00a6\5\24\13\2\u00a6\u00a7\7\6\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u009f\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a9\u00af\3\2\2\2\u00aa\u00ab\f\4"+
		"\2\2\u00ab\u00ac\7\7\2\2\u00ac\u00ae\7\b\2\2\u00ad\u00aa\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\21\3\2\2"+
		"\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\t\2\2\2\u00b3\23\3\2\2\2\u00b4\u00bb"+
		"\5\22\n\2\u00b5\u00b6\5\20\t\2\u00b6\u00b7\7\7\2\2\u00b7\u00b8\7\b\2\2"+
		"\u00b8\u00bb\3\2\2\2\u00b9\u00bb\7#\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b5"+
		"\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\25\3\2\2\2\u00bc\u00bd\b\f\1\2\u00bd"+
		"\u00be\t\3\2\2\u00be\u00c9\5\26\f\f\u00bf\u00c0\7\5\2\2\u00c0\u00c1\5"+
		"\26\f\2\u00c1\u00c2\7\6\2\2\u00c2\u00c9\3\2\2\2\u00c3\u00c4\7.\2\2\u00c4"+
		"\u00c9\7\67\2\2\u00c5\u00c9\5\32\16\2\u00c6\u00c9\5\30\r\2\u00c7\u00c9"+
		"\7<\2\2\u00c8\u00bc\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8"+
		"\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00de\3\2"+
		"\2\2\u00ca\u00cb\f\13\2\2\u00cb\u00cc\t\4\2\2\u00cc\u00dd\5\26\f\f\u00cd"+
		"\u00ce\f\n\2\2\u00ce\u00cf\t\5\2\2\u00cf\u00dd\5\26\f\13\u00d0\u00d1\f"+
		"\t\2\2\u00d1\u00d2\t\6\2\2\u00d2\u00dd\5\26\f\n\u00d3\u00d4\f\b\2\2\u00d4"+
		"\u00d5\t\7\2\2\u00d5\u00dd\5\26\f\t\u00d6\u00d7\f\7\2\2\u00d7\u00d8\7"+
		"\65\2\2\u00d8\u00dd\5\26\f\b\u00d9\u00da\f\6\2\2\u00da\u00db\7\66\2\2"+
		"\u00db\u00dd\5\26\f\7\u00dc\u00ca\3\2\2\2\u00dc\u00cd\3\2\2\2\u00dc\u00d0"+
		"\3\2\2\2\u00dc\u00d3\3\2\2\2\u00dc\u00d6\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\27\3\2\2"+
		"\2\u00e0\u00de\3\2\2\2\u00e1\u00e7\7\67\2\2\u00e2\u00e7\78\2\2\u00e3\u00e7"+
		"\79\2\2\u00e4\u00e7\7:\2\2\u00e5\u00e7\7;\2\2\u00e6\u00e1\3\2\2\2\u00e6"+
		"\u00e2\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2"+
		"\2\2\u00e7\31\3\2\2\2\u00e8\u00ed\7<\2\2\u00e9\u00ea\7\7\2\2\u00ea\u00eb"+
		"\5\26\f\2\u00eb\u00ec\7\b\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00e9\3\2\2\2"+
		"\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\33"+
		"\3\2\2\2\26 /\62elr{~\u0091\u0094\u0097\u009d\u00a8\u00af\u00ba\u00c8"+
		"\u00dc\u00de\u00e6\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}