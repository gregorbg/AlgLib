// Generated from C:/Users/suushie_maniac/Desktop/tnoodle-master/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar\Cubic.g4 by ANTLR 4.5.1
package com.suushiemaniac.cubing.alglib.lang.antlr.cubic;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CubicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CUBIC_PLANE=1, CUBIC_MODIFIER=2, CUBIC_WIDE=3, CUBIC_DEPTH=4, COMM_BR_OPEN=5, 
		COMM_COMMA=6, COMM_BR_CLOSE=7, COMM_SEMI_COLON=8, WHITESPACE=9;
	public static final int
		RULE_cubic = 0, RULE_cubicAlg = 1, RULE_cubicMove = 2, RULE_singleDepthCubic = 3, 
		RULE_twoDepthCubic = 4, RULE_nDepthCubic = 5, RULE_cubicComm = 6, RULE_cubicPureComm = 7, 
		RULE_cubicSetupComm = 8;
	public static final String[] ruleNames = {
		"cubic", "cubicAlg", "cubicMove", "singleDepthCubic", "twoDepthCubic", 
		"nDepthCubic", "cubicComm", "cubicPureComm", "cubicSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'w'", null, "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CUBIC_PLANE", "CUBIC_MODIFIER", "CUBIC_WIDE", "CUBIC_DEPTH", "COMM_BR_OPEN", 
		"COMM_COMMA", "COMM_BR_CLOSE", "COMM_SEMI_COLON", "WHITESPACE"
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
	public String getGrammarFileName() { return "Cubic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CubicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CubicContext extends ParserRuleContext {
		public CubicAlgContext cubicAlg() {
			return getRuleContext(CubicAlgContext.class,0);
		}
		public CubicCommContext cubicComm() {
			return getRuleContext(CubicCommContext.class,0);
		}
		public CubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicContext cubic() throws RecognitionException {
		CubicContext _localctx = new CubicContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cubic);
		try {
			setState(20);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_DEPTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				cubicAlg();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				cubicComm();
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

	public static class CubicAlgContext extends ParserRuleContext {
		public List<CubicMoveContext> cubicMove() {
			return getRuleContexts(CubicMoveContext.class);
		}
		public CubicMoveContext cubicMove(int i) {
			return getRuleContext(CubicMoveContext.class,i);
		}
		public CubicAlgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicAlg; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicAlg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicAlgContext cubicAlg() throws RecognitionException {
		CubicAlgContext _localctx = new CubicAlgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cubicAlg);
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
				cubicMove();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CUBIC_PLANE || _la==CUBIC_DEPTH );
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

	public static class CubicMoveContext extends ParserRuleContext {
		public SingleDepthCubicContext singleDepthCubic() {
			return getRuleContext(SingleDepthCubicContext.class,0);
		}
		public TwoDepthCubicContext twoDepthCubic() {
			return getRuleContext(TwoDepthCubicContext.class,0);
		}
		public NDepthCubicContext nDepthCubic() {
			return getRuleContext(NDepthCubicContext.class,0);
		}
		public CubicMoveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicMove; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicMove(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicMoveContext cubicMove() throws RecognitionException {
		CubicMoveContext _localctx = new CubicMoveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cubicMove);
		try {
			setState(30);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				singleDepthCubic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				twoDepthCubic();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				nDepthCubic();
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

	public static class SingleDepthCubicContext extends ParserRuleContext {
		public TerminalNode CUBIC_PLANE() { return getToken(CubicParser.CUBIC_PLANE, 0); }
		public TerminalNode CUBIC_MODIFIER() { return getToken(CubicParser.CUBIC_MODIFIER, 0); }
		public SingleDepthCubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDepthCubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitSingleDepthCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleDepthCubicContext singleDepthCubic() throws RecognitionException {
		SingleDepthCubicContext _localctx = new SingleDepthCubicContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_singleDepthCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(CUBIC_PLANE);
			setState(34);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(33);
				match(CUBIC_MODIFIER);
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

	public static class TwoDepthCubicContext extends ParserRuleContext {
		public TerminalNode CUBIC_PLANE() { return getToken(CubicParser.CUBIC_PLANE, 0); }
		public TerminalNode CUBIC_WIDE() { return getToken(CubicParser.CUBIC_WIDE, 0); }
		public TerminalNode CUBIC_MODIFIER() { return getToken(CubicParser.CUBIC_MODIFIER, 0); }
		public TwoDepthCubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_twoDepthCubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitTwoDepthCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TwoDepthCubicContext twoDepthCubic() throws RecognitionException {
		TwoDepthCubicContext _localctx = new TwoDepthCubicContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_twoDepthCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(CUBIC_PLANE);
			setState(37);
			match(CUBIC_WIDE);
			setState(39);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(38);
				match(CUBIC_MODIFIER);
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

	public static class NDepthCubicContext extends ParserRuleContext {
		public TerminalNode CUBIC_DEPTH() { return getToken(CubicParser.CUBIC_DEPTH, 0); }
		public TwoDepthCubicContext twoDepthCubic() {
			return getRuleContext(TwoDepthCubicContext.class,0);
		}
		public NDepthCubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nDepthCubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitNDepthCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NDepthCubicContext nDepthCubic() throws RecognitionException {
		NDepthCubicContext _localctx = new NDepthCubicContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nDepthCubic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(CUBIC_DEPTH);
			setState(42);
			twoDepthCubic();
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

	public static class CubicCommContext extends ParserRuleContext {
		public CubicPureCommContext cubicPureComm() {
			return getRuleContext(CubicPureCommContext.class,0);
		}
		public CubicSetupCommContext cubicSetupComm() {
			return getRuleContext(CubicSetupCommContext.class,0);
		}
		public CubicCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicCommContext cubicComm() throws RecognitionException {
		CubicCommContext _localctx = new CubicCommContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cubicComm);
		try {
			setState(46);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				cubicPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				cubicSetupComm();
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

	public static class CubicPureCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(CubicParser.COMM_BR_OPEN, 0); }
		public List<CubicContext> cubic() {
			return getRuleContexts(CubicContext.class);
		}
		public CubicContext cubic(int i) {
			return getRuleContext(CubicContext.class,i);
		}
		public TerminalNode COMM_COMMA() { return getToken(CubicParser.COMM_COMMA, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(CubicParser.COMM_BR_CLOSE, 0); }
		public CubicPureCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicPureComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicPureComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicPureCommContext cubicPureComm() throws RecognitionException {
		CubicPureCommContext _localctx = new CubicPureCommContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cubicPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(COMM_BR_OPEN);
			setState(49);
			cubic();
			setState(50);
			match(COMM_COMMA);
			setState(51);
			cubic();
			setState(52);
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

	public static class CubicSetupCommContext extends ParserRuleContext {
		public TerminalNode COMM_BR_OPEN() { return getToken(CubicParser.COMM_BR_OPEN, 0); }
		public List<CubicContext> cubic() {
			return getRuleContexts(CubicContext.class);
		}
		public CubicContext cubic(int i) {
			return getRuleContext(CubicContext.class,i);
		}
		public TerminalNode COMM_SEMI_COLON() { return getToken(CubicParser.COMM_SEMI_COLON, 0); }
		public TerminalNode COMM_BR_CLOSE() { return getToken(CubicParser.COMM_BR_CLOSE, 0); }
		public CubicSetupCommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicSetupComm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicSetupComm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicSetupCommContext cubicSetupComm() throws RecognitionException {
		CubicSetupCommContext _localctx = new CubicSetupCommContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cubicSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(COMM_BR_OPEN);
			setState(55);
			cubic();
			setState(56);
			match(COMM_SEMI_COLON);
			setState(57);
			cubic();
			setState(58);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13?\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\5\2"+
		"\27\n\2\3\3\6\3\32\n\3\r\3\16\3\33\3\4\3\4\3\4\5\4!\n\4\3\5\3\5\5\5%\n"+
		"\5\3\6\3\6\3\6\5\6*\n\6\3\7\3\7\3\7\3\b\3\b\5\b\61\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2<"+
		"\2\26\3\2\2\2\4\31\3\2\2\2\6 \3\2\2\2\b\"\3\2\2\2\n&\3\2\2\2\f+\3\2\2"+
		"\2\16\60\3\2\2\2\20\62\3\2\2\2\228\3\2\2\2\24\27\5\4\3\2\25\27\5\16\b"+
		"\2\26\24\3\2\2\2\26\25\3\2\2\2\27\3\3\2\2\2\30\32\5\6\4\2\31\30\3\2\2"+
		"\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\5\3\2\2\2\35!\5\b\5\2"+
		"\36!\5\n\6\2\37!\5\f\7\2 \35\3\2\2\2 \36\3\2\2\2 \37\3\2\2\2!\7\3\2\2"+
		"\2\"$\7\3\2\2#%\7\4\2\2$#\3\2\2\2$%\3\2\2\2%\t\3\2\2\2&\'\7\3\2\2\')\7"+
		"\5\2\2(*\7\4\2\2)(\3\2\2\2)*\3\2\2\2*\13\3\2\2\2+,\7\6\2\2,-\5\n\6\2-"+
		"\r\3\2\2\2.\61\5\20\t\2/\61\5\22\n\2\60.\3\2\2\2\60/\3\2\2\2\61\17\3\2"+
		"\2\2\62\63\7\7\2\2\63\64\5\2\2\2\64\65\7\b\2\2\65\66\5\2\2\2\66\67\7\t"+
		"\2\2\67\21\3\2\2\289\7\7\2\29:\5\2\2\2:;\7\n\2\2;<\5\2\2\2<=\7\t\2\2="+
		"\23\3\2\2\2\b\26\33 $)\60";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}