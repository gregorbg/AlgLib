// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Cubic.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CUBIC_PLANE=1, CUBIC_OUTER_SLICE=2, CUBIC_CENTRAL_SLICE=3, CUBIC_MODIFIER=4, 
		CUBIC_MODIFIER_CCW=5, CUBIC_MODIFIER_DOUBLE=6, CUBIC_WIDE=7, CUBIC_DEPTH=8, 
		COMM_BR_OPEN=9, COMM_COMMA=10, COMM_BR_CLOSE=11, COMM_SEMI_COLON=12, WHITESPACE=13;
	public static final int
		RULE_cubic = 0, RULE_cubicAlg = 1, RULE_cubicMove = 2, RULE_singleDepthCubic = 3, 
		RULE_nDepthCubic = 4, RULE_centralSliceCubic = 5, RULE_outerSliceCubic = 6, 
		RULE_cubicComm = 7, RULE_cubicPureComm = 8, RULE_cubicSetupComm = 9;
	public static final String[] ruleNames = {
		"cubic", "cubicAlg", "cubicMove", "singleDepthCubic", "nDepthCubic", "centralSliceCubic", 
		"outerSliceCubic", "cubicComm", "cubicPureComm", "cubicSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'''", "'2'", "'w'", null, "'['", "','", 
		"']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CUBIC_PLANE", "CUBIC_OUTER_SLICE", "CUBIC_CENTRAL_SLICE", "CUBIC_MODIFIER", 
		"CUBIC_MODIFIER_CCW", "CUBIC_MODIFIER_DOUBLE", "CUBIC_WIDE", "CUBIC_DEPTH", 
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
			setState(22);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_OUTER_SLICE:
			case CUBIC_CENTRAL_SLICE:
			case CUBIC_MODIFIER_DOUBLE:
			case CUBIC_DEPTH:
			case COMM_COMMA:
			case COMM_BR_CLOSE:
			case COMM_SEMI_COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				cubicAlg();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CUBIC_PLANE) | (1L << CUBIC_OUTER_SLICE) | (1L << CUBIC_CENTRAL_SLICE) | (1L << CUBIC_MODIFIER_DOUBLE) | (1L << CUBIC_DEPTH))) != 0)) {
				{
				{
				setState(24);
				cubicMove();
				}
				}
				setState(29);
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

	public static class CubicMoveContext extends ParserRuleContext {
		public SingleDepthCubicContext singleDepthCubic() {
			return getRuleContext(SingleDepthCubicContext.class,0);
		}
		public NDepthCubicContext nDepthCubic() {
			return getRuleContext(NDepthCubicContext.class,0);
		}
		public OuterSliceCubicContext outerSliceCubic() {
			return getRuleContext(OuterSliceCubicContext.class,0);
		}
		public CentralSliceCubicContext centralSliceCubic() {
			return getRuleContext(CentralSliceCubicContext.class,0);
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
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				singleDepthCubic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				nDepthCubic();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				outerSliceCubic();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				centralSliceCubic();
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
			setState(36);
			match(CUBIC_PLANE);
			setState(38);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(37);
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
		public TerminalNode CUBIC_PLANE() { return getToken(CubicParser.CUBIC_PLANE, 0); }
		public TerminalNode CUBIC_WIDE() { return getToken(CubicParser.CUBIC_WIDE, 0); }
		public TerminalNode CUBIC_DEPTH() { return getToken(CubicParser.CUBIC_DEPTH, 0); }
		public TerminalNode CUBIC_MODIFIER() { return getToken(CubicParser.CUBIC_MODIFIER, 0); }
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
		enterRule(_localctx, 8, RULE_nDepthCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_la = _input.LA(1);
			if (_la==CUBIC_DEPTH) {
				{
				setState(40);
				match(CUBIC_DEPTH);
				}
			}

			setState(43);
			match(CUBIC_PLANE);
			setState(44);
			match(CUBIC_WIDE);
			setState(46);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(45);
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

	public static class CentralSliceCubicContext extends ParserRuleContext {
		public TerminalNode CUBIC_CENTRAL_SLICE() { return getToken(CubicParser.CUBIC_CENTRAL_SLICE, 0); }
		public TerminalNode CUBIC_MODIFIER() { return getToken(CubicParser.CUBIC_MODIFIER, 0); }
		public CentralSliceCubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_centralSliceCubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCentralSliceCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CentralSliceCubicContext centralSliceCubic() throws RecognitionException {
		CentralSliceCubicContext _localctx = new CentralSliceCubicContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_centralSliceCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(CUBIC_CENTRAL_SLICE);
			setState(50);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(49);
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

	public static class OuterSliceCubicContext extends ParserRuleContext {
		public TerminalNode CUBIC_OUTER_SLICE() { return getToken(CubicParser.CUBIC_OUTER_SLICE, 0); }
		public TerminalNode CUBIC_MODIFIER() { return getToken(CubicParser.CUBIC_MODIFIER, 0); }
		public TerminalNode CUBIC_DEPTH() { return getToken(CubicParser.CUBIC_DEPTH, 0); }
		public TerminalNode CUBIC_MODIFIER_DOUBLE() { return getToken(CubicParser.CUBIC_MODIFIER_DOUBLE, 0); }
		public OuterSliceCubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outerSliceCubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitOuterSliceCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OuterSliceCubicContext outerSliceCubic() throws RecognitionException {
		OuterSliceCubicContext _localctx = new OuterSliceCubicContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_outerSliceCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER_DOUBLE || _la==CUBIC_DEPTH) {
				{
				setState(52);
				_la = _input.LA(1);
				if ( !(_la==CUBIC_MODIFIER_DOUBLE || _la==CUBIC_DEPTH) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(55);
			match(CUBIC_OUTER_SLICE);
			setState(57);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(56);
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
		enterRule(_localctx, 14, RULE_cubicComm);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				cubicPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
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
		enterRule(_localctx, 16, RULE_cubicPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(COMM_BR_OPEN);
			setState(64);
			cubic();
			setState(65);
			match(COMM_COMMA);
			setState(66);
			cubic();
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
		enterRule(_localctx, 18, RULE_cubicSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(COMM_BR_OPEN);
			setState(70);
			cubic();
			setState(71);
			match(COMM_SEMI_COLON);
			setState(72);
			cubic();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17N\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\5\2\31\n\2\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\4\3\4\3\4\3\4\5\4"+
		"%\n\4\3\5\3\5\5\5)\n\5\3\6\5\6,\n\6\3\6\3\6\3\6\5\6\61\n\6\3\7\3\7\5\7"+
		"\65\n\7\3\b\5\b8\n\b\3\b\3\b\5\b<\n\b\3\t\3\t\5\t@\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22"+
		"\24\2\3\4\2\b\b\n\nO\2\30\3\2\2\2\4\35\3\2\2\2\6$\3\2\2\2\b&\3\2\2\2\n"+
		"+\3\2\2\2\f\62\3\2\2\2\16\67\3\2\2\2\20?\3\2\2\2\22A\3\2\2\2\24G\3\2\2"+
		"\2\26\31\5\4\3\2\27\31\5\20\t\2\30\26\3\2\2\2\30\27\3\2\2\2\31\3\3\2\2"+
		"\2\32\34\5\6\4\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2"+
		"\2\36\5\3\2\2\2\37\35\3\2\2\2 %\5\b\5\2!%\5\n\6\2\"%\5\16\b\2#%\5\f\7"+
		"\2$ \3\2\2\2$!\3\2\2\2$\"\3\2\2\2$#\3\2\2\2%\7\3\2\2\2&(\7\3\2\2\')\7"+
		"\6\2\2(\'\3\2\2\2()\3\2\2\2)\t\3\2\2\2*,\7\n\2\2+*\3\2\2\2+,\3\2\2\2,"+
		"-\3\2\2\2-.\7\3\2\2.\60\7\t\2\2/\61\7\6\2\2\60/\3\2\2\2\60\61\3\2\2\2"+
		"\61\13\3\2\2\2\62\64\7\5\2\2\63\65\7\6\2\2\64\63\3\2\2\2\64\65\3\2\2\2"+
		"\65\r\3\2\2\2\668\t\2\2\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29;\7\4\2"+
		"\2:<\7\6\2\2;:\3\2\2\2;<\3\2\2\2<\17\3\2\2\2=@\5\22\n\2>@\5\24\13\2?="+
		"\3\2\2\2?>\3\2\2\2@\21\3\2\2\2AB\7\13\2\2BC\5\2\2\2CD\7\f\2\2DE\5\2\2"+
		"\2EF\7\r\2\2F\23\3\2\2\2GH\7\13\2\2HI\5\2\2\2IJ\7\16\2\2JK\5\2\2\2KL\7"+
		"\r\2\2L\25\3\2\2\2\f\30\35$(+\60\64\67;?";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}