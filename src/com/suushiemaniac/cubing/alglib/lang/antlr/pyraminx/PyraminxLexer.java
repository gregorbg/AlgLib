// Generated from C:/Users/suushie_maniac/Desktop/tnoodle-master/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar\Pyraminx.g4 by ANTLR 4.5.1
package com.suushiemaniac.cubing.alglib.lang.antlr.pyraminx;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PyraminxLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PYRAMINX_FULL_PLANE=1, PYRAMINX_TIP_PLANE=2, PYRAMINX_MODIFIER=3, COMM_BR_OPEN=4, 
		COMM_COMMA=5, COMM_BR_CLOSE=6, COMM_SEMI_COLON=7, WHITESPACE=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PYRAMINX_FULL_PLANE", "PYRAMINX_TIP_PLANE", "PYRAMINX_MODIFIER", "COMM_BR_OPEN", 
		"COMM_COMMA", "COMM_BR_CLOSE", "COMM_SEMI_COLON", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'''", "'['", "','", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PYRAMINX_FULL_PLANE", "PYRAMINX_TIP_PLANE", "PYRAMINX_MODIFIER", 
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


	public PyraminxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pyraminx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n%\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\2\2\n\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\3\2\6\6\2DDNNTTWW\6\2ddnnttww\3\2<=\4\2\13"+
		"\f\"\"$\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\25\3\2\2\2\7\27\3"+
		"\2\2\2\t\31\3\2\2\2\13\33\3\2\2\2\r\35\3\2\2\2\17\37\3\2\2\2\21!\3\2\2"+
		"\2\23\24\t\2\2\2\24\4\3\2\2\2\25\26\t\3\2\2\26\6\3\2\2\2\27\30\7)\2\2"+
		"\30\b\3\2\2\2\31\32\7]\2\2\32\n\3\2\2\2\33\34\7.\2\2\34\f\3\2\2\2\35\36"+
		"\7_\2\2\36\16\3\2\2\2\37 \t\4\2\2 \20\3\2\2\2!\"\t\5\2\2\"#\3\2\2\2#$"+
		"\b\t\2\2$\22\3\2\2\2\3\2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}