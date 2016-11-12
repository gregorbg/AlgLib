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
		CUBIC_PLANE=1, CUBIC_OUTER_SLICE=2, CUBIC_CENTRAL_SLICE=3, CUBIC_DEPTH=4, 
		CUBIC_MODIFIER_CCW=5, CUBIC_MODIFIER_DOUBLE=6, CUBIC_WIDE=7, COMM_BR_OPEN=8, 
		COMM_COMMA=9, COMM_BR_CLOSE=10, COMM_SEMI_COLON=11, WHITESPACE=12;
	public static final int
		RULE_cubic = 0, RULE_cubicAlg = 1, RULE_cubicSimple = 2, RULE_cubicMove = 3, 
		RULE_singleDepthCubic = 4, RULE_nDepthCubic = 5, RULE_centralSliceCubic = 6, 
		RULE_outerSliceCubic = 7, RULE_cubicModifier = 8, RULE_cubicComm = 9, 
		RULE_cubicPureComm = 10, RULE_cubicSetupComm = 11;
	public static final String[] ruleNames = {
		"cubic", "cubicAlg", "cubicSimple", "cubicMove", "singleDepthCubic", "nDepthCubic", 
		"centralSliceCubic", "outerSliceCubic", "cubicModifier", "cubicComm", 
		"cubicPureComm", "cubicSetupComm"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'''", "'2'", "'w'", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CUBIC_PLANE", "CUBIC_OUTER_SLICE", "CUBIC_CENTRAL_SLICE", "CUBIC_DEPTH", 
		"CUBIC_MODIFIER_CCW", "CUBIC_MODIFIER_DOUBLE", "CUBIC_WIDE", "COMM_BR_OPEN", 
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
			setState(26);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_OUTER_SLICE:
			case CUBIC_CENTRAL_SLICE:
			case CUBIC_DEPTH:
			case CUBIC_MODIFIER_DOUBLE:
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				cubicAlg();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
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
			setState(30);
			switch (_input.LA(1)) {
			case CUBIC_PLANE:
			case CUBIC_OUTER_SLICE:
			case CUBIC_CENTRAL_SLICE:
			case CUBIC_DEPTH:
			case CUBIC_MODIFIER_DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				cubicSimple();
				}
				break;
			case COMM_BR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
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
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				cubicMove();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CUBIC_PLANE) | (1L << CUBIC_OUTER_SLICE) | (1L << CUBIC_CENTRAL_SLICE) | (1L << CUBIC_DEPTH) | (1L << CUBIC_MODIFIER_DOUBLE))) != 0) );
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
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				singleDepthCubic();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				nDepthCubic();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				outerSliceCubic();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
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
		public CubicModifierContext cubicModifier() {
			return getRuleContext(CubicModifierContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(CUBIC_PLANE);
			setState(44);
			cubicModifier();
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
		public CubicModifierContext cubicModifier() {
			return getRuleContext(CubicModifierContext.class,0);
		}
		public TerminalNode CUBIC_DEPTH() { return getToken(CubicParser.CUBIC_DEPTH, 0); }
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
			setState(47);
			_la = _input.LA(1);
			if (_la==CUBIC_DEPTH) {
				{
				setState(46);
				match(CUBIC_DEPTH);
				}
			}

			setState(49);
			match(CUBIC_PLANE);
			setState(50);
			match(CUBIC_WIDE);
			setState(51);
			cubicModifier();
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
		public CubicModifierContext cubicModifier() {
			return getRuleContext(CubicModifierContext.class,0);
		}
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(CUBIC_CENTRAL_SLICE);
			setState(54);
			cubicModifier();
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
		public CubicModifierContext cubicModifier() {
			return getRuleContext(CubicModifierContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_outerSliceCubic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if (_la==CUBIC_DEPTH || _la==CUBIC_MODIFIER_DOUBLE) {
				{
				setState(56);
				_la = _input.LA(1);
				if ( !(_la==CUBIC_DEPTH || _la==CUBIC_MODIFIER_DOUBLE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
			}

			setState(59);
			match(CUBIC_OUTER_SLICE);
			setState(60);
			cubicModifier();
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

	public static class CubicModifierContext extends ParserRuleContext {
		public TerminalNode CUBIC_MODIFIER_CCW() { return getToken(CubicParser.CUBIC_MODIFIER_CCW, 0); }
		public TerminalNode CUBIC_MODIFIER_DOUBLE() { return getToken(CubicParser.CUBIC_MODIFIER_DOUBLE, 0); }
		public CubicModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cubicModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CubicVisitor ) return ((CubicVisitor<? extends T>)visitor).visitCubicModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CubicModifierContext cubicModifier() throws RecognitionException {
		CubicModifierContext _localctx = new CubicModifierContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cubicModifier);
		try {
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(CUBIC_MODIFIER_CCW);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(CUBIC_MODIFIER_DOUBLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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
		enterRule(_localctx, 18, RULE_cubicComm);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				cubicPureComm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
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
		enterRule(_localctx, 20, RULE_cubicPureComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(COMM_BR_OPEN);
			setState(72);
			cubicAlg();
			setState(73);
			match(COMM_COMMA);
			setState(74);
			cubicAlg();
			setState(75);
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
		enterRule(_localctx, 22, RULE_cubicSetupComm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(COMM_BR_OPEN);
			setState(78);
			cubicAlg();
			setState(79);
			match(COMM_SEMI_COLON);
			setState(80);
			cubicAlg();
			setState(81);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16V\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\5\2\35\n\2\3\3\3\3\5\3!\n\3\3\4\6\4$\n\4\r\4\16"+
		"\4%\3\5\3\5\3\5\3\5\5\5,\n\5\3\6\3\6\3\6\3\7\5\7\62\n\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\5\t<\n\t\3\t\3\t\3\t\3\n\3\n\3\n\5\nD\n\n\3\13\3\13"+
		"\5\13H\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\2\2\16"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\2\3\4\2\6\6\b\bT\2\34\3\2\2\2\4 \3\2\2"+
		"\2\6#\3\2\2\2\b+\3\2\2\2\n-\3\2\2\2\f\61\3\2\2\2\16\67\3\2\2\2\20;\3\2"+
		"\2\2\22C\3\2\2\2\24G\3\2\2\2\26I\3\2\2\2\30O\3\2\2\2\32\35\5\4\3\2\33"+
		"\35\7\2\2\3\34\32\3\2\2\2\34\33\3\2\2\2\35\3\3\2\2\2\36!\5\6\4\2\37!\5"+
		"\24\13\2 \36\3\2\2\2 \37\3\2\2\2!\5\3\2\2\2\"$\5\b\5\2#\"\3\2\2\2$%\3"+
		"\2\2\2%#\3\2\2\2%&\3\2\2\2&\7\3\2\2\2\',\5\n\6\2(,\5\f\7\2),\5\20\t\2"+
		"*,\5\16\b\2+\'\3\2\2\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2,\t\3\2\2\2-.\7\3"+
		"\2\2./\5\22\n\2/\13\3\2\2\2\60\62\7\6\2\2\61\60\3\2\2\2\61\62\3\2\2\2"+
		"\62\63\3\2\2\2\63\64\7\3\2\2\64\65\7\t\2\2\65\66\5\22\n\2\66\r\3\2\2\2"+
		"\678\7\5\2\289\5\22\n\29\17\3\2\2\2:<\t\2\2\2;:\3\2\2\2;<\3\2\2\2<=\3"+
		"\2\2\2=>\7\4\2\2>?\5\22\n\2?\21\3\2\2\2@D\7\7\2\2AD\7\b\2\2BD\3\2\2\2"+
		"C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2D\23\3\2\2\2EH\5\26\f\2FH\5\30\r\2GE\3\2"+
		"\2\2GF\3\2\2\2H\25\3\2\2\2IJ\7\n\2\2JK\5\4\3\2KL\7\13\2\2LM\5\4\3\2MN"+
		"\7\f\2\2N\27\3\2\2\2OP\7\n\2\2PQ\5\4\3\2QR\7\r\2\2RS\5\4\3\2ST\7\f\2\2"+
		"T\31\3\2\2\2\n\34 %+\61;CG";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}