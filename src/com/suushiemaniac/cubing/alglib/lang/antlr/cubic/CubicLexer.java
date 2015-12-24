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
			CUBIC_PLANE = 1, CUBIC_SLICE = 2, CUBIC_MODIFIER = 3, CUBIC_WIDE = 4, CUBIC_DEPTH = 5,
			COMM_BR_OPEN = 6, COMM_COMMA = 7, COMM_BR_CLOSE = 8, COMM_SEMI_COLON = 9, WHITESPACE = 10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
			"CUBIC_PLANE", "CUBIC_SLICE", "CUBIC_MODIFIER", "CUBIC_WIDE", "CUBIC_DEPTH",
			"COMM_BR_OPEN", "COMM_COMMA", "COMM_BR_CLOSE", "COMM_SEMI_COLON", "WHITESPACE"
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
			"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\64\b\1\4\2\t\2" +
					"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
					"\t\13\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\6\6#\n\6\r\6\16\6$\5" +
					"\6\'\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\2\2\f\3\3" +
					"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\n\t\2DDFFHHNNTTWWz|\13" +
					"\2GGOOUUddffhhnnttww\4\2))\64\64\3\2\65;\3\2\63;\3\2\62;\3\2<=\4\2\13" +
					"\f\"\"\65\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2" +
					"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27" +
					"\3\2\2\2\5\31\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2\13&\3\2\2\2\r(\3\2\2\2" +
					"\17*\3\2\2\2\21,\3\2\2\2\23.\3\2\2\2\25\60\3\2\2\2\27\30\t\2\2\2\30\4" +
					"\3\2\2\2\31\32\t\3\2\2\32\6\3\2\2\2\33\34\t\4\2\2\34\b\3\2\2\2\35\36\7" +
					"y\2\2\36\n\3\2\2\2\37\'\t\5\2\2 \"\t\6\2\2!#\t\7\2\2\"!\3\2\2\2#$\3\2" +
					"\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&\37\3\2\2\2& \3\2\2\2\'\f\3\2\2\2" +
					"()\7]\2\2)\16\3\2\2\2*+\7.\2\2+\20\3\2\2\2,-\7_\2\2-\22\3\2\2\2./\t\b" +
					"\2\2/\24\3\2\2\2\60\61\t\t\2\2\61\62\3\2\2\2\62\63\b\13\2\2\63\26\3\2" +
					"\2\2\5\2$&\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}