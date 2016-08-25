// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Pyraminx.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.pyraminx;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PyraminxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PYRAMINX_FULL_PLANE=1, PYRAMINX_TIP_PLANE=2, PYRAMINX_MODIFIER=3, COMM_BR_OPEN=4, 
		COMM_COMMA=5, COMM_BR_CLOSE=6, COMM_SEMI_COLON=7, WHITESPACE=8;
	public static final int
		RULE_pyraminx = 0, RULE_pyraminxAlg = 1, RULE_pyraminxSimple = 2, RULE_pyraminxMove = 3, 
		RULE_pyraminxFullMove = 4, RULE_pyraminxTipMove = 5, RULE_pyraminxComm = 6, 
		RULE_pyraminxPureComm = 7, RULE_pyraminxSetupComm = 8;
	public static final String[] ruleNames = {
		"pyraminx", "pyraminxAlg", "pyraminxSimple", "pyraminxMove", "pyraminxFullMove", 
		"pyraminxTipMove", "pyraminxComm", "pyraminxPureComm", "pyraminxSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'''", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PYRAMINX_FULL_PLANE", "PYRAMINX_TIP_PLANE", "PYRAMINX_MODIFIER", 
		"COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", "COMM_SEMI_COLON", "WHITESPACE"
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
	public String getGrammarFileName() { return "Pyraminx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PyraminxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PyraminxContext extends ParserRuleContext {
		public PyraminxAlgContext pyraminxAlg() {
			return getRuleContext(PyraminxAlgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PyraminxParser.EOF, 0); }
		public PyraminxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminx; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxContext pyraminx() throws RecognitionException {
		PyraminxContext _localctx = new PyraminxContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pyraminx);
		try {
			setState(20);
			switch (_input.LA(1)) {
			case PYRAMINX_FULL_PLANE:
			case PYRAMINX_TIP_PLANE:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				pyraminxAlg();
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

	public static class PyraminxAlgContext extends ParserRuleContext {
		public PyraminxSimpleContext pyraminxSimple() {
			return getRuleContext(PyraminxSimpleContext.class,0);
		}
		public PyraminxCommContext pyraminxComm() {
			return getRuleContext(PyraminxCommContext.class,0);
		}
		public PyraminxAlgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxAlg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxAlg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxAlgContext pyraminxAlg() throws RecognitionException {
		PyraminxAlgContext _localctx = new PyraminxAlgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pyraminxAlg);
		try {
			setState(24);
			switch (_input.LA(1)) {
			case PYRAMINX_FULL_PLANE:
			case PYRAMINX_TIP_PLANE:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				pyraminxSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
				pyraminxComm();
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

	public static class PyraminxSimpleContext extends ParserRuleContext {
		public List<PyraminxMoveContext> pyraminxMove() {
			return getRuleContexts(PyraminxMoveContext.class);
		}
		public PyraminxMoveContext pyraminxMove(int i) {
			return getRuleContext(PyraminxMoveContext.class,i);
		}
		public PyraminxSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxSimpleContext pyraminxSimple() throws RecognitionException {
		PyraminxSimpleContext _localctx = new PyraminxSimpleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pyraminxSimple);
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
				pyraminxMove();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PYRAMINX_FULL_PLANE || _la==PYRAMINX_TIP_PLANE );
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

	public static class PyraminxMoveContext extends ParserRuleContext {
		public PyraminxFullMoveContext pyraminxFullMove() {
			return getRuleContext(PyraminxFullMoveContext.class,0);
		}
		public PyraminxTipMoveContext pyraminxTipMove() {
			return getRuleContext(PyraminxTipMoveContext.class,0);
		}
		public PyraminxMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxMoveContext pyraminxMove() throws RecognitionException {
		PyraminxMoveContext _localctx = new PyraminxMoveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pyraminxMove);
		try {
			setState(33);
			switch (_input.LA(1)) {
			case PYRAMINX_FULL_PLANE:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				pyraminxFullMove();
				}
				break;
			case PYRAMINX_TIP_PLANE:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				pyraminxTipMove();
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

	public static class PyraminxFullMoveContext extends ParserRuleContext {
		public TerminalNode PYRAMINX_FULL_PLANE() { return getToken(PyraminxParser.PYRAMINX_FULL_PLANE, 0); }
		public TerminalNode PYRAMINX_MODIFIER() { return getToken(PyraminxParser.PYRAMINX_MODIFIER, 0); }
		public PyraminxFullMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxFullMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxFullMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxFullMoveContext pyraminxFullMove() throws RecognitionException {
		PyraminxFullMoveContext _localctx = new PyraminxFullMoveContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pyraminxFullMove);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(PYRAMINX_FULL_PLANE);
			setState(37);
			_la = _input.LA(1);
			if (_la==PYRAMINX_MODIFIER) {
				{
				setState(36);
				match(PYRAMINX_MODIFIER);
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

	public static class PyraminxTipMoveContext extends ParserRuleContext {
		public TerminalNode PYRAMINX_TIP_PLANE() { return getToken(PyraminxParser.PYRAMINX_TIP_PLANE, 0); }
		public TerminalNode PYRAMINX_MODIFIER() { return getToken(PyraminxParser.PYRAMINX_MODIFIER, 0); }
		public PyraminxTipMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxTipMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxTipMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxTipMoveContext pyraminxTipMove() throws RecognitionException {
		PyraminxTipMoveContext _localctx = new PyraminxTipMoveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pyraminxTipMove);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(PYRAMINX_TIP_PLANE);
			setState(41);
			_la = _input.LA(1);
			if (_la==PYRAMINX_MODIFIER) {
				{
				setState(40);
				match(PYRAMINX_MODIFIER);
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

	public static class PyraminxCommContext extends ParserRuleContext {
		public PyraminxPureCommContext pyraminxPureComm() {
			return getRuleContext(PyraminxPureCommContext.class,0);
		}
		public PyraminxSetupCommContext pyraminxSetupComm() {
			return getRuleContext(PyraminxSetupCommContext.class,0);
		}
		public PyraminxCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxCommContext pyraminxComm() throws RecognitionException {
		PyraminxCommContext _localctx = new PyraminxCommContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pyraminxComm);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				pyraminxPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				pyraminxSetupComm();
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

	public static class PyraminxPureCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(PyraminxParser.COMM_BR_OPEN, 0); }
		public List<PyraminxAlgContext> pyraminxAlg() {
			return getRuleContexts(PyraminxAlgContext.class);
		}
		public PyraminxAlgContext pyraminxAlg(int i) {
			return getRuleContext(PyraminxAlgContext.class,i);
		}
		public TerminalNode COMM_COMMA() { return getToken(PyraminxParser.COMM_COMMA, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(PyraminxParser.COMM_BR_CLOSE, 0); }
		public PyraminxPureCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxPureComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxPureComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxPureCommContext pyraminxPureComm() throws RecognitionException {
		PyraminxPureCommContext _localctx = new PyraminxPureCommContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pyraminxPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(COMM_BR_OPEN);
			setState(48);
			pyraminxAlg();
			setState(49);
			match(COMM_COMMA);
			setState(50);
			pyraminxAlg();
			setState(51);
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

	public static class PyraminxSetupCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(PyraminxParser.COMM_BR_OPEN, 0); }
		public List<PyraminxAlgContext> pyraminxAlg() {
			return getRuleContexts(PyraminxAlgContext.class);
		}
		public PyraminxAlgContext pyraminxAlg(int i) {
			return getRuleContext(PyraminxAlgContext.class,i);
		}
		public TerminalNode COMM_SEMI_COLON() { return getToken(PyraminxParser.COMM_SEMI_COLON, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(PyraminxParser.COMM_BR_CLOSE, 0); }
		public PyraminxSetupCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pyraminxSetupComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PyraminxVisitor ) return ((PyraminxVisitor<? extends T>)visitor).visitPyraminxSetupComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PyraminxSetupCommContext pyraminxSetupComm() throws RecognitionException {
		PyraminxSetupCommContext _localctx = new PyraminxSetupCommContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pyraminxSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(COMM_BR_OPEN);
			setState(54);
			pyraminxAlg();
			setState(55);
			match(COMM_SEMI_COLON);
			setState(56);
			pyraminxAlg();
			setState(57);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\5\2"+
		"\27\n\2\3\3\3\3\5\3\33\n\3\3\4\6\4\36\n\4\r\4\16\4\37\3\5\3\5\5\5$\n\5"+
		"\3\6\3\6\5\6(\n\6\3\7\3\7\5\7,\n\7\3\b\3\b\5\b\60\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2;"+
		"\2\26\3\2\2\2\4\32\3\2\2\2\6\35\3\2\2\2\b#\3\2\2\2\n%\3\2\2\2\f)\3\2\2"+
		"\2\16/\3\2\2\2\20\61\3\2\2\2\22\67\3\2\2\2\24\27\5\4\3\2\25\27\7\2\2\3"+
		"\26\24\3\2\2\2\26\25\3\2\2\2\27\3\3\2\2\2\30\33\5\6\4\2\31\33\5\16\b\2"+
		"\32\30\3\2\2\2\32\31\3\2\2\2\33\5\3\2\2\2\34\36\5\b\5\2\35\34\3\2\2\2"+
		"\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \7\3\2\2\2!$\5\n\6\2\"$\5\f\7"+
		"\2#!\3\2\2\2#\"\3\2\2\2$\t\3\2\2\2%\'\7\3\2\2&(\7\5\2\2\'&\3\2\2\2\'("+
		"\3\2\2\2(\13\3\2\2\2)+\7\4\2\2*,\7\5\2\2+*\3\2\2\2+,\3\2\2\2,\r\3\2\2"+
		"\2-\60\5\20\t\2.\60\5\22\n\2/-\3\2\2\2/.\3\2\2\2\60\17\3\2\2\2\61\62\7"+
		"\6\2\2\62\63\5\4\3\2\63\64\7\7\2\2\64\65\5\4\3\2\65\66\7\b\2\2\66\21\3"+
		"\2\2\2\678\7\6\2\289\5\4\3\29:\7\t\2\2:;\5\4\3\2;<\7\b\2\2<\23\3\2\2\2"+
		"\t\26\32\37#\'+/";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}