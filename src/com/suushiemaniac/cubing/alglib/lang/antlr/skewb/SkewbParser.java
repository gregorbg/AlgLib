// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Skewb.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.skewb;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SkewbParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKEWB_PLANE=1, SKEWB_MODIFIER=2, COMM_BR_OPEN=3, COMM_COMMA=4, COMM_BR_CLOSE=5, 
		COMM_SEMI_COLON=6, WHITESPACE=7;
	public static final int
		RULE_skewb = 0, RULE_skewbAlg = 1, RULE_skewbSimple = 2, RULE_skewbMove = 3, 
		RULE_skewbComm = 4, RULE_skewbPureComm = 5, RULE_skewbSetupComm = 6;
	public static final String[] ruleNames = {
		"skewb", "skewbAlg", "skewbSimple", "skewbMove", "skewbComm", "skewbPureComm", 
		"skewbSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'''", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKEWB_PLANE", "SKEWB_MODIFIER", "COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", 
		"COMM_SEMI_COLON", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Skewb.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SkewbParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SkewbContext extends ParserRuleContext {
		public SkewbAlgContext skewbAlg() {
			return getRuleContext(SkewbAlgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SkewbParser.EOF, 0); }
		public SkewbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewb; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbContext skewb() throws RecognitionException {
		SkewbContext _localctx = new SkewbContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_skewb);
		try {
			setState(16);
			switch (_input.LA(1)) {
			case SKEWB_PLANE:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				skewbAlg();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				match(EOF);
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

	public static class SkewbAlgContext extends ParserRuleContext {
		public SkewbSimpleContext skewbSimple() {
			return getRuleContext(SkewbSimpleContext.class,0);
		}
		public SkewbCommContext skewbComm() {
			return getRuleContext(SkewbCommContext.class,0);
		}
		public SkewbAlgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewbAlg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewbAlg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbAlgContext skewbAlg() throws RecognitionException {
		SkewbAlgContext _localctx = new SkewbAlgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_skewbAlg);
		try {
			setState(20);
			switch (_input.LA(1)) {
			case SKEWB_PLANE:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				skewbSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				skewbComm();
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

	public static class SkewbSimpleContext extends ParserRuleContext {
		public List<SkewbMoveContext> skewbMove() {
			return getRuleContexts(SkewbMoveContext.class);
		}
		public SkewbMoveContext skewbMove(int i) {
			return getRuleContext(SkewbMoveContext.class,i);
		}
		public SkewbSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewbSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewbSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbSimpleContext skewbSimple() throws RecognitionException {
		SkewbSimpleContext _localctx = new SkewbSimpleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_skewbSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				skewbMove();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SKEWB_PLANE );
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

	public static class SkewbMoveContext extends ParserRuleContext {
		public TerminalNode SKEWB_PLANE() { return getToken(SkewbParser.SKEWB_PLANE, 0); }
		public TerminalNode SKEWB_MODIFIER() { return getToken(SkewbParser.SKEWB_MODIFIER, 0); }
		public SkewbMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewbMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewbMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbMoveContext skewbMove() throws RecognitionException {
		SkewbMoveContext _localctx = new SkewbMoveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_skewbMove);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(SKEWB_PLANE);
			setState(29);
			_la = _input.LA(1);
			if (_la==SKEWB_MODIFIER) {
				{
				setState(28);
				match(SKEWB_MODIFIER);
				}
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

	public static class SkewbCommContext extends ParserRuleContext {
		public SkewbPureCommContext skewbPureComm() {
			return getRuleContext(SkewbPureCommContext.class,0);
		}
		public SkewbSetupCommContext skewbSetupComm() {
			return getRuleContext(SkewbSetupCommContext.class,0);
		}
		public SkewbCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewbComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewbComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbCommContext skewbComm() throws RecognitionException {
		SkewbCommContext _localctx = new SkewbCommContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_skewbComm);
		try {
			setState(33);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				skewbPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				skewbSetupComm();
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

	public static class SkewbPureCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(SkewbParser.COMM_BR_OPEN, 0); }
		public List<SkewbAlgContext> skewbAlg() {
			return getRuleContexts(SkewbAlgContext.class);
		}
		public SkewbAlgContext skewbAlg(int i) {
			return getRuleContext(SkewbAlgContext.class,i);
		}
		public TerminalNode COMM_COMMA() { return getToken(SkewbParser.COMM_COMMA, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(SkewbParser.COMM_BR_CLOSE, 0); }
		public SkewbPureCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewbPureComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewbPureComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbPureCommContext skewbPureComm() throws RecognitionException {
		SkewbPureCommContext _localctx = new SkewbPureCommContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_skewbPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(COMM_BR_OPEN);
			setState(36);
			skewbAlg();
			setState(37);
			match(COMM_COMMA);
			setState(38);
			skewbAlg();
			setState(39);
			match(COMM_BR_CLOSE);
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

	public static class SkewbSetupCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(SkewbParser.COMM_BR_OPEN, 0); }
		public List<SkewbAlgContext> skewbAlg() {
			return getRuleContexts(SkewbAlgContext.class);
		}
		public SkewbAlgContext skewbAlg(int i) {
			return getRuleContext(SkewbAlgContext.class,i);
		}
		public TerminalNode COMM_SEMI_COLON() { return getToken(SkewbParser.COMM_SEMI_COLON, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(SkewbParser.COMM_BR_CLOSE, 0); }
		public SkewbSetupCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewbSetupComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SkewbVisitor ) return ((SkewbVisitor<? extends T>)visitor).visitSkewbSetupComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewbSetupCommContext skewbSetupComm() throws RecognitionException {
		SkewbSetupCommContext _localctx = new SkewbSetupCommContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_skewbSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(COMM_BR_OPEN);
			setState(42);
			skewbAlg();
			setState(43);
			match(COMM_SEMI_COLON);
			setState(44);
			skewbAlg();
			setState(45);
			match(COMM_BR_CLOSE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\5\2\23\n\2\3\3\3"+
		"\3\5\3\27\n\3\3\4\6\4\32\n\4\r\4\16\4\33\3\5\3\5\5\5 \n\5\3\6\3\6\5\6"+
		"$\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\2\2\t\2\4\6"+
		"\b\n\f\16\2\2/\2\22\3\2\2\2\4\26\3\2\2\2\6\31\3\2\2\2\b\35\3\2\2\2\n#"+
		"\3\2\2\2\f%\3\2\2\2\16+\3\2\2\2\20\23\5\4\3\2\21\23\7\2\2\3\22\20\3\2"+
		"\2\2\22\21\3\2\2\2\23\3\3\2\2\2\24\27\5\6\4\2\25\27\5\n\6\2\26\24\3\2"+
		"\2\2\26\25\3\2\2\2\27\5\3\2\2\2\30\32\5\b\5\2\31\30\3\2\2\2\32\33\3\2"+
		"\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\7\3\2\2\2\35\37\7\3\2\2\36 \7\4\2"+
		"\2\37\36\3\2\2\2\37 \3\2\2\2 \t\3\2\2\2!$\5\f\7\2\"$\5\16\b\2#!\3\2\2"+
		"\2#\"\3\2\2\2$\13\3\2\2\2%&\7\5\2\2&\'\5\4\3\2\'(\7\6\2\2()\5\4\3\2)*"+
		"\7\7\2\2*\r\3\2\2\2+,\7\5\2\2,-\5\4\3\2-.\7\b\2\2./\5\4\3\2/\60\7\7\2"+
		"\2\60\17\3\2\2\2\7\22\26\33\37#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}