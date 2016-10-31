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
		DONE_STAT=24, STR_LITERAL=57, PAIR_LITERAL=58, NEWPAIR=32, ELSE_STAT=20, 
		GREATER_EQ=46, PRINTLN_STAT=17, CHR=40, MINUS=37, SMALLER=47, END_STAT=26, 
		CLOSE_SQUARE_BRACKET=6, SKIP_STAT=10, READ_STAT=12, NOT_EQ=50, WHILE_STAT=22, 
		FST=34, MODULO=43, IS=7, EQ=49, BOOL_LITERAL=55, NOT=36, PRINT_STAT=16, 
		FI_STAT=21, AND=51, ASSIGN_STAT=11, MULTIPLY=41, OPEN_SQUARE_BRACKET=5, 
		CHAR_LITERAL=56, BEGIN_STAT=25, CLOSE_PARENTHESES=4, PLUS=44, ORD=39, 
		FREE_STAT=13, OPEN_PARENTHESES=3, SND=35, CHAR=30, COMPOSITION_STAT=27, 
		IF_STAT=18, COMMENT=2, INT=28, DIVISION=42, DO_STAT=23, INT_LITERAL=54, 
		WS=1, COMMA=8, OR=52, THEN_STAT=19, GREATER=45, EXIT_STAT=15, LEN=38, 
		IDENT=53, BOOL=29, STRING=31, SMALLER_EQ=48, RETURN_STAT=14, CALL_FUNC=9, 
		PAIR=33;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "COMMENT", "'('", "')'", "'['", "']'", "'is'", "','", 
		"'call'", "'skip'", "'='", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"'begin'", "'end'", "';'", "'int'", "'bool'", "'char'", "'string'", "'newpair'", 
		"'pair'", "'fst'", "'snd'", "'!'", "'-'", "'len'", "'ord'", "'chr'", "'*'", 
		"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", 
		"'||'", "IDENT", "INT_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STR_LITERAL", 
		"'null'"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_param_list = 2, RULE_param = 3, 
		RULE_stat = 4, RULE_assign_lhs = 5, RULE_assign_rhs = 6, RULE_arg_list = 7, 
		RULE_pair_elem = 8, RULE_type = 9, RULE_base_type = 10, RULE_pair_type = 11, 
		RULE_pair_elem_type = 12, RULE_expr = 13, RULE_unary_op = 14, RULE_binary_op = 15, 
		RULE_array_elem = 16, RULE_array_literal = 17;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "base_type", "pair_type", "pair_elem_type", 
		"expr", "unary_op", "binary_op", "array_elem", "array_literal"
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
			setState(36); match(BEGIN_STAT);
			setState(40);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(37); func();
					}
					} 
				}
				setState(42);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(43); stat(0);
			setState(44); match(END_STAT);
			setState(45); match(EOF);
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
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public TerminalNode END_STAT() { return getToken(WACCParser.END_STAT, 0); }
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
			setState(47); type(0);
			setState(48); match(IDENT);
			setState(49); match(OPEN_PARENTHESES);
			setState(51);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(50); param_list();
				}
			}

			setState(53); match(CLOSE_PARENTHESES);
			setState(54); match(IS);
			setState(55); stat(0);
			setState(56); match(END_STAT);
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

	public static class Param_listContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); param();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(59); match(COMMA);
				setState(60); param();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		enterRule(_localctx, 6, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); type(0);
			setState(67); match(IDENT);
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
		public TerminalNode RETURN_STAT() { return getToken(WACCParser.RETURN_STAT, 0); }
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public Assign_rhsContext assign_rhs() {
			return getRuleContext(Assign_rhsContext.class,0);
		}
		public TerminalNode WHILE_STAT() { return getToken(WACCParser.WHILE_STAT, 0); }
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode DO_STAT() { return getToken(WACCParser.DO_STAT, 0); }
		public TerminalNode THEN_STAT() { return getToken(WACCParser.THEN_STAT, 0); }
		public TerminalNode PRINTLN_STAT() { return getToken(WACCParser.PRINTLN_STAT, 0); }
		public TerminalNode SKIP_STAT() { return getToken(WACCParser.SKIP_STAT, 0); }
		public TerminalNode READ_STAT() { return getToken(WACCParser.READ_STAT, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public TerminalNode DONE_STAT() { return getToken(WACCParser.DONE_STAT, 0); }
		public TerminalNode END_STAT() { return getToken(WACCParser.END_STAT, 0); }
		public TerminalNode EXIT_STAT() { return getToken(WACCParser.EXIT_STAT, 0); }
		public TerminalNode PRINT_STAT() { return getToken(WACCParser.PRINT_STAT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE_STAT() { return getToken(WACCParser.ELSE_STAT, 0); }
		public TerminalNode COMPOSITION_STAT() { return getToken(WACCParser.COMPOSITION_STAT, 0); }
		public TerminalNode BEGIN_STAT() { return getToken(WACCParser.BEGIN_STAT, 0); }
		public Assign_lhsContext assign_lhs() {
			return getRuleContext(Assign_lhsContext.class,0);
		}
		public TerminalNode IF_STAT() { return getToken(WACCParser.IF_STAT, 0); }
		public TerminalNode ASSIGN_STAT() { return getToken(WACCParser.ASSIGN_STAT, 0); }
		public TerminalNode FREE_STAT() { return getToken(WACCParser.FREE_STAT, 0); }
		public TerminalNode FI_STAT() { return getToken(WACCParser.FI_STAT, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitStat(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_stat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				{
				setState(70); match(SKIP_STAT);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				setState(71); type(0);
				setState(72); match(IDENT);
				setState(73); match(ASSIGN_STAT);
				setState(74); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(76); assign_lhs();
				setState(77); match(ASSIGN_STAT);
				setState(78); assign_rhs();
				}
				break;
			case READ_STAT:
				{
				setState(80); match(READ_STAT);
				setState(81); assign_lhs();
				}
				break;
			case FREE_STAT:
				{
				setState(82); match(FREE_STAT);
				setState(83); expr(0);
				}
				break;
			case RETURN_STAT:
				{
				setState(84); match(RETURN_STAT);
				setState(85); expr(0);
				}
				break;
			case EXIT_STAT:
				{
				setState(86); match(EXIT_STAT);
				setState(87); expr(0);
				}
				break;
			case PRINT_STAT:
				{
				setState(88); match(PRINT_STAT);
				setState(89); expr(0);
				}
				break;
			case PRINTLN_STAT:
				{
				setState(90); match(PRINTLN_STAT);
				setState(91); expr(0);
				}
				break;
			case IF_STAT:
				{
				setState(92); match(IF_STAT);
				setState(93); expr(0);
				setState(94); match(THEN_STAT);
				setState(95); stat(0);
				setState(96); match(ELSE_STAT);
				setState(97); stat(0);
				setState(98); match(FI_STAT);
				}
				break;
			case WHILE_STAT:
				{
				setState(100); match(WHILE_STAT);
				setState(101); expr(0);
				setState(102); match(DO_STAT);
				setState(103); stat(0);
				setState(104); match(DONE_STAT);
				}
				break;
			case BEGIN_STAT:
				{
				setState(106); match(BEGIN_STAT);
				setState(107); stat(0);
				setState(108); match(END_STAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stat);
					setState(112);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(113); match(COMPOSITION_STAT);
					setState(114); stat(2);
					}
					} 
				}
				setState(119);
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

	public static class Assign_lhsContext extends ParserRuleContext {
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public Assign_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_lhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssign_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_lhsContext assign_lhs() throws RecognitionException {
		Assign_lhsContext _localctx = new Assign_lhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assign_lhs);
		try {
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122); pair_elem();
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

	public static class Assign_rhsContext extends ParserRuleContext {
		public TerminalNode NEWPAIR() { return getToken(WACCParser.NEWPAIR, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array_literalContext array_literal() {
			return getRuleContext(Array_literalContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public Pair_elemContext pair_elem() {
			return getRuleContext(Pair_elemContext.class,0);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public TerminalNode CALL_FUNC() { return getToken(WACCParser.CALL_FUNC, 0); }
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public Assign_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_rhs; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitAssign_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_rhsContext assign_rhs() throws RecognitionException {
		Assign_rhsContext _localctx = new Assign_rhsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign_rhs);
		int _la;
		try {
			setState(142);
			switch (_input.LA(1)) {
			case OPEN_PARENTHESES:
			case NOT:
			case MINUS:
			case LEN:
			case ORD:
			case CHR:
			case IDENT:
			case INT_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STR_LITERAL:
			case PAIR_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(125); expr(0);
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(126); array_literal();
				}
				break;
			case NEWPAIR:
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
				enterOuterAlt(_localctx, 4);
				{
				setState(134); pair_elem();
				}
				break;
			case CALL_FUNC:
				enterOuterAlt(_localctx, 5);
				{
				setState(135); match(CALL_FUNC);
				setState(136); match(IDENT);
				setState(137); match(OPEN_PARENTHESES);
				setState(139);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PARENTHESES) | (1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << IDENT) | (1L << INT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << PAIR_LITERAL))) != 0)) {
					{
					setState(138); arg_list();
					}
				}

				setState(141); match(CLOSE_PARENTHESES);
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

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(WACCParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(WACCParser.COMMA, i);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArg_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); expr(0);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(145); match(COMMA);
				setState(146); expr(0);
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class Pair_elemContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SND() { return getToken(WACCParser.SND, 0); }
		public TerminalNode FST() { return getToken(WACCParser.FST, 0); }
		public Pair_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elemContext pair_elem() throws RecognitionException {
		Pair_elemContext _localctx = new Pair_elemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pair_elem);
		try {
			setState(156);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); match(FST);
				setState(153); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); match(SND);
				setState(155); expr(0);
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
		public Pair_typeContext pair_type() {
			return getRuleContext(Pair_typeContext.class,0);
		}
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(159); base_type();
				}
				break;
			case PAIR:
				{
				setState(160); pair_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(163);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(164); match(OPEN_SQUARE_BRACKET);
					setState(165); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(WACCParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(WACCParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(WACCParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(WACCParser.INT, 0); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBase_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
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

	public static class Pair_typeContext extends ParserRuleContext {
		public List<Pair_elem_typeContext> pair_elem_type() {
			return getRuleContexts(Pair_elem_typeContext.class);
		}
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public TerminalNode PAIR() { return getToken(WACCParser.PAIR, 0); }
		public TerminalNode COMMA() { return getToken(WACCParser.COMMA, 0); }
		public Pair_elem_typeContext pair_elem_type(int i) {
			return getRuleContext(Pair_elem_typeContext.class,i);
		}
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public Pair_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_typeContext pair_type() throws RecognitionException {
		Pair_typeContext _localctx = new Pair_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pair_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(PAIR);
			setState(174); match(OPEN_PARENTHESES);
			setState(175); pair_elem_type();
			setState(176); match(COMMA);
			setState(177); pair_elem_type();
			setState(178); match(CLOSE_PARENTHESES);
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

	public static class Pair_elem_typeContext extends ParserRuleContext {
		public TerminalNode PAIR() { return getToken(WACCParser.PAIR, 0); }
		public TerminalNode OPEN_SQUARE_BRACKET() { return getToken(WACCParser.OPEN_SQUARE_BRACKET, 0); }
		public TerminalNode CLOSE_SQUARE_BRACKET() { return getToken(WACCParser.CLOSE_SQUARE_BRACKET, 0); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Pair_elem_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair_elem_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitPair_elem_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pair_elem_typeContext pair_elem_type() throws RecognitionException {
		Pair_elem_typeContext _localctx = new Pair_elem_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pair_elem_type);
		try {
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181); type(0);
				setState(182); match(OPEN_SQUARE_BRACKET);
				setState(183); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(185); match(PAIR);
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
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Binary_opContext binary_op() {
			return getRuleContext(Binary_opContext.class,0);
		}
		public TerminalNode PAIR_LITERAL() { return getToken(WACCParser.PAIR_LITERAL, 0); }
		public TerminalNode INT_LITERAL() { return getToken(WACCParser.INT_LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(WACCParser.CHAR_LITERAL, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(WACCParser.BOOL_LITERAL, 0); }
		public TerminalNode STR_LITERAL() { return getToken(WACCParser.STR_LITERAL, 0); }
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
		}
		public Array_elemContext array_elem() {
			return getRuleContext(Array_elemContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(189); unary_op();
				setState(190); expr(3);
				}
				break;
			case 2:
				{
				setState(192); match(INT_LITERAL);
				}
				break;
			case 3:
				{
				setState(193); match(BOOL_LITERAL);
				}
				break;
			case 4:
				{
				setState(194); match(CHAR_LITERAL);
				}
				break;
			case 5:
				{
				setState(195); match(STR_LITERAL);
				}
				break;
			case 6:
				{
				setState(196); match(PAIR_LITERAL);
				}
				break;
			case 7:
				{
				setState(197); match(IDENT);
				}
				break;
			case 8:
				{
				setState(198); array_elem();
				}
				break;
			case 9:
				{
				setState(199); match(OPEN_PARENTHESES);
				setState(200); expr(0);
				setState(201); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(205);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(206); binary_op();
					setState(207); expr(3);
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Unary_opContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(WACCParser.NOT, 0); }
		public TerminalNode ORD() { return getToken(WACCParser.ORD, 0); }
		public TerminalNode LEN() { return getToken(WACCParser.LEN, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public TerminalNode CHR() { return getToken(WACCParser.CHR, 0); }
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitUnary_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR))) != 0)) ) {
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

	public static class Binary_opContext extends ParserRuleContext {
		public TerminalNode DIVISION() { return getToken(WACCParser.DIVISION, 0); }
		public TerminalNode GREATER_EQ() { return getToken(WACCParser.GREATER_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(WACCParser.NOT_EQ, 0); }
		public TerminalNode MODULO() { return getToken(WACCParser.MODULO, 0); }
		public TerminalNode MULTIPLY() { return getToken(WACCParser.MULTIPLY, 0); }
		public TerminalNode SMALLER_EQ() { return getToken(WACCParser.SMALLER_EQ, 0); }
		public TerminalNode OR() { return getToken(WACCParser.OR, 0); }
		public TerminalNode GREATER() { return getToken(WACCParser.GREATER, 0); }
		public TerminalNode AND() { return getToken(WACCParser.AND, 0); }
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public TerminalNode EQ() { return getToken(WACCParser.EQ, 0); }
		public TerminalNode SMALLER() { return getToken(WACCParser.SMALLER, 0); }
		public Binary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitBinary_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_opContext binary_op() throws RecognitionException {
		Binary_opContext _localctx = new Binary_opContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << MULTIPLY) | (1L << DIVISION) | (1L << MODULO) | (1L << PLUS) | (1L << GREATER) | (1L << GREATER_EQ) | (1L << SMALLER) | (1L << SMALLER_EQ) | (1L << EQ) | (1L << NOT_EQ) | (1L << AND) | (1L << OR))) != 0)) ) {
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

	public static class Array_elemContext extends ParserRuleContext {
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
		public Array_elemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_elem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArray_elem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_elemContext array_elem() throws RecognitionException {
		Array_elemContext _localctx = new Array_elemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(IDENT);
			setState(223); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(219); match(OPEN_SQUARE_BRACKET);
					setState(220); expr(0);
					setState(221); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(225); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class Array_literalContext extends ParserRuleContext {
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
		public Array_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArray_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literalContext array_literal() throws RecognitionException {
		Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227); match(OPEN_SQUARE_BRACKET);
			setState(236);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PARENTHESES) | (1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << IDENT) | (1L << INT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << PAIR_LITERAL))) != 0)) {
				{
				setState(228); expr(0);
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(229); match(COMMA);
					setState(230); expr(0);
					}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(238); match(CLOSE_SQUARE_BRACKET);
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
		case 4: return stat_sempred((StatContext)_localctx, predIndex);
		case 9: return type_sempred((TypeContext)_localctx, predIndex);
		case 13: return expr_sempred((ExprContext)_localctx, predIndex);
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
		case 2: return precpred(_ctx, 2);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u00f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\5\3\66\n\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4@\n\4\f\4\16\4C\13"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6\3\6\7\6v\n\6\f"+
		"\6\16\6y\13\6\3\7\3\7\3\7\5\7~\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u008e\n\b\3\b\5\b\u0091\n\b\3\t\3\t\3\t\7\t\u0096"+
		"\n\t\f\t\16\t\u0099\13\t\3\n\3\n\3\n\3\n\5\n\u009f\n\n\3\13\3\13\3\13"+
		"\5\13\u00a4\n\13\3\13\3\13\3\13\7\13\u00a9\n\13\f\13\16\13\u00ac\13\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00bd\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00ce\n\17\3\17\3\17\3\17\3\17\7\17\u00d4\n\17\f"+
		"\17\16\17\u00d7\13\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\6\22"+
		"\u00e2\n\22\r\22\16\22\u00e3\3\23\3\23\3\23\3\23\7\23\u00ea\n\23\f\23"+
		"\16\23\u00ed\13\23\5\23\u00ef\n\23\3\23\3\23\3\23\2\5\n\24\34\24\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\5\3\2\36!\3\2&*\4\2\'\'+\66\u0108"+
		"\2&\3\2\2\2\4\61\3\2\2\2\6<\3\2\2\2\bD\3\2\2\2\np\3\2\2\2\f}\3\2\2\2\16"+
		"\u0090\3\2\2\2\20\u0092\3\2\2\2\22\u009e\3\2\2\2\24\u00a3\3\2\2\2\26\u00ad"+
		"\3\2\2\2\30\u00af\3\2\2\2\32\u00bc\3\2\2\2\34\u00cd\3\2\2\2\36\u00d8\3"+
		"\2\2\2 \u00da\3\2\2\2\"\u00dc\3\2\2\2$\u00e5\3\2\2\2&*\7\33\2\2\')\5\4"+
		"\3\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\5"+
		"\n\6\2./\7\34\2\2/\60\7\2\2\3\60\3\3\2\2\2\61\62\5\24\13\2\62\63\7\67"+
		"\2\2\63\65\7\5\2\2\64\66\5\6\4\2\65\64\3\2\2\2\65\66\3\2\2\2\66\67\3\2"+
		"\2\2\678\7\6\2\289\7\t\2\29:\5\n\6\2:;\7\34\2\2;\5\3\2\2\2<A\5\b\5\2="+
		">\7\n\2\2>@\5\b\5\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2"+
		"CA\3\2\2\2DE\5\24\13\2EF\7\67\2\2F\t\3\2\2\2GH\b\6\1\2Hq\7\f\2\2IJ\5\24"+
		"\13\2JK\7\67\2\2KL\7\r\2\2LM\5\16\b\2Mq\3\2\2\2NO\5\f\7\2OP\7\r\2\2PQ"+
		"\5\16\b\2Qq\3\2\2\2RS\7\16\2\2Sq\5\f\7\2TU\7\17\2\2Uq\5\34\17\2VW\7\20"+
		"\2\2Wq\5\34\17\2XY\7\21\2\2Yq\5\34\17\2Z[\7\22\2\2[q\5\34\17\2\\]\7\23"+
		"\2\2]q\5\34\17\2^_\7\24\2\2_`\5\34\17\2`a\7\25\2\2ab\5\n\6\2bc\7\26\2"+
		"\2cd\5\n\6\2de\7\27\2\2eq\3\2\2\2fg\7\30\2\2gh\5\34\17\2hi\7\31\2\2ij"+
		"\5\n\6\2jk\7\32\2\2kq\3\2\2\2lm\7\33\2\2mn\5\n\6\2no\7\34\2\2oq\3\2\2"+
		"\2pG\3\2\2\2pI\3\2\2\2pN\3\2\2\2pR\3\2\2\2pT\3\2\2\2pV\3\2\2\2pX\3\2\2"+
		"\2pZ\3\2\2\2p\\\3\2\2\2p^\3\2\2\2pf\3\2\2\2pl\3\2\2\2qw\3\2\2\2rs\f\3"+
		"\2\2st\7\35\2\2tv\5\n\6\4ur\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\13"+
		"\3\2\2\2yw\3\2\2\2z~\7\67\2\2{~\5\"\22\2|~\5\22\n\2}z\3\2\2\2}{\3\2\2"+
		"\2}|\3\2\2\2~\r\3\2\2\2\177\u0091\5\34\17\2\u0080\u0091\5$\23\2\u0081"+
		"\u0082\7\"\2\2\u0082\u0083\7\5\2\2\u0083\u0084\5\34\17\2\u0084\u0085\7"+
		"\n\2\2\u0085\u0086\5\34\17\2\u0086\u0087\7\6\2\2\u0087\u0091\3\2\2\2\u0088"+
		"\u0091\5\22\n\2\u0089\u008a\7\13\2\2\u008a\u008b\7\67\2\2\u008b\u008d"+
		"\7\5\2\2\u008c\u008e\5\20\t\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u0091\7\6\2\2\u0090\177\3\2\2\2\u0090\u0080"+
		"\3\2\2\2\u0090\u0081\3\2\2\2\u0090\u0088\3\2\2\2\u0090\u0089\3\2\2\2\u0091"+
		"\17\3\2\2\2\u0092\u0097\5\34\17\2\u0093\u0094\7\n\2\2\u0094\u0096\5\34"+
		"\17\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\21\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\7$\2\2"+
		"\u009b\u009f\5\34\17\2\u009c\u009d\7%\2\2\u009d\u009f\5\34\17\2\u009e"+
		"\u009a\3\2\2\2\u009e\u009c\3\2\2\2\u009f\23\3\2\2\2\u00a0\u00a1\b\13\1"+
		"\2\u00a1\u00a4\5\26\f\2\u00a2\u00a4\5\30\r\2\u00a3\u00a0\3\2\2\2\u00a3"+
		"\u00a2\3\2\2\2\u00a4\u00aa\3\2\2\2\u00a5\u00a6\f\4\2\2\u00a6\u00a7\7\7"+
		"\2\2\u00a7\u00a9\7\b\2\2\u00a8\u00a5\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac\u00aa\3\2\2"+
		"\2\u00ad\u00ae\t\2\2\2\u00ae\27\3\2\2\2\u00af\u00b0\7#\2\2\u00b0\u00b1"+
		"\7\5\2\2\u00b1\u00b2\5\32\16\2\u00b2\u00b3\7\n\2\2\u00b3\u00b4\5\32\16"+
		"\2\u00b4\u00b5\7\6\2\2\u00b5\31\3\2\2\2\u00b6\u00bd\5\26\f\2\u00b7\u00b8"+
		"\5\24\13\2\u00b8\u00b9\7\7\2\2\u00b9\u00ba\7\b\2\2\u00ba\u00bd\3\2\2\2"+
		"\u00bb\u00bd\7#\2\2\u00bc\u00b6\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\33\3\2\2\2\u00be\u00bf\b\17\1\2\u00bf\u00c0\5\36\20\2\u00c0"+
		"\u00c1\5\34\17\5\u00c1\u00ce\3\2\2\2\u00c2\u00ce\78\2\2\u00c3\u00ce\7"+
		"9\2\2\u00c4\u00ce\7:\2\2\u00c5\u00ce\7;\2\2\u00c6\u00ce\7<\2\2\u00c7\u00ce"+
		"\7\67\2\2\u00c8\u00ce\5\"\22\2\u00c9\u00ca\7\5\2\2\u00ca\u00cb\5\34\17"+
		"\2\u00cb\u00cc\7\6\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00be\3\2\2\2\u00cd\u00c2"+
		"\3\2\2\2\u00cd\u00c3\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd"+
		"\u00c6\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2"+
		"\2\2\u00ce\u00d5\3\2\2\2\u00cf\u00d0\f\4\2\2\u00d0\u00d1\5 \21\2\u00d1"+
		"\u00d2\5\34\17\5\u00d2\u00d4\3\2\2\2\u00d3\u00cf\3\2\2\2\u00d4\u00d7\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\35\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d9\t\3\2\2\u00d9\37\3\2\2\2\u00da\u00db\t\4\2"+
		"\2\u00db!\3\2\2\2\u00dc\u00e1\7\67\2\2\u00dd\u00de\7\7\2\2\u00de\u00df"+
		"\5\34\17\2\u00df\u00e0\7\b\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00dd\3\2\2\2"+
		"\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4#\3"+
		"\2\2\2\u00e5\u00ee\7\7\2\2\u00e6\u00eb\5\34\17\2\u00e7\u00e8\7\n\2\2\u00e8"+
		"\u00ea\5\34\17\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee"+
		"\u00e6\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\7\b"+
		"\2\2\u00f1%\3\2\2\2\24*\65Apw}\u008d\u0090\u0097\u009e\u00a3\u00aa\u00bc"+
		"\u00cd\u00d5\u00e3\u00eb\u00ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}