// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Cubic.g4 by ANTLR 4.5.1
package com.suushiemaniac.cubing.alglib.lang.antlr.cubic;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CubicLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
			CUBIC_PLANE = 1, CUBIC_OUTER_SLICE = 2, CUBIC_CENTRAL_SLICE = 3, CUBIC_MODIFIER = 4,
			CUBIC_MODIFIER_CCW = 5, CUBIC_MODIFIER_DOUBLE = 6, CUBIC_WIDE = 7, CUBIC_DEPTH = 8,
			COMM_BR_OPEN = 9, COMM_COMMA = 10, COMM_BR_CLOSE = 11, COMM_SEMI_COLON = 12, WHITESPACE = 13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
			"CUBIC_PLANE", "CUBIC_OUTER_SLICE", "CUBIC_CENTRAL_SLICE", "CUBIC_MODIFIER",
			"CUBIC_MODIFIER_CCW", "CUBIC_MODIFIER_DOUBLE", "CUBIC_WIDE", "CUBIC_DEPTH",
			"COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", "COMM_SEMI_COLON", "WHITESPACE"
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


	public CubicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cubic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
			"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17B\b\1\4\2\t\2\4" +
					"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
					"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5&\n\5" +
					"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\6\t\61\n\t\r\t\16\t\62\5\t\65\n\t" +
					"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\2\2\17\3\3\5\4" +
					"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\n\t\2DDFF" +
					"HHNNTTWWz|\b\2ddffhhnnttww\5\2GGOOUU\3\2\65;\3\2\63;\3\2\62;\3\2<=\4\2" +
					"\13\f\"\"D\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2" +
					"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27" +
					"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2" +
					"\2\t%\3\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17+\3\2\2\2\21\64\3\2\2\2\23\66" +
					"\3\2\2\2\258\3\2\2\2\27:\3\2\2\2\31<\3\2\2\2\33>\3\2\2\2\35\36\t\2\2\2" +
					"\36\4\3\2\2\2\37 \t\3\2\2 \6\3\2\2\2!\"\t\4\2\2\"\b\3\2\2\2#&\5\13\6\2" +
					"$&\5\r\7\2%#\3\2\2\2%$\3\2\2\2&\n\3\2\2\2\'(\7)\2\2(\f\3\2\2\2)*\7\64" +
					"\2\2*\16\3\2\2\2+,\7y\2\2,\20\3\2\2\2-\65\t\5\2\2.\60\t\6\2\2/\61\t\7" +
					"\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2" +
					"\2\64-\3\2\2\2\64.\3\2\2\2\65\22\3\2\2\2\66\67\7]\2\2\67\24\3\2\2\289" +
					"\7.\2\29\26\3\2\2\2:;\7_\2\2;\30\3\2\2\2<=\t\b\2\2=\32\3\2\2\2>?\t\t\2" +
					"\2?@\3\2\2\2@A\b\16\2\2A\34\3\2\2\2\6\2%\62\64\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}