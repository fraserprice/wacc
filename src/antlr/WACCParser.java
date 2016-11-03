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
		RULE_pair_elem_type = 12, RULE_expr = 13, RULE_arithmetic_expr = 14, RULE_term = 15, 
		RULE_factor = 16, RULE_unary_op = 17, RULE_binary_op = 18, RULE_arith_op = 19, 
		RULE_array_elem = 20, RULE_array_literal = 21;
	public static final String[] ruleNames = {
		"program", "func", "param_list", "param", "stat", "assign_lhs", "assign_rhs", 
		"arg_list", "pair_elem", "type", "base_type", "pair_type", "pair_elem_type", 
		"expr", "arithmetic_expr", "term", "factor", "unary_op", "binary_op", 
		"arith_op", "array_elem", "array_literal"
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
			setState(44); match(BEGIN_STAT);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(45); func();
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(51); stat(0);
			setState(52); match(END_STAT);
			setState(53); match(EOF);
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
			setState(55); type(0);
			setState(56); match(IDENT);
			setState(57); match(OPEN_PARENTHESES);
			setState(59);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << CHAR) | (1L << STRING) | (1L << PAIR))) != 0)) {
				{
				setState(58); param_list();
				}
			}

			setState(61); match(CLOSE_PARENTHESES);
			setState(62); match(IS);
			setState(63); stat(0);
			setState(64); match(END_STAT);
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
			setState(66); param();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(67); match(COMMA);
				setState(68); param();
				}
				}
				setState(73);
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
			setState(74); type(0);
			setState(75); match(IDENT);
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
			setState(118);
			switch (_input.LA(1)) {
			case SKIP_STAT:
				{
				setState(78); match(SKIP_STAT);
				}
				break;
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
			case PAIR:
				{
				setState(79); type(0);
				setState(80); match(IDENT);
				setState(81); match(ASSIGN_STAT);
				setState(82); assign_rhs();
				}
				break;
			case FST:
			case SND:
			case IDENT:
				{
				setState(84); assign_lhs();
				setState(85); match(ASSIGN_STAT);
				setState(86); assign_rhs();
				}
				break;
			case READ_STAT:
				{
				setState(88); match(READ_STAT);
				setState(89); assign_lhs();
				}
				break;
			case FREE_STAT:
				{
				setState(90); match(FREE_STAT);
				setState(91); expr(0);
				}
				break;
			case RETURN_STAT:
				{
				setState(92); match(RETURN_STAT);
				setState(93); expr(0);
				}
				break;
			case EXIT_STAT:
				{
				setState(94); match(EXIT_STAT);
				setState(95); expr(0);
				}
				break;
			case PRINT_STAT:
				{
				setState(96); match(PRINT_STAT);
				setState(97); expr(0);
				}
				break;
			case PRINTLN_STAT:
				{
				setState(98); match(PRINTLN_STAT);
				setState(99); expr(0);
				}
				break;
			case IF_STAT:
				{
				setState(100); match(IF_STAT);
				setState(101); expr(0);
				setState(102); match(THEN_STAT);
				setState(103); stat(0);
				setState(104); match(ELSE_STAT);
				setState(105); stat(0);
				setState(106); match(FI_STAT);
				}
				break;
			case WHILE_STAT:
				{
				setState(108); match(WHILE_STAT);
				setState(109); expr(0);
				setState(110); match(DO_STAT);
				setState(111); stat(0);
				setState(112); match(DONE_STAT);
				}
				break;
			case BEGIN_STAT:
				{
				setState(114); match(BEGIN_STAT);
				setState(115); stat(0);
				setState(116); match(END_STAT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(125);
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
					setState(120);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(121); match(COMPOSITION_STAT);
					setState(122); stat(2);
					}
					} 
				}
				setState(127);
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
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); array_elem();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); pair_elem();
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
			setState(150);
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
				setState(133); expr(0);
				}
				break;
			case OPEN_SQUARE_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); array_literal();
				}
				break;
			case NEWPAIR:
				enterOuterAlt(_localctx, 3);
				{
				setState(135); match(NEWPAIR);
				setState(136); match(OPEN_PARENTHESES);
				setState(137); expr(0);
				setState(138); match(COMMA);
				setState(139); expr(0);
				setState(140); match(CLOSE_PARENTHESES);
				}
				break;
			case FST:
			case SND:
				enterOuterAlt(_localctx, 4);
				{
				setState(142); pair_elem();
				}
				break;
			case CALL_FUNC:
				enterOuterAlt(_localctx, 5);
				{
				setState(143); match(CALL_FUNC);
				setState(144); match(IDENT);
				setState(145); match(OPEN_PARENTHESES);
				setState(147);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PARENTHESES) | (1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << IDENT) | (1L << INT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << PAIR_LITERAL))) != 0)) {
					{
					setState(146); arg_list();
					}
				}

				setState(149); match(CLOSE_PARENTHESES);
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
			setState(152); expr(0);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(153); match(COMMA);
				setState(154); expr(0);
				}
				}
				setState(159);
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
			setState(164);
			switch (_input.LA(1)) {
			case FST:
				enterOuterAlt(_localctx, 1);
				{
				setState(160); match(FST);
				setState(161); expr(0);
				}
				break;
			case SND:
				enterOuterAlt(_localctx, 2);
				{
				setState(162); match(SND);
				setState(163); expr(0);
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
			setState(169);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case CHAR:
			case STRING:
				{
				setState(167); base_type();
				}
				break;
			case PAIR:
				{
				setState(168); pair_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
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
					setState(171);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(172); match(OPEN_SQUARE_BRACKET);
					setState(173); match(CLOSE_SQUARE_BRACKET);
					}
					} 
				}
				setState(178);
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
			setState(179);
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
			setState(181); match(PAIR);
			setState(182); match(OPEN_PARENTHESES);
			setState(183); pair_elem_type();
			setState(184); match(COMMA);
			setState(185); pair_elem_type();
			setState(186); match(CLOSE_PARENTHESES);
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
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188); base_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189); type(0);
				setState(190); match(OPEN_SQUARE_BRACKET);
				setState(191); match(CLOSE_SQUARE_BRACKET);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193); match(PAIR);
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
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
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
			setState(212);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(197); unary_op();
				setState(198); expr(4);
				}
				break;
			case 2:
				{
				setState(200); match(INT_LITERAL);
				}
				break;
			case 3:
				{
				setState(201); match(BOOL_LITERAL);
				}
				break;
			case 4:
				{
				setState(202); match(CHAR_LITERAL);
				}
				break;
			case 5:
				{
				setState(203); match(STR_LITERAL);
				}
				break;
			case 6:
				{
				setState(204); match(PAIR_LITERAL);
				}
				break;
			case 7:
				{
				setState(205); match(IDENT);
				}
				break;
			case 8:
				{
				setState(206); array_elem();
				}
				break;
			case 9:
				{
				setState(207); arithmetic_expr(0);
				}
				break;
			case 10:
				{
				setState(208); match(OPEN_PARENTHESES);
				setState(209); expr(0);
				setState(210); match(CLOSE_PARENTHESES);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(220);
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
					setState(214);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(215); binary_op();
					setState(216); expr(4);
					}
					} 
				}
				setState(222);
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

	public static class Arithmetic_exprContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public Arithmetic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArithmetic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arithmetic_exprContext arithmetic_expr() throws RecognitionException {
		return arithmetic_expr(0);
	}

	private Arithmetic_exprContext arithmetic_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arithmetic_exprContext _localctx = new Arithmetic_exprContext(_ctx, _parentState);
		Arithmetic_exprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_arithmetic_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(224); term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Arithmetic_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_arithmetic_expr);
					setState(226);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(227);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(228); term(0);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public TerminalNode DIVISION() { return getToken(WACCParser.DIVISION, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode MULTIPLY() { return getToken(WACCParser.MULTIPLY, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(235); factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(237);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(238);
					_la = _input.LA(1);
					if ( !(_la==MULTIPLY || _la==DIVISION) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(239); factor();
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode CLOSE_PARENTHESES() { return getToken(WACCParser.CLOSE_PARENTHESES, 0); }
		public Arithmetic_exprContext arithmetic_expr() {
			return getRuleContext(Arithmetic_exprContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(WACCParser.INT_LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(WACCParser.IDENT, 0); }
		public TerminalNode OPEN_PARENTHESES() { return getToken(WACCParser.OPEN_PARENTHESES, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(251);
			switch (_input.LA(1)) {
			case OPEN_PARENTHESES:
				enterOuterAlt(_localctx, 1);
				{
				setState(245); match(OPEN_PARENTHESES);
				setState(246); arithmetic_expr(0);
				setState(247); match(CLOSE_PARENTHESES);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(249); match(IDENT);
				}
				break;
			case INT_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(250); match(INT_LITERAL);
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
		enterRule(_localctx, 34, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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
		public TerminalNode GREATER_EQ() { return getToken(WACCParser.GREATER_EQ, 0); }
		public TerminalNode NOT_EQ() { return getToken(WACCParser.NOT_EQ, 0); }
		public TerminalNode MODULO() { return getToken(WACCParser.MODULO, 0); }
		public TerminalNode AND() { return getToken(WACCParser.AND, 0); }
		public TerminalNode EQ() { return getToken(WACCParser.EQ, 0); }
		public TerminalNode SMALLER_EQ() { return getToken(WACCParser.SMALLER_EQ, 0); }
		public TerminalNode OR() { return getToken(WACCParser.OR, 0); }
		public TerminalNode GREATER() { return getToken(WACCParser.GREATER, 0); }
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
		enterRule(_localctx, 36, RULE_binary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MODULO) | (1L << GREATER) | (1L << GREATER_EQ) | (1L << SMALLER) | (1L << SMALLER_EQ) | (1L << EQ) | (1L << NOT_EQ) | (1L << AND) | (1L << OR))) != 0)) ) {
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

	public static class Arith_opContext extends ParserRuleContext {
		public TerminalNode DIVISION() { return getToken(WACCParser.DIVISION, 0); }
		public TerminalNode MULTIPLY() { return getToken(WACCParser.MULTIPLY, 0); }
		public TerminalNode PLUS() { return getToken(WACCParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(WACCParser.MINUS, 0); }
		public Arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WACCParserVisitor ) return ((WACCParserVisitor<? extends T>)visitor).visitArith_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_opContext arith_op() throws RecognitionException {
		Arith_opContext _localctx = new Arith_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << MULTIPLY) | (1L << DIVISION) | (1L << PLUS))) != 0)) ) {
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
		enterRule(_localctx, 40, RULE_array_elem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(IDENT);
			setState(264); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(260); match(OPEN_SQUARE_BRACKET);
					setState(261); expr(0);
					setState(262); match(CLOSE_SQUARE_BRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(266); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 42, RULE_array_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); match(OPEN_SQUARE_BRACKET);
			setState(277);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN_PARENTHESES) | (1L << NOT) | (1L << MINUS) | (1L << LEN) | (1L << ORD) | (1L << CHR) | (1L << IDENT) | (1L << INT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << PAIR_LITERAL))) != 0)) {
				{
				setState(269); expr(0);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(270); match(COMMA);
					setState(271); expr(0);
					}
					}
					setState(276);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(279); match(CLOSE_SQUARE_BRACKET);
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
		case 14: return arithmetic_expr_sempred((Arithmetic_exprContext)_localctx, predIndex);
		case 15: return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stat_sempred(StatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arithmetic_expr_sempred(Arithmetic_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return precpred(_ctx, 2);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u011c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\7\2\61\n\2"+
		"\f\2\16\2\64\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\7\4H\n\4\f\4\16\4K\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6y\n\6\3\6\3\6\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\7\3\7\3"+
		"\7\5\7\u0086\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u0096\n\b\3\b\5\b\u0099\n\b\3\t\3\t\3\t\7\t\u009e\n\t\f\t\16\t"+
		"\u00a1\13\t\3\n\3\n\3\n\3\n\5\n\u00a7\n\n\3\13\3\13\3\13\5\13\u00ac\n"+
		"\13\3\13\3\13\3\13\7\13\u00b1\n\13\f\13\16\13\u00b4\13\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c5\n\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00d7\n\17\3\17\3\17\3\17\3\17\7\17\u00dd\n\17\f\17\16"+
		"\17\u00e0\13\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e8\n\20\f\20\16"+
		"\20\u00eb\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00f3\n\21\f\21\16"+
		"\21\u00f6\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fe\n\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\6\26\u010b\n\26\r\26\16"+
		"\26\u010c\3\27\3\27\3\27\3\27\7\27\u0113\n\27\f\27\16\27\u0116\13\27\5"+
		"\27\u0118\n\27\3\27\3\27\3\27\2\7\n\24\34\36 \30\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,\2\b\3\2\36!\4\2\'\'..\3\2+,\3\2&*\4\2--/\66"+
		"\5\2\'\'+,..\u0132\2.\3\2\2\2\49\3\2\2\2\6D\3\2\2\2\bL\3\2\2\2\nx\3\2"+
		"\2\2\f\u0085\3\2\2\2\16\u0098\3\2\2\2\20\u009a\3\2\2\2\22\u00a6\3\2\2"+
		"\2\24\u00ab\3\2\2\2\26\u00b5\3\2\2\2\30\u00b7\3\2\2\2\32\u00c4\3\2\2\2"+
		"\34\u00d6\3\2\2\2\36\u00e1\3\2\2\2 \u00ec\3\2\2\2\"\u00fd\3\2\2\2$\u00ff"+
		"\3\2\2\2&\u0101\3\2\2\2(\u0103\3\2\2\2*\u0105\3\2\2\2,\u010e\3\2\2\2."+
		"\62\7\33\2\2/\61\5\4\3\2\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\5\n\6\2\66\67\7\34\2\2\678"+
		"\7\2\2\38\3\3\2\2\29:\5\24\13\2:;\7\67\2\2;=\7\5\2\2<>\5\6\4\2=<\3\2\2"+
		"\2=>\3\2\2\2>?\3\2\2\2?@\7\6\2\2@A\7\t\2\2AB\5\n\6\2BC\7\34\2\2C\5\3\2"+
		"\2\2DI\5\b\5\2EF\7\n\2\2FH\5\b\5\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2J\7\3\2\2\2KI\3\2\2\2LM\5\24\13\2MN\7\67\2\2N\t\3\2\2\2OP\b\6\1\2"+
		"Py\7\f\2\2QR\5\24\13\2RS\7\67\2\2ST\7\r\2\2TU\5\16\b\2Uy\3\2\2\2VW\5\f"+
		"\7\2WX\7\r\2\2XY\5\16\b\2Yy\3\2\2\2Z[\7\16\2\2[y\5\f\7\2\\]\7\17\2\2]"+
		"y\5\34\17\2^_\7\20\2\2_y\5\34\17\2`a\7\21\2\2ay\5\34\17\2bc\7\22\2\2c"+
		"y\5\34\17\2de\7\23\2\2ey\5\34\17\2fg\7\24\2\2gh\5\34\17\2hi\7\25\2\2i"+
		"j\5\n\6\2jk\7\26\2\2kl\5\n\6\2lm\7\27\2\2my\3\2\2\2no\7\30\2\2op\5\34"+
		"\17\2pq\7\31\2\2qr\5\n\6\2rs\7\32\2\2sy\3\2\2\2tu\7\33\2\2uv\5\n\6\2v"+
		"w\7\34\2\2wy\3\2\2\2xO\3\2\2\2xQ\3\2\2\2xV\3\2\2\2xZ\3\2\2\2x\\\3\2\2"+
		"\2x^\3\2\2\2x`\3\2\2\2xb\3\2\2\2xd\3\2\2\2xf\3\2\2\2xn\3\2\2\2xt\3\2\2"+
		"\2y\177\3\2\2\2z{\f\3\2\2{|\7\35\2\2|~\5\n\6\4}z\3\2\2\2~\u0081\3\2\2"+
		"\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081\177\3\2\2\2\u0082"+
		"\u0086\7\67\2\2\u0083\u0086\5*\26\2\u0084\u0086\5\22\n\2\u0085\u0082\3"+
		"\2\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\r\3\2\2\2\u0087\u0099"+
		"\5\34\17\2\u0088\u0099\5,\27\2\u0089\u008a\7\"\2\2\u008a\u008b\7\5\2\2"+
		"\u008b\u008c\5\34\17\2\u008c\u008d\7\n\2\2\u008d\u008e\5\34\17\2\u008e"+
		"\u008f\7\6\2\2\u008f\u0099\3\2\2\2\u0090\u0099\5\22\n\2\u0091\u0092\7"+
		"\13\2\2\u0092\u0093\7\67\2\2\u0093\u0095\7\5\2\2\u0094\u0096\5\20\t\2"+
		"\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099"+
		"\7\6\2\2\u0098\u0087\3\2\2\2\u0098\u0088\3\2\2\2\u0098\u0089\3\2\2\2\u0098"+
		"\u0090\3\2\2\2\u0098\u0091\3\2\2\2\u0099\17\3\2\2\2\u009a\u009f\5\34\17"+
		"\2\u009b\u009c\7\n\2\2\u009c\u009e\5\34\17\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\21\3\2\2"+
		"\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\7$\2\2\u00a3\u00a7\5\34\17\2\u00a4"+
		"\u00a5\7%\2\2\u00a5\u00a7\5\34\17\2\u00a6\u00a2\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a7\23\3\2\2\2\u00a8\u00a9\b\13\1\2\u00a9\u00ac\5\26\f\2\u00aa"+
		"\u00ac\5\30\r\2\u00ab\u00a8\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00b2\3"+
		"\2\2\2\u00ad\u00ae\f\4\2\2\u00ae\u00af\7\7\2\2\u00af\u00b1\7\b\2\2\u00b0"+
		"\u00ad\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\25\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6\27"+
		"\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\5\32\16\2"+
		"\u00ba\u00bb\7\n\2\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd\7\6\2\2\u00bd\31"+
		"\3\2\2\2\u00be\u00c5\5\26\f\2\u00bf\u00c0\5\24\13\2\u00c0\u00c1\7\7\2"+
		"\2\u00c1\u00c2\7\b\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c5\7#\2\2\u00c4\u00be"+
		"\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\33\3\2\2\2\u00c6"+
		"\u00c7\b\17\1\2\u00c7\u00c8\5$\23\2\u00c8\u00c9\5\34\17\6\u00c9\u00d7"+
		"\3\2\2\2\u00ca\u00d7\78\2\2\u00cb\u00d7\79\2\2\u00cc\u00d7\7:\2\2\u00cd"+
		"\u00d7\7;\2\2\u00ce\u00d7\7<\2\2\u00cf\u00d7\7\67\2\2\u00d0\u00d7\5*\26"+
		"\2\u00d1\u00d7\5\36\20\2\u00d2\u00d3\7\5\2\2\u00d3\u00d4\5\34\17\2\u00d4"+
		"\u00d5\7\6\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00c6\3\2\2\2\u00d6\u00ca\3\2"+
		"\2\2\u00d6\u00cb\3\2\2\2\u00d6\u00cc\3\2\2\2\u00d6\u00cd\3\2\2\2\u00d6"+
		"\u00ce\3\2\2\2\u00d6\u00cf\3\2\2\2\u00d6\u00d0\3\2\2\2\u00d6\u00d1\3\2"+
		"\2\2\u00d6\u00d2\3\2\2\2\u00d7\u00de\3\2\2\2\u00d8\u00d9\f\5\2\2\u00d9"+
		"\u00da\5&\24\2\u00da\u00db\5\34\17\6\u00db\u00dd\3\2\2\2\u00dc\u00d8\3"+
		"\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\35\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\b\20\1\2\u00e2\u00e3\5 \21"+
		"\2\u00e3\u00e9\3\2\2\2\u00e4\u00e5\f\4\2\2\u00e5\u00e6\t\3\2\2\u00e6\u00e8"+
		"\5 \21\2\u00e7\u00e4\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b\21\1"+
		"\2\u00ed\u00ee\5\"\22\2\u00ee\u00f4\3\2\2\2\u00ef\u00f0\f\4\2\2\u00f0"+
		"\u00f1\t\4\2\2\u00f1\u00f3\5\"\22\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3"+
		"\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5!\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f7\u00f8\7\5\2\2\u00f8\u00f9\5\36\20\2\u00f9\u00fa\7\6\2\2"+
		"\u00fa\u00fe\3\2\2\2\u00fb\u00fe\7\67\2\2\u00fc\u00fe\78\2\2\u00fd\u00f7"+
		"\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe#\3\2\2\2\u00ff"+
		"\u0100\t\5\2\2\u0100%\3\2\2\2\u0101\u0102\t\6\2\2\u0102\'\3\2\2\2\u0103"+
		"\u0104\t\7\2\2\u0104)\3\2\2\2\u0105\u010a\7\67\2\2\u0106\u0107\7\7\2\2"+
		"\u0107\u0108\5\34\17\2\u0108\u0109\7\b\2\2\u0109\u010b\3\2\2\2\u010a\u0106"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"+\3\2\2\2\u010e\u0117\7\7\2\2\u010f\u0114\5\34\17\2\u0110\u0111\7\n\2"+
		"\2\u0111\u0113\5\34\17\2\u0112\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0117\u010f\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011a\7\b\2\2\u011a-\3\2\2\2\27\62=Ix\177\u0085\u0095\u0098\u009f\u00a6"+
		"\u00ab\u00b2\u00c4\u00d6\u00de\u00e9\u00f4\u00fd\u010c\u0114\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}