// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/SquareOne.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.squareone;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SquareOneParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SQUARE_ONE_SLASH=1, SQUARE_ONE_BR_OPEN=2, SQUARE_ONE_PLANE_ZERO=3, SQUARE_ONE_COMMA=4, 
		SQUARE_ONE_BR_CLOSE=5, SQUARE_ONE_PLANE_POS=6, SQUARE_ONE_DIRECTION_MODIFIER=7, 
		COMM_BR_OPEN=8, COMM_COMMA=9, COMM_BR_CLOSE=10, COMM_SEMI_COLON=11, WHITESPACE=12;
	public static final int
		RULE_squareOne = 0, RULE_squareOneAlg = 1, RULE_squareOneSimple = 2, RULE_squareOneBeginSlash = 3, 
		RULE_squareOneMoveSlash = 4, RULE_squareOneModifier = 5, RULE_squareOneFaceTurn = 6, 
		RULE_squareOneComm = 7, RULE_squareOnePureComm = 8, RULE_squareOneSetupComm = 9;
	public static final String[] ruleNames = {
		"squareOne", "squareOneAlg", "squareOneSimple", "squareOneBeginSlash", 
		"squareOneMoveSlash", "squareOneModifier", "squareOneFaceTurn", "squareOneComm", 
		"squareOnePureComm", "squareOneSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'/'", "'('", "'0'", null, "')'", null, "'-'", "'['", null, "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SQUARE_ONE_SLASH", "SQUARE_ONE_BR_OPEN", "SQUARE_ONE_PLANE_ZERO", 
		"SQUARE_ONE_COMMA", "SQUARE_ONE_BR_CLOSE", "SQUARE_ONE_PLANE_POS", "SQUARE_ONE_DIRECTION_MODIFIER", 
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
	public String getGrammarFileName() { return "SquareOne.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SquareOneParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SquareOneContext extends ParserRuleContext {
		public SquareOneAlgContext squareOneAlg() {
			return getRuleContext(SquareOneAlgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SquareOneParser.EOF, 0); }
		public SquareOneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOne; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneContext squareOne() throws RecognitionException {
		SquareOneContext _localctx = new SquareOneContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_squareOne);
		try {
			setState(22);
			switch (_input.LA(1)) {
			case SQUARE_ONE_SLASH:
			case SQUARE_ONE_BR_OPEN:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				squareOneAlg();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
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

	public static class SquareOneAlgContext extends ParserRuleContext {
		public SquareOneSimpleContext squareOneSimple() {
			return getRuleContext(SquareOneSimpleContext.class,0);
		}
		public SquareOneCommContext squareOneComm() {
			return getRuleContext(SquareOneCommContext.class,0);
		}
		public SquareOneAlgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneAlg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneAlg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneAlgContext squareOneAlg() throws RecognitionException {
		SquareOneAlgContext _localctx = new SquareOneAlgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_squareOneAlg);
		try {
			setState(26);
			switch (_input.LA(1)) {
			case SQUARE_ONE_SLASH:
			case SQUARE_ONE_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				squareOneSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				squareOneComm();
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

	public static class SquareOneSimpleContext extends ParserRuleContext {
		public SquareOneModifierContext squareOneModifier() {
			return getRuleContext(SquareOneModifierContext.class,0);
		}
		public SquareOneBeginSlashContext squareOneBeginSlash() {
			return getRuleContext(SquareOneBeginSlashContext.class,0);
		}
		public List<SquareOneMoveSlashContext> squareOneMoveSlash() {
			return getRuleContexts(SquareOneMoveSlashContext.class);
		}
		public SquareOneMoveSlashContext squareOneMoveSlash(int i) {
			return getRuleContext(SquareOneMoveSlashContext.class,i);
		}
		public TerminalNode SQUARE_ONE_SLASH() { return getToken(SquareOneParser.SQUARE_ONE_SLASH, 0); }
		public SquareOneSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneSimpleContext squareOneSimple() throws RecognitionException {
		SquareOneSimpleContext _localctx = new SquareOneSimpleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_squareOneSimple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_la = _input.LA(1);
			if (_la==SQUARE_ONE_SLASH) {
				{
				setState(28);
				squareOneBeginSlash();
				}
			}

			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					squareOneMoveSlash();
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(37);
			squareOneModifier();
			setState(39);
			_la = _input.LA(1);
			if (_la==SQUARE_ONE_SLASH) {
				{
				setState(38);
				match(SQUARE_ONE_SLASH);
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

	public static class SquareOneBeginSlashContext extends ParserRuleContext {
		public TerminalNode SQUARE_ONE_SLASH() { return getToken(SquareOneParser.SQUARE_ONE_SLASH, 0); }
		public SquareOneBeginSlashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneBeginSlash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneBeginSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneBeginSlashContext squareOneBeginSlash() throws RecognitionException {
		SquareOneBeginSlashContext _localctx = new SquareOneBeginSlashContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_squareOneBeginSlash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(SQUARE_ONE_SLASH);
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

	public static class SquareOneMoveSlashContext extends ParserRuleContext {
		public SquareOneModifierContext squareOneModifier() {
			return getRuleContext(SquareOneModifierContext.class,0);
		}
		public TerminalNode SQUARE_ONE_SLASH() { return getToken(SquareOneParser.SQUARE_ONE_SLASH, 0); }
		public SquareOneMoveSlashContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneMoveSlash; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneMoveSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneMoveSlashContext squareOneMoveSlash() throws RecognitionException {
		SquareOneMoveSlashContext _localctx = new SquareOneMoveSlashContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_squareOneMoveSlash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			squareOneModifier();
			setState(44);
			match(SQUARE_ONE_SLASH);
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

	public static class SquareOneModifierContext extends ParserRuleContext {
		public TerminalNode SQUARE_ONE_BR_OPEN() { return getToken(SquareOneParser.SQUARE_ONE_BR_OPEN, 0); }
		public List<SquareOneFaceTurnContext> squareOneFaceTurn() {
			return getRuleContexts(SquareOneFaceTurnContext.class);
		}
		public SquareOneFaceTurnContext squareOneFaceTurn(int i) {
			return getRuleContext(SquareOneFaceTurnContext.class,i);
		}
		public TerminalNode SQUARE_ONE_COMMA() { return getToken(SquareOneParser.SQUARE_ONE_COMMA, 0); }
		public TerminalNode SQUARE_ONE_BR_CLOSE() { return getToken(SquareOneParser.SQUARE_ONE_BR_CLOSE, 0); }
		public SquareOneModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneModifierContext squareOneModifier() throws RecognitionException {
		SquareOneModifierContext _localctx = new SquareOneModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_squareOneModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(SQUARE_ONE_BR_OPEN);
			setState(47);
			squareOneFaceTurn();
			setState(48);
			match(SQUARE_ONE_COMMA);
			setState(49);
			squareOneFaceTurn();
			setState(50);
			match(SQUARE_ONE_BR_CLOSE);
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

	public static class SquareOneFaceTurnContext extends ParserRuleContext {
		public TerminalNode SQUARE_ONE_PLANE_ZERO() { return getToken(SquareOneParser.SQUARE_ONE_PLANE_ZERO, 0); }
		public TerminalNode SQUARE_ONE_PLANE_POS() { return getToken(SquareOneParser.SQUARE_ONE_PLANE_POS, 0); }
		public TerminalNode SQUARE_ONE_DIRECTION_MODIFIER() { return getToken(SquareOneParser.SQUARE_ONE_DIRECTION_MODIFIER, 0); }
		public SquareOneFaceTurnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneFaceTurn; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneFaceTurn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneFaceTurnContext squareOneFaceTurn() throws RecognitionException {
		SquareOneFaceTurnContext _localctx = new SquareOneFaceTurnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_squareOneFaceTurn);
		int _la;
		try {
			setState(57);
			switch (_input.LA(1)) {
			case SQUARE_ONE_PLANE_ZERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(SQUARE_ONE_PLANE_ZERO);
				}
				break;
			case SQUARE_ONE_PLANE_POS:
			case SQUARE_ONE_DIRECTION_MODIFIER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(54);
				_la = _input.LA(1);
				if (_la==SQUARE_ONE_DIRECTION_MODIFIER) {
					{
					setState(53);
					match(SQUARE_ONE_DIRECTION_MODIFIER);
					}
				}

				setState(56);
				match(SQUARE_ONE_PLANE_POS);
				}
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

	public static class SquareOneCommContext extends ParserRuleContext {
		public SquareOnePureCommContext squareOnePureComm() {
			return getRuleContext(SquareOnePureCommContext.class,0);
		}
		public SquareOneSetupCommContext squareOneSetupComm() {
			return getRuleContext(SquareOneSetupCommContext.class,0);
		}
		public SquareOneCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneCommContext squareOneComm() throws RecognitionException {
		SquareOneCommContext _localctx = new SquareOneCommContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_squareOneComm);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				squareOnePureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				squareOneSetupComm();
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

	public static class SquareOnePureCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(SquareOneParser.COMM_BR_OPEN, 0); }
		public List<SquareOneAlgContext> squareOneAlg() {
			return getRuleContexts(SquareOneAlgContext.class);
		}
		public SquareOneAlgContext squareOneAlg(int i) {
			return getRuleContext(SquareOneAlgContext.class,i);
		}
		public TerminalNode COMM_COMMA() { return getToken(SquareOneParser.COMM_COMMA, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(SquareOneParser.COMM_BR_CLOSE, 0); }
		public SquareOnePureCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOnePureComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOnePureComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOnePureCommContext squareOnePureComm() throws RecognitionException {
		SquareOnePureCommContext _localctx = new SquareOnePureCommContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_squareOnePureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(COMM_BR_OPEN);
			setState(64);
			squareOneAlg();
			setState(65);
			match(COMM_COMMA);
			setState(66);
			squareOneAlg();
			setState(67);
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

	public static class SquareOneSetupCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(SquareOneParser.COMM_BR_OPEN, 0); }
		public List<SquareOneAlgContext> squareOneAlg() {
			return getRuleContexts(SquareOneAlgContext.class);
		}
		public SquareOneAlgContext squareOneAlg(int i) {
			return getRuleContext(SquareOneAlgContext.class,i);
		}
		public TerminalNode COMM_SEMI_COLON() { return getToken(SquareOneParser.COMM_SEMI_COLON, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(SquareOneParser.COMM_BR_CLOSE, 0); }
		public SquareOneSetupCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareOneSetupComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SquareOneVisitor ) return ((SquareOneVisitor<? extends T>)visitor).visitSquareOneSetupComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SquareOneSetupCommContext squareOneSetupComm() throws RecognitionException {
		SquareOneSetupCommContext _localctx = new SquareOneSetupCommContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_squareOneSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(COMM_BR_OPEN);
			setState(70);
			squareOneAlg();
			setState(71);
			match(COMM_SEMI_COLON);
			setState(72);
			squareOneAlg();
			setState(73);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16N\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\5\2\31\n\2\3\3\3\3\5\3\35\n\3\3\4\5\4 \n\4\3\4\7\4#\n\4\f\4\16"+
		"\4&\13\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\5\b9\n\b\3\b\5\b<\n\b\3\t\3\t\5\t@\n\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2"+
		"\2K\2\30\3\2\2\2\4\34\3\2\2\2\6\37\3\2\2\2\b+\3\2\2\2\n-\3\2\2\2\f\60"+
		"\3\2\2\2\16;\3\2\2\2\20?\3\2\2\2\22A\3\2\2\2\24G\3\2\2\2\26\31\5\4\3\2"+
		"\27\31\7\2\2\3\30\26\3\2\2\2\30\27\3\2\2\2\31\3\3\2\2\2\32\35\5\6\4\2"+
		"\33\35\5\20\t\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36 \5\b\5\2\37"+
		"\36\3\2\2\2\37 \3\2\2\2 $\3\2\2\2!#\5\n\6\2\"!\3\2\2\2#&\3\2\2\2$\"\3"+
		"\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\')\5\f\7\2(*\7\3\2\2)(\3\2\2\2)"+
		"*\3\2\2\2*\7\3\2\2\2+,\7\3\2\2,\t\3\2\2\2-.\5\f\7\2./\7\3\2\2/\13\3\2"+
		"\2\2\60\61\7\4\2\2\61\62\5\16\b\2\62\63\7\6\2\2\63\64\5\16\b\2\64\65\7"+
		"\7\2\2\65\r\3\2\2\2\66<\7\5\2\2\679\7\t\2\28\67\3\2\2\289\3\2\2\29:\3"+
		"\2\2\2:<\7\b\2\2;\66\3\2\2\2;8\3\2\2\2<\17\3\2\2\2=@\5\22\n\2>@\5\24\13"+
		"\2?=\3\2\2\2?>\3\2\2\2@\21\3\2\2\2AB\7\n\2\2BC\5\4\3\2CD\7\13\2\2DE\5"+
		"\4\3\2EF\7\f\2\2F\23\3\2\2\2GH\7\n\2\2HI\5\4\3\2IJ\7\r\2\2JK\5\4\3\2K"+
		"L\7\f\2\2L\25\3\2\2\2\n\30\34\37$)8;?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}