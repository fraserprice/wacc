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
		DONE_STAT=23, STR_LITERAL=56, PAIR_LITERAL=57, NEWPAIR=31, ELSE_STAT=19, 
		GREATER_EQ=45, PRINTLN_STAT=16, CHR=39, MINUS=36, SMALLER=46, END_STAT=25, 
		CLOSE_SQUARE_BRACKET=5, SKIP_STAT=9, READ_STAT=11, NOT_EQ=49, WHILE_STAT=21, 
		FST=33, MODULO=42, IS=6, EQ=48, BOOL_LITERAL=54, NOT=35, PRINT_STAT=15, 
		FI_STAT=20, AND=50, ASSIGN_STAT=10, MULTIPLY=40, OPEN_SQUARE_BRACKET=4, 
		CHAR_LITERAL=55, BEGIN_STAT=24, CLOSE_PARENTHESES=3, PLUS=43, ORD=38, 
		FREE_STAT=12, OPEN_PARENTHESES=2, LENGTH=37, SND=34, CHAR=29, COMPOSITION_STAT=26, 
		IF_STAT=17, INT=27, DIVISION=41, COMMENT=58, DO_STAT=22, INT_LITERAL=53, 
		WS=1, COMMA=7, OR=51, THEN_STAT=18, GREATER=44, EXIT_STAT=14, IDENT=52, 
		BOOL=28, STRING=30, SMALLER_EQ=47, RETURN_STAT=13, CALL_FUNC=8, PAIR=32;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "'('", "')'", "'['", "']'", "'is'", "','", "'call'", 
		"'skip'", "'='", "'read'", "'free'", "'return'", "'exit'", "'print'", 
		"'println'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'done'", 
		"'begin'", "'end'", "';'", "'int'", "'bool'", "'char'", "'string'", "'newpair'", 
		"'pair'", "'fst'", "'snd'", "'!'", "'-'", "'len'", "'ord'", "'chr'", "'*'", 
		"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'&&'", 
		"'||'", "IDENT", "INT_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STR_LITERAL", 
		"'null'", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_func = 1, RULE_stat = 2;
	public static final String[] ruleNames = {
		"program", "func", "stat"
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6); match(BEGIN_STAT);
			setState(10);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BEGIN_STAT) {
				{
				{
				setState(7); func();
				}
				}
				setState(12);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(13); stat();
			setState(14); match(END_STAT);
			setState(15); match(EOF);
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
		public TerminalNode BEGIN_STAT() { return getToken(WACCParser.BEGIN_STAT, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); match(BEGIN_STAT);
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
		public TerminalNode END_STAT() { return getToken(WACCParser.END_STAT, 0); }
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
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); match(END_STAT);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\30\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\7\2\13\n\2\f\2\16\2\16\13\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\4\2\2\5\2\4\6\2\2\25\2\b\3\2\2\2\4\23\3\2\2\2\6\25\3\2\2\2"+
		"\b\f\7\32\2\2\t\13\5\4\3\2\n\t\3\2\2\2\13\16\3\2\2\2\f\n\3\2\2\2\f\r\3"+
		"\2\2\2\r\17\3\2\2\2\16\f\3\2\2\2\17\20\5\6\4\2\20\21\7\33\2\2\21\22\7"+
		"\2\2\3\22\3\3\2\2\2\23\24\7\32\2\2\24\5\3\2\2\2\25\26\7\33\2\2\26\7\3"+
		"\2\2\2\3\f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}