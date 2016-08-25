// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Clock.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.clock;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ClockParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLOCK_PLANE_SINGLE=1, CLOCK_NUM_MODIFIER=2, CLOCK_DIRECTION_MODIFIER=3, 
		CLOCK_PLANE_ROTATION=4, COMM_BR_OPEN=5, COMM_COMMA=6, COMM_BR_CLOSE=7, 
		COMM_SEMI_COLON=8, WHITESPACE=9;
	public static final int
		RULE_clock = 0, RULE_clockAlg = 1, RULE_clockSimple = 2, RULE_clockMove = 3, 
		RULE_turnPinClock = 4, RULE_rotationClock = 5, RULE_endPinClock = 6, RULE_clockComm = 7, 
		RULE_clockPureComm = 8, RULE_clockSetupComm = 9;
	public static final String[] ruleNames = {
		"clock", "clockAlg", "clockSimple", "clockMove", "turnPinClock", "rotationClock", 
		"endPinClock", "clockComm", "clockPureComm", "clockSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'y2'", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLOCK_PLANE_SINGLE", "CLOCK_NUM_MODIFIER", "CLOCK_DIRECTION_MODIFIER", 
		"CLOCK_PLANE_ROTATION", "COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", 
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
	public String getGrammarFileName() { return "Clock.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ClockParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ClockContext extends ParserRuleContext {
		public ClockAlgContext clockAlg() {
			return getRuleContext(ClockAlgContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ClockParser.EOF, 0); }
		public ClockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockContext clock() throws RecognitionException {
		ClockContext _localctx = new ClockContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_clock);
		try {
			setState(22);
			switch (_input.LA(1)) {
			case CLOCK_PLANE_SINGLE:
			case CLOCK_PLANE_ROTATION:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				clockAlg();
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

	public static class ClockAlgContext extends ParserRuleContext {
		public ClockSimpleContext clockSimple() {
			return getRuleContext(ClockSimpleContext.class,0);
		}
		public ClockCommContext clockComm() {
			return getRuleContext(ClockCommContext.class,0);
		}
		public ClockAlgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockAlg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClockAlg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockAlgContext clockAlg() throws RecognitionException {
		ClockAlgContext _localctx = new ClockAlgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clockAlg);
		try {
			setState(26);
			switch (_input.LA(1)) {
			case CLOCK_PLANE_SINGLE:
			case CLOCK_PLANE_ROTATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				clockSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				clockComm();
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

	public static class ClockSimpleContext extends ParserRuleContext {
		public List<ClockMoveContext> clockMove() {
			return getRuleContexts(ClockMoveContext.class);
		}
		public ClockMoveContext clockMove(int i) {
			return getRuleContext(ClockMoveContext.class,i);
		}
		public EndPinClockContext endPinClock() {
			return getRuleContext(EndPinClockContext.class,0);
		}
		public ClockSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClockSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockSimpleContext clockSimple() throws RecognitionException {
		ClockSimpleContext _localctx = new ClockSimpleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_clockSimple);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(28);
					clockMove();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(31); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(34);
			_la = _input.LA(1);
			if (_la==CLOCK_PLANE_SINGLE) {
				{
				setState(33);
				endPinClock();
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

	public static class ClockMoveContext extends ParserRuleContext {
		public TurnPinClockContext turnPinClock() {
			return getRuleContext(TurnPinClockContext.class,0);
		}
		public RotationClockContext rotationClock() {
			return getRuleContext(RotationClockContext.class,0);
		}
		public ClockMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClockMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockMoveContext clockMove() throws RecognitionException {
		ClockMoveContext _localctx = new ClockMoveContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_clockMove);
		try {
			setState(38);
			switch (_input.LA(1)) {
			case CLOCK_PLANE_SINGLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				turnPinClock();
				}
				break;
			case CLOCK_PLANE_ROTATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				rotationClock();
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

	public static class TurnPinClockContext extends ParserRuleContext {
		public TerminalNode CLOCK_PLANE_SINGLE() { return getToken(ClockParser.CLOCK_PLANE_SINGLE, 0); }
		public TerminalNode CLOCK_NUM_MODIFIER() { return getToken(ClockParser.CLOCK_NUM_MODIFIER, 0); }
		public TerminalNode CLOCK_DIRECTION_MODIFIER() { return getToken(ClockParser.CLOCK_DIRECTION_MODIFIER, 0); }
		public TurnPinClockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_turnPinClock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitTurnPinClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TurnPinClockContext turnPinClock() throws RecognitionException {
		TurnPinClockContext _localctx = new TurnPinClockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_turnPinClock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(CLOCK_PLANE_SINGLE);
			setState(41);
			match(CLOCK_NUM_MODIFIER);
			setState(42);
			match(CLOCK_DIRECTION_MODIFIER);
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

	public static class RotationClockContext extends ParserRuleContext {
		public TerminalNode CLOCK_PLANE_ROTATION() { return getToken(ClockParser.CLOCK_PLANE_ROTATION, 0); }
		public RotationClockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotationClock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitRotationClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RotationClockContext rotationClock() throws RecognitionException {
		RotationClockContext _localctx = new RotationClockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rotationClock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(CLOCK_PLANE_ROTATION);
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

	public static class EndPinClockContext extends ParserRuleContext {
		public TerminalNode CLOCK_PLANE_SINGLE() { return getToken(ClockParser.CLOCK_PLANE_SINGLE, 0); }
		public EndPinClockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endPinClock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitEndPinClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndPinClockContext endPinClock() throws RecognitionException {
		EndPinClockContext _localctx = new EndPinClockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_endPinClock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(CLOCK_PLANE_SINGLE);
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

	public static class ClockCommContext extends ParserRuleContext {
		public ClockPureCommContext clockPureComm() {
			return getRuleContext(ClockPureCommContext.class,0);
		}
		public ClockSetupCommContext clockSetupComm() {
			return getRuleContext(ClockSetupCommContext.class,0);
		}
		public ClockCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClockComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockCommContext clockComm() throws RecognitionException {
		ClockCommContext _localctx = new ClockCommContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_clockComm);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				clockPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				clockSetupComm();
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

	public static class ClockPureCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(ClockParser.COMM_BR_OPEN, 0); }
		public List<ClockAlgContext> clockAlg() {
			return getRuleContexts(ClockAlgContext.class);
		}
		public ClockAlgContext clockAlg(int i) {
			return getRuleContext(ClockAlgContext.class,i);
		}
		public TerminalNode COMM_COMMA() { return getToken(ClockParser.COMM_COMMA, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(ClockParser.COMM_BR_CLOSE, 0); }
		public ClockPureCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockPureComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClockPureComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockPureCommContext clockPureComm() throws RecognitionException {
		ClockPureCommContext _localctx = new ClockPureCommContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_clockPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(COMM_BR_OPEN);
			setState(53);
			clockAlg();
			setState(54);
			match(COMM_COMMA);
			setState(55);
			clockAlg();
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

	public static class ClockSetupCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(ClockParser.COMM_BR_OPEN, 0); }
		public List<ClockAlgContext> clockAlg() {
			return getRuleContexts(ClockAlgContext.class);
		}
		public ClockAlgContext clockAlg(int i) {
			return getRuleContext(ClockAlgContext.class,i);
		}
		public TerminalNode COMM_SEMI_COLON() { return getToken(ClockParser.COMM_SEMI_COLON, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(ClockParser.COMM_BR_CLOSE, 0); }
		public ClockSetupCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clockSetupComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ClockVisitor ) return ((ClockVisitor<? extends T>)visitor).visitClockSetupComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClockSetupCommContext clockSetupComm() throws RecognitionException {
		ClockSetupCommContext _localctx = new ClockSetupCommContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_clockSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(COMM_BR_OPEN);
			setState(59);
			clockAlg();
			setState(60);
			match(COMM_SEMI_COLON);
			setState(61);
			clockAlg();
			setState(62);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\5\2\31\n\2\3\3\3\3\5\3\35\n\3\3\4\6\4 \n\4\r\4\16\4!\3\4\5\4%\n"+
		"\4\3\5\3\5\5\5)\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\t\65\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\2\2\f\2\4"+
		"\6\b\n\f\16\20\22\24\2\2>\2\30\3\2\2\2\4\34\3\2\2\2\6\37\3\2\2\2\b(\3"+
		"\2\2\2\n*\3\2\2\2\f.\3\2\2\2\16\60\3\2\2\2\20\64\3\2\2\2\22\66\3\2\2\2"+
		"\24<\3\2\2\2\26\31\5\4\3\2\27\31\7\2\2\3\30\26\3\2\2\2\30\27\3\2\2\2\31"+
		"\3\3\2\2\2\32\35\5\6\4\2\33\35\5\20\t\2\34\32\3\2\2\2\34\33\3\2\2\2\35"+
		"\5\3\2\2\2\36 \5\b\5\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2"+
		"\"$\3\2\2\2#%\5\16\b\2$#\3\2\2\2$%\3\2\2\2%\7\3\2\2\2&)\5\n\6\2\')\5\f"+
		"\7\2(&\3\2\2\2(\'\3\2\2\2)\t\3\2\2\2*+\7\3\2\2+,\7\4\2\2,-\7\5\2\2-\13"+
		"\3\2\2\2./\7\6\2\2/\r\3\2\2\2\60\61\7\3\2\2\61\17\3\2\2\2\62\65\5\22\n"+
		"\2\63\65\5\24\13\2\64\62\3\2\2\2\64\63\3\2\2\2\65\21\3\2\2\2\66\67\7\7"+
		"\2\2\678\5\4\3\289\7\b\2\29:\5\4\3\2:;\7\t\2\2;\23\3\2\2\2<=\7\7\2\2="+
		">\5\4\3\2>?\7\n\2\2?@\5\4\3\2@A\7\t\2\2A\25\3\2\2\2\b\30\34!$(\64";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}