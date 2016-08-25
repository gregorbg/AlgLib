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
		RULE_squareOne = 0, RULE_squareOneAlg = 1, RULE_squareOneBeginSlash = 2, 
		RULE_squareOneMoveSlash = 3, RULE_squareOneModifier = 4, RULE_squareOneFaceTurn = 5, 
		RULE_squareOneComm = 6, RULE_squareOnePureComm = 7, RULE_squareOneSetupComm = 8;
	public static final String[] ruleNames = {
		"squareOne", "squareOneAlg", "squareOneBeginSlash", "squareOneMoveSlash", 
		"squareOneModifier", "squareOneFaceTurn", "squareOneComm", "squareOnePureComm", 
		"squareOneSetupComm"
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
		public SquareOneCommContext squareOneComm() {
			return getRuleContext(SquareOneCommContext.class,0);
		}
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
			setState(20);
			switch (_input.LA(1)) {
			case SQUARE_ONE_SLASH:
			case SQUARE_ONE_BR_OPEN:
			case COMM_COMMA:
			case COMM_BR_CLOSE:
			case COMM_SEMI_COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				squareOneAlg();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
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

	public static class SquareOneAlgContext extends ParserRuleContext {
		public SquareOneModifierContext squareOneModifier() {
			return getRuleContext(SquareOneModifierContext.class,0);
		}
		public TerminalNode SQUARE_ONE_SLASH() { return getToken(SquareOneParser.SQUARE_ONE_SLASH, 0); }
		public SquareOneBeginSlashContext squareOneBeginSlash() {
			return getRuleContext(SquareOneBeginSlashContext.class,0);
		}
		public List<SquareOneMoveSlashContext> squareOneMoveSlash() {
			return getRuleContexts(SquareOneMoveSlashContext.class);
		}
		public SquareOneMoveSlashContext squareOneMoveSlash(int i) {
			return getRuleContext(SquareOneMoveSlashContext.class,i);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(23);
				_la = _input.LA(1);
				if (_la==SQUARE_ONE_SLASH) {
					{
					setState(22);
					squareOneBeginSlash();
					}
				}

				setState(28);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(25);
						squareOneMoveSlash();
						}
						} 
					}
					setState(30);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(31);
				squareOneModifier();
				}
				break;
			}
			setState(35);
			_la = _input.LA(1);
			if (_la==SQUARE_ONE_SLASH) {
				{
				setState(34);
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
		enterRule(_localctx, 4, RULE_squareOneBeginSlash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
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
		enterRule(_localctx, 6, RULE_squareOneMoveSlash);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			squareOneModifier();
			setState(40);
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
		enterRule(_localctx, 8, RULE_squareOneModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(SQUARE_ONE_BR_OPEN);
			setState(43);
			squareOneFaceTurn();
			setState(44);
			match(SQUARE_ONE_COMMA);
			setState(45);
			squareOneFaceTurn();
			setState(46);
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
		enterRule(_localctx, 10, RULE_squareOneFaceTurn);
		int _la;
		try {
			setState(53);
			switch (_input.LA(1)) {
			case SQUARE_ONE_PLANE_ZERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(SQUARE_ONE_PLANE_ZERO);
				}
				break;
			case SQUARE_ONE_PLANE_POS:
			case SQUARE_ONE_DIRECTION_MODIFIER:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(50);
				_la = _input.LA(1);
				if (_la==SQUARE_ONE_DIRECTION_MODIFIER) {
					{
					setState(49);
					match(SQUARE_ONE_DIRECTION_MODIFIER);
					}
				}

				setState(52);
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
		enterRule(_localctx, 12, RULE_squareOneComm);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				squareOnePureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
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
		public List<SquareOneContext> squareOne() {
			return getRuleContexts(SquareOneContext.class);
		}
		public SquareOneContext squareOne(int i) {
			return getRuleContext(SquareOneContext.class,i);
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
		enterRule(_localctx, 14, RULE_squareOnePureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(COMM_BR_OPEN);
			setState(60);
			squareOne();
			setState(61);
			match(COMM_COMMA);
			setState(62);
			squareOne();
			setState(63);
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
		public List<SquareOneContext> squareOne() {
			return getRuleContexts(SquareOneContext.class);
		}
		public SquareOneContext squareOne(int i) {
			return getRuleContext(SquareOneContext.class,i);
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
		enterRule(_localctx, 16, RULE_squareOneSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(COMM_BR_OPEN);
			setState(66);
			squareOne();
			setState(67);
			match(COMM_SEMI_COLON);
			setState(68);
			squareOne();
			setState(69);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16J\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\5\2"+
		"\27\n\2\3\3\5\3\32\n\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\5\3#\n\3\3\3"+
		"\5\3&\n\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\5\7\65\n"+
		"\7\3\7\5\78\n\7\3\b\3\b\5\b<\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2H\2\26\3\2\2\2\4\"\3\2\2"+
		"\2\6\'\3\2\2\2\b)\3\2\2\2\n,\3\2\2\2\f\67\3\2\2\2\16;\3\2\2\2\20=\3\2"+
		"\2\2\22C\3\2\2\2\24\27\5\4\3\2\25\27\5\16\b\2\26\24\3\2\2\2\26\25\3\2"+
		"\2\2\27\3\3\2\2\2\30\32\5\6\4\2\31\30\3\2\2\2\31\32\3\2\2\2\32\36\3\2"+
		"\2\2\33\35\5\b\5\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2"+
		"\2\37!\3\2\2\2 \36\3\2\2\2!#\5\n\6\2\"\31\3\2\2\2\"#\3\2\2\2#%\3\2\2\2"+
		"$&\7\3\2\2%$\3\2\2\2%&\3\2\2\2&\5\3\2\2\2\'(\7\3\2\2(\7\3\2\2\2)*\5\n"+
		"\6\2*+\7\3\2\2+\t\3\2\2\2,-\7\4\2\2-.\5\f\7\2./\7\6\2\2/\60\5\f\7\2\60"+
		"\61\7\7\2\2\61\13\3\2\2\2\628\7\5\2\2\63\65\7\t\2\2\64\63\3\2\2\2\64\65"+
		"\3\2\2\2\65\66\3\2\2\2\668\7\b\2\2\67\62\3\2\2\2\67\64\3\2\2\28\r\3\2"+
		"\2\29<\5\20\t\2:<\5\22\n\2;9\3\2\2\2;:\3\2\2\2<\17\3\2\2\2=>\7\n\2\2>"+
		"?\5\2\2\2?@\7\13\2\2@A\5\2\2\2AB\7\f\2\2B\21\3\2\2\2CD\7\n\2\2DE\5\2\2"+
		"\2EF\7\r\2\2FG\5\2\2\2GH\7\f\2\2H\23\3\2\2\2\n\26\31\36\"%\64\67;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}