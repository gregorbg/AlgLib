// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Megaminx.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.megaminx;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MegaminxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MEGAMINX_WIDE_PLANE=1, MEGAMINX_WIDE_MODIFIER=2, MEGAMINX_U_PLANE=3, MEGAMINX_U_MODIFIER=4, 
		COMM_BR_OPEN=5, COMM_COMMA=6, COMM_BR_CLOSE=7, COMM_SEMI_COLON=8, WHITESPACE=9;
	public static final int
		RULE_megaminx = 0, RULE_megaminxAlg = 1, RULE_megaminxSimple = 2, RULE_megaminxMove = 3, 
		RULE_gripMegaminx = 4, RULE_uMegaminx = 5, RULE_megaminxComm = 6, RULE_megaminxPureComm = 7, 
		RULE_megaminxSetupComm = 8;
	public static final String[] ruleNames = {
		"megaminx", "megaminxAlg", "megaminxSimple", "megaminxMove", "gripMegaminx", 
		"uMegaminx", "megaminxComm", "megaminxPureComm", "megaminxSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'U'", "'''", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "MEGAMINX_WIDE_PLANE", "MEGAMINX_WIDE_MODIFIER", "MEGAMINX_U_PLANE", 
		"MEGAMINX_U_MODIFIER", "COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", 
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
	public String getGrammarFileName() { return "Megaminx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MegaminxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MegaminxContext extends ParserRuleContext {
		public MegaminxAlgContext megaminxAlg() {
			return getRuleContext(MegaminxAlgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MegaminxParser.EOF, 0); }
		public MegaminxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxContext megaminx() throws RecognitionException {
		MegaminxContext _localctx = new MegaminxContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_megaminx);
		try {
			setState(20);
			switch (_input.LA(1)) {
			case MEGAMINX_WIDE_PLANE:
			case MEGAMINX_U_PLANE:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				megaminxAlg();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
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

	public static class MegaminxAlgContext extends ParserRuleContext {
		public MegaminxSimpleContext megaminxSimple() {
			return getRuleContext(MegaminxSimpleContext.class,0);
		}
		public MegaminxCommContext megaminxComm() {
			return getRuleContext(MegaminxCommContext.class,0);
		}
		public MegaminxAlgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminxAlg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminxAlg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxAlgContext megaminxAlg() throws RecognitionException {
		MegaminxAlgContext _localctx = new MegaminxAlgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_megaminxAlg);
		try {
			setState(24);
			switch (_input.LA(1)) {
			case MEGAMINX_WIDE_PLANE:
			case MEGAMINX_U_PLANE:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				megaminxSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				megaminxComm();
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

	public static class MegaminxSimpleContext extends ParserRuleContext {
		public List<MegaminxMoveContext> megaminxMove() {
			return getRuleContexts(MegaminxMoveContext.class);
		}
		public MegaminxMoveContext megaminxMove(int i) {
			return getRuleContext(MegaminxMoveContext.class,i);
		}
		public MegaminxSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminxSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminxSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxSimpleContext megaminxSimple() throws RecognitionException {
		MegaminxSimpleContext _localctx = new MegaminxSimpleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_megaminxSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				megaminxMove();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MEGAMINX_WIDE_PLANE || _la==MEGAMINX_U_PLANE );
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

	public static class MegaminxMoveContext extends ParserRuleContext {
		public GripMegaminxContext gripMegaminx() {
			return getRuleContext(GripMegaminxContext.class,0);
		}
		public UMegaminxContext uMegaminx() {
			return getRuleContext(UMegaminxContext.class,0);
		}
		public MegaminxMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminxMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminxMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxMoveContext megaminxMove() throws RecognitionException {
		MegaminxMoveContext _localctx = new MegaminxMoveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_megaminxMove);
		try {
			setState(33);
			switch (_input.LA(1)) {
			case MEGAMINX_WIDE_PLANE:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				gripMegaminx();
				}
				break;
			case MEGAMINX_U_PLANE:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				uMegaminx();
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

	public static class GripMegaminxContext extends ParserRuleContext {
		public TerminalNode MEGAMINX_WIDE_PLANE() { return getToken(MegaminxParser.MEGAMINX_WIDE_PLANE, 0); }
		public TerminalNode MEGAMINX_WIDE_MODIFIER() { return getToken(MegaminxParser.MEGAMINX_WIDE_MODIFIER, 0); }
		public GripMegaminxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gripMegaminx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitGripMegaminx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GripMegaminxContext gripMegaminx() throws RecognitionException {
		GripMegaminxContext _localctx = new GripMegaminxContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gripMegaminx);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(MEGAMINX_WIDE_PLANE);
			setState(36);
			match(MEGAMINX_WIDE_MODIFIER);
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

	public static class UMegaminxContext extends ParserRuleContext {
		public TerminalNode MEGAMINX_U_PLANE() { return getToken(MegaminxParser.MEGAMINX_U_PLANE, 0); }
		public TerminalNode MEGAMINX_U_MODIFIER() { return getToken(MegaminxParser.MEGAMINX_U_MODIFIER, 0); }
		public UMegaminxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uMegaminx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitUMegaminx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UMegaminxContext uMegaminx() throws RecognitionException {
		UMegaminxContext _localctx = new UMegaminxContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_uMegaminx);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(MEGAMINX_U_PLANE);
			setState(40);
			_la = _input.LA(1);
			if (_la==MEGAMINX_U_MODIFIER) {
				{
				setState(39);
				match(MEGAMINX_U_MODIFIER);
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

	public static class MegaminxCommContext extends ParserRuleContext {
		public MegaminxPureCommContext megaminxPureComm() {
			return getRuleContext(MegaminxPureCommContext.class,0);
		}
		public MegaminxSetupCommContext megaminxSetupComm() {
			return getRuleContext(MegaminxSetupCommContext.class,0);
		}
		public MegaminxCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminxComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminxComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxCommContext megaminxComm() throws RecognitionException {
		MegaminxCommContext _localctx = new MegaminxCommContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_megaminxComm);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				megaminxPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				megaminxSetupComm();
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

	public static class MegaminxPureCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(MegaminxParser.COMM_BR_OPEN, 0); }
		public List<MegaminxAlgContext> megaminxAlg() {
			return getRuleContexts(MegaminxAlgContext.class);
		}
		public MegaminxAlgContext megaminxAlg(int i) {
			return getRuleContext(MegaminxAlgContext.class,i);
		}
		public TerminalNode COMM_COMMA() { return getToken(MegaminxParser.COMM_COMMA, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(MegaminxParser.COMM_BR_CLOSE, 0); }
		public MegaminxPureCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminxPureComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminxPureComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxPureCommContext megaminxPureComm() throws RecognitionException {
		MegaminxPureCommContext _localctx = new MegaminxPureCommContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_megaminxPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(COMM_BR_OPEN);
			setState(47);
			megaminxAlg();
			setState(48);
			match(COMM_COMMA);
			setState(49);
			megaminxAlg();
			setState(50);
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

	public static class MegaminxSetupCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(MegaminxParser.COMM_BR_OPEN, 0); }
		public List<MegaminxAlgContext> megaminxAlg() {
			return getRuleContexts(MegaminxAlgContext.class);
		}
		public MegaminxAlgContext megaminxAlg(int i) {
			return getRuleContext(MegaminxAlgContext.class,i);
		}
		public TerminalNode COMM_SEMI_COLON() { return getToken(MegaminxParser.COMM_SEMI_COLON, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(MegaminxParser.COMM_BR_CLOSE, 0); }
		public MegaminxSetupCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_megaminxSetupComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MegaminxVisitor ) return ((MegaminxVisitor<? extends T>)visitor).visitMegaminxSetupComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MegaminxSetupCommContext megaminxSetupComm() throws RecognitionException {
		MegaminxSetupCommContext _localctx = new MegaminxSetupCommContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_megaminxSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(COMM_BR_OPEN);
			setState(53);
			megaminxAlg();
			setState(54);
			match(COMM_SEMI_COLON);
			setState(55);
			megaminxAlg();
			setState(56);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13=\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\5\2"+
		"\27\n\2\3\3\3\3\5\3\33\n\3\3\4\6\4\36\n\4\r\4\16\4\37\3\5\3\5\5\5$\n\5"+
		"\3\6\3\6\3\6\3\7\3\7\5\7+\n\7\3\b\3\b\5\b/\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\29\2\26\3\2"+
		"\2\2\4\32\3\2\2\2\6\35\3\2\2\2\b#\3\2\2\2\n%\3\2\2\2\f(\3\2\2\2\16.\3"+
		"\2\2\2\20\60\3\2\2\2\22\66\3\2\2\2\24\27\5\4\3\2\25\27\7\2\2\3\26\24\3"+
		"\2\2\2\26\25\3\2\2\2\27\3\3\2\2\2\30\33\5\6\4\2\31\33\5\16\b\2\32\30\3"+
		"\2\2\2\32\31\3\2\2\2\33\5\3\2\2\2\34\36\5\b\5\2\35\34\3\2\2\2\36\37\3"+
		"\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \7\3\2\2\2!$\5\n\6\2\"$\5\f\7\2#!\3\2"+
		"\2\2#\"\3\2\2\2$\t\3\2\2\2%&\7\3\2\2&\'\7\4\2\2\'\13\3\2\2\2(*\7\5\2\2"+
		")+\7\6\2\2*)\3\2\2\2*+\3\2\2\2+\r\3\2\2\2,/\5\20\t\2-/\5\22\n\2.,\3\2"+
		"\2\2.-\3\2\2\2/\17\3\2\2\2\60\61\7\7\2\2\61\62\5\4\3\2\62\63\7\b\2\2\63"+
		"\64\5\4\3\2\64\65\7\t\2\2\65\21\3\2\2\2\66\67\7\7\2\2\678\5\4\3\289\7"+
		"\n\2\29:\5\4\3\2:;\7\t\2\2;\23\3\2\2\2\b\26\32\37#*.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}