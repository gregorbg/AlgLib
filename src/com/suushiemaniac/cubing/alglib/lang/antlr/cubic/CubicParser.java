// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Cubic.g4 by ANTLR 4.5.1
package com.suushiemaniac.cubing.alglib.lang.antlr.cubic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CubicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
			CUBIC_PLANE = 1, CUBIC_SLICE = 2, CUBIC_MODIFIER = 3, CUBIC_WIDE = 4, CUBIC_DEPTH = 5,
			COMM_BR_OPEN = 6, COMM_COMMA = 7, COMM_BR_CLOSE = 8, COMM_SEMI_COLON = 9, WHITESPACE = 10;
	public static final int
		RULE_cubic = 0, RULE_cubicAlg = 1, RULE_cubicMove = 2, RULE_singleDepthCubic = 3,
			RULE_sliceCubic = 4, RULE_nDepthCubic = 5, RULE_cubicComm = 6, RULE_cubicPureComm = 7,
			RULE_cubicSetupComm = 8;
	public static final String[] ruleNames = {
			"cubic", "cubicAlg", "cubicMove", "singleDepthCubic", "sliceCubic", "nDepthCubic",
			"cubicComm", "cubicPureComm", "cubicSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
			null, null, null, null, "'w'", null, "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
			null, "CUBIC_PLANE", "CUBIC_SLICE", "CUBIC_MODIFIER", "CUBIC_WIDE", "CUBIC_DEPTH",
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
			setState(20);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_SLICE:
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
			}
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CUBIC_PLANE) | (1L << CUBIC_SLICE) | (1L << CUBIC_DEPTH))) != 0));
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
		public SliceCubicContext sliceCubic() {
			return getRuleContext(SliceCubicContext.class,0);
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
				sliceCubic();
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

	public static class SliceCubicContext extends ParserRuleContext {
		public TerminalNode CUBIC_SLICE() { return getToken(CubicParser.CUBIC_SLICE, 0); }
		public TerminalNode CUBIC_MODIFIER() { return getToken(CubicParser.CUBIC_MODIFIER, 0); }
		public SliceCubicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceCubic; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitSliceCubic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SliceCubicContext sliceCubic() throws RecognitionException {
		SliceCubicContext _localctx = new SliceCubicContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sliceCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(36);
			match(CUBIC_SLICE);
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
		enterRule(_localctx, 10, RULE_nDepthCubic);
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
			setState(50);
			switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
					setState(48);
				cubicPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
					setState(49);
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
				setState(52);
			match(COMM_BR_OPEN);
				setState(53);
			cubic();
				setState(54);
			match(COMM_COMMA);
				setState(55);
			cubic();
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
				setState(58);
			match(COMM_BR_OPEN);
				setState(59);
			cubic();
				setState(60);
			match(COMM_SEMI_COLON);
				setState(61);
			cubic();
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
			"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fC\4\2\t\2\4\3\t" +
					"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\5\2" +
					"\27\n\2\3\3\6\3\32\n\3\r\3\16\3\33\3\4\3\4\3\4\5\4!\n\4\3\5\3\5\5\5%\n" +
					"\5\3\6\3\6\5\6)\n\6\3\7\5\7,\n\7\3\7\3\7\3\7\5\7\61\n\7\3\b\3\b\5\b\65" +
					"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6" +
					"\b\n\f\16\20\22\2\2B\2\26\3\2\2\2\4\31\3\2\2\2\6 \3\2\2\2\b\"\3\2\2\2" +
					"\n&\3\2\2\2\f+\3\2\2\2\16\64\3\2\2\2\20\66\3\2\2\2\22<\3\2\2\2\24\27\5" +
					"\4\3\2\25\27\5\16\b\2\26\24\3\2\2\2\26\25\3\2\2\2\27\3\3\2\2\2\30\32\5" +
					"\6\4\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\5\3" +
					"\2\2\2\35!\5\b\5\2\36!\5\n\6\2\37!\5\f\7\2 \35\3\2\2\2 \36\3\2\2\2 \37" +
					"\3\2\2\2!\7\3\2\2\2\"$\7\3\2\2#%\7\5\2\2$#\3\2\2\2$%\3\2\2\2%\t\3\2\2" +
					"\2&(\7\4\2\2\')\7\5\2\2(\'\3\2\2\2()\3\2\2\2)\13\3\2\2\2*,\7\7\2\2+*\3" +
					"\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\3\2\2.\60\7\6\2\2/\61\7\5\2\2\60/\3\2\2" +
					"\2\60\61\3\2\2\2\61\r\3\2\2\2\62\65\5\20\t\2\63\65\5\22\n\2\64\62\3\2" +
					"\2\2\64\63\3\2\2\2\65\17\3\2\2\2\66\67\7\b\2\2\678\5\2\2\289\7\t\2\29" +
					":\5\2\2\2:;\7\n\2\2;\21\3\2\2\2<=\7\b\2\2=>\5\2\2\2>?\7\13\2\2?@\5\2\2" +
					"\2@A\7\n\2\2A\23\3\2\2\2\n\26\33 $(+\60\64";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}