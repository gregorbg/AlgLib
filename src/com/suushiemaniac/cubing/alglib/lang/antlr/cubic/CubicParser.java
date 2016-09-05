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
		CUBIC_SLICE_DEPTH=9, COMM_BR_OPEN=10, COMM_COMMA=11, COMM_BR_CLOSE=12, 
		COMM_SEMI_COLON=13, WHITESPACE=14;
	public static final int
		RULE_cubic = 0, RULE_cubicAlg = 1, RULE_cubicSimple = 2, RULE_cubicMove = 3, 
		RULE_singleDepthCubic = 4, RULE_nDepthCubic = 5, RULE_centralSliceCubic = 6, 
		RULE_outerSliceCubic = 7, RULE_cubicComm = 8, RULE_cubicPureComm = 9, 
		RULE_cubicSetupComm = 10;
	public static final String[] ruleNames = {
		"cubic", "cubicAlg", "cubicSimple", "cubicMove", "singleDepthCubic", "nDepthCubic", 
		"centralSliceCubic", "outerSliceCubic", "cubicComm", "cubicPureComm", 
		"cubicSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'''", "'2'", "'w'", null, null, "'['", 
		"','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CUBIC_PLANE", "CUBIC_OUTER_SLICE", "CUBIC_CENTRAL_SLICE", "CUBIC_MODIFIER", 
		"CUBIC_MODIFIER_CCW", "CUBIC_MODIFIER_DOUBLE", "CUBIC_WIDE", "CUBIC_DEPTH", 
		"CUBIC_SLICE_DEPTH", "COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", "COMM_SEMI_COLON", 
		"WHITESPACE"
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
		public TerminalNode EOF() { return getToken(CubicParser.EOF, 0); }
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
			setState(24);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_OUTER_SLICE:
			case CUBIC_CENTRAL_SLICE:
			case CUBIC_MODIFIER_DOUBLE:
			case CUBIC_DEPTH:
			case CUBIC_SLICE_DEPTH:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				cubicAlg();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(23);
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

	public static class CubicAlgContext extends ParserRuleContext {
		public CubicSimpleContext cubicSimple() {
			return getRuleContext(CubicSimpleContext.class,0);
		}
		public CubicCommContext cubicComm() {
			return getRuleContext(CubicCommContext.class,0);
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
		try {
			setState(28);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_OUTER_SLICE:
			case CUBIC_CENTRAL_SLICE:
			case CUBIC_MODIFIER_DOUBLE:
			case CUBIC_DEPTH:
			case CUBIC_SLICE_DEPTH:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				cubicSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
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

	public static class CubicSimpleContext extends ParserRuleContext {
		public List<CubicMoveContext> cubicMove() {
			return getRuleContexts(CubicMoveContext.class);
		}
		public CubicMoveContext cubicMove(int i) {
			return getRuleContext(CubicMoveContext.class,i);
		}
		public CubicSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicSimple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicSimpleContext cubicSimple() throws RecognitionException {
		CubicSimpleContext _localctx = new CubicSimpleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cubicSimple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				cubicMove();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CUBIC_PLANE) | (1L << CUBIC_OUTER_SLICE) | (1L << CUBIC_CENTRAL_SLICE) | (1L << CUBIC_MODIFIER_DOUBLE) | (1L << CUBIC_DEPTH) | (1L << CUBIC_SLICE_DEPTH))) != 0) );
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
		enterRule(_localctx, 6, RULE_cubicMove);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				singleDepthCubic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				nDepthCubic();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				outerSliceCubic();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
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
		enterRule(_localctx, 8, RULE_singleDepthCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(CUBIC_PLANE);
			setState(43);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(42);
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
			setState(46);
			_la = _input.LA(1);
			if (_la==CUBIC_DEPTH) {
				{
				setState(45);
				match(CUBIC_DEPTH);
				}
			}

			setState(48);
			match(CUBIC_PLANE);
			setState(49);
			match(CUBIC_WIDE);
			setState(51);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(50);
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
		enterRule(_localctx, 12, RULE_centralSliceCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(CUBIC_CENTRAL_SLICE);
			setState(55);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(54);
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
		public TerminalNode CUBIC_SLICE_DEPTH() { return getToken(CubicParser.CUBIC_SLICE_DEPTH, 0); }
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
		enterRule(_localctx, 14, RULE_outerSliceCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER_DOUBLE || _la==CUBIC_SLICE_DEPTH) {
				{
				setState(57);
				_la = _input.LA(1);
				if ( !(_la==CUBIC_MODIFIER_DOUBLE || _la==CUBIC_SLICE_DEPTH) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(60);
			match(CUBIC_OUTER_SLICE);
			setState(62);
			_la = _input.LA(1);
			if (_la==CUBIC_MODIFIER) {
				{
				setState(61);
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
		enterRule(_localctx, 16, RULE_cubicComm);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cubicPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
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
		public List<CubicAlgContext> cubicAlg() {
			return getRuleContexts(CubicAlgContext.class);
		}
		public CubicAlgContext cubicAlg(int i) {
			return getRuleContext(CubicAlgContext.class,i);
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
		enterRule(_localctx, 18, RULE_cubicPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(COMM_BR_OPEN);
			setState(69);
			cubicAlg();
			setState(70);
			match(COMM_COMMA);
			setState(71);
			cubicAlg();
			setState(72);
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
		public List<CubicAlgContext> cubicAlg() {
			return getRuleContexts(CubicAlgContext.class);
		}
		public CubicAlgContext cubicAlg(int i) {
			return getRuleContext(CubicAlgContext.class,i);
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
		enterRule(_localctx, 20, RULE_cubicSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(COMM_BR_OPEN);
			setState(75);
			cubicAlg();
			setState(76);
			match(COMM_SEMI_COLON);
			setState(77);
			cubicAlg();
			setState(78);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20S\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\5\2\33\n\2\3\3\3\3\5\3\37\n\3\3\4\6\4\"\n\4\r\4\16\4#\3"+
		"\5\3\5\3\5\3\5\5\5*\n\5\3\6\3\6\5\6.\n\6\3\7\5\7\61\n\7\3\7\3\7\3\7\5"+
		"\7\66\n\7\3\b\3\b\5\b:\n\b\3\t\5\t=\n\t\3\t\3\t\5\tA\n\t\3\n\3\n\5\nE"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\2\2\r\2"+
		"\4\6\b\n\f\16\20\22\24\26\2\3\4\2\b\b\13\13T\2\32\3\2\2\2\4\36\3\2\2\2"+
		"\6!\3\2\2\2\b)\3\2\2\2\n+\3\2\2\2\f\60\3\2\2\2\16\67\3\2\2\2\20<\3\2\2"+
		"\2\22D\3\2\2\2\24F\3\2\2\2\26L\3\2\2\2\30\33\5\4\3\2\31\33\7\2\2\3\32"+
		"\30\3\2\2\2\32\31\3\2\2\2\33\3\3\2\2\2\34\37\5\6\4\2\35\37\5\22\n\2\36"+
		"\34\3\2\2\2\36\35\3\2\2\2\37\5\3\2\2\2 \"\5\b\5\2! \3\2\2\2\"#\3\2\2\2"+
		"#!\3\2\2\2#$\3\2\2\2$\7\3\2\2\2%*\5\n\6\2&*\5\f\7\2\'*\5\20\t\2(*\5\16"+
		"\b\2)%\3\2\2\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\t\3\2\2\2+-\7\3\2\2,.\7"+
		"\6\2\2-,\3\2\2\2-.\3\2\2\2.\13\3\2\2\2/\61\7\n\2\2\60/\3\2\2\2\60\61\3"+
		"\2\2\2\61\62\3\2\2\2\62\63\7\3\2\2\63\65\7\t\2\2\64\66\7\6\2\2\65\64\3"+
		"\2\2\2\65\66\3\2\2\2\66\r\3\2\2\2\679\7\5\2\28:\7\6\2\298\3\2\2\29:\3"+
		"\2\2\2:\17\3\2\2\2;=\t\2\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>@\7\4\2\2?"+
		"A\7\6\2\2@?\3\2\2\2@A\3\2\2\2A\21\3\2\2\2BE\5\24\13\2CE\5\26\f\2DB\3\2"+
		"\2\2DC\3\2\2\2E\23\3\2\2\2FG\7\f\2\2GH\5\4\3\2HI\7\r\2\2IJ\5\4\3\2JK\7"+
		"\16\2\2K\25\3\2\2\2LM\7\f\2\2MN\5\4\3\2NO\7\17\2\2OP\5\4\3\2PQ\7\16\2"+
		"\2Q\27\3\2\2\2\r\32\36#)-\60\659<@D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}