// Generated from OKWCoreLexer.g4 by ANTLR 4.7.2

 package okw.parser.antlr4.core;
 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OKWCoreLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KLAMMERAUF=1, TEXT=2, WS=3, KLAMMERZU=4, PLUS=5, FOLDER_LOGMESSAGES=6, 
		FOLDER_XML=7, FILE_OKW_CONST_XML=8, FILE_OKW_DOCU_XML=9, FILE_OKW_IMPLEMENTATIONMATRIX_XML=10, 
		FILE_OKW_INI_XML=11, FILE_OKW_KEYMAPS_XML=12, FILE_OKW_MEMORIZE_XML=13, 
		KEYPREFIX=14, ENVVAL=15, VALUE=16;
	public static final int
		KLAMMER_MODE=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "KLAMMER_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KLAMMERAUF", "TEXT", "WS", "KLAMMERZU", "PLUS", "FOLDER_LOGMESSAGES", 
			"FOLDER_XML", "FILE_OKW_CONST_XML", "FILE_OKW_DOCU_XML", "FILE_OKW_IMPLEMENTATIONMATRIX_XML", 
			"FILE_OKW_INI_XML", "FILE_OKW_KEYMAPS_XML", "FILE_OKW_MEMORIZE_XML", 
			"KEYPREFIX", "ENVVAL", "VALUE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'${'", null, null, "'}'", "'+'", "'Folder_LogMessages'", "'Folder_XML'", 
			"'File_OKW_Const_xml'", "'File_OKW_Docu_xml'", "'File_OKW_ImplementationMatrix_xml'", 
			"'File_OKW_Ini_xml'", "'File_OKW_Keymaps_xml'", "'File_OKW_Memorize_xml'", 
			"'Taste.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KLAMMERAUF", "TEXT", "WS", "KLAMMERZU", "PLUS", "FOLDER_LOGMESSAGES", 
			"FOLDER_XML", "FILE_OKW_CONST_XML", "FILE_OKW_DOCU_XML", "FILE_OKW_IMPLEMENTATIONMATRIX_XML", 
			"FILE_OKW_INI_XML", "FILE_OKW_KEYMAPS_XML", "FILE_OKW_MEMORIZE_XML", 
			"KEYPREFIX", "ENVVAL", "VALUE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public OKWCoreLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OKWCoreLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u00ea\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\6\3+\n\3\r\3\16\3,\3\4\6\4\60\n\4\r\4\16\4\61\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\6\21\u00e7\n\21\r\21\16\21\u00e8\2\2\22\4\3\6\4\b\5\n\6\f\7"+
		"\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22\4\2\3\5\3\2"+
		"&&\3\2\17\17\7\2\60\60\62;C\\aac|\2\u00eb\2\4\3\2\2\2\2\6\3\2\2\2\2\b"+
		"\3\2\2\2\3\n\3\2\2\2\3\f\3\2\2\2\3\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2"+
		"\2\3\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\3\34\3\2\2\2\3"+
		"\36\3\2\2\2\3 \3\2\2\2\3\"\3\2\2\2\4$\3\2\2\2\6*\3\2\2\2\b/\3\2\2\2\n"+
		"\65\3\2\2\2\f9\3\2\2\2\16;\3\2\2\2\20N\3\2\2\2\22Y\3\2\2\2\24l\3\2\2\2"+
		"\26~\3\2\2\2\30\u00a0\3\2\2\2\32\u00b1\3\2\2\2\34\u00c6\3\2\2\2\36\u00dc"+
		"\3\2\2\2 \u00e3\3\2\2\2\"\u00e6\3\2\2\2$%\7&\2\2%&\7}\2\2&\'\3\2\2\2\'"+
		"(\b\2\2\2(\5\3\2\2\2)+\n\2\2\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2"+
		"-\7\3\2\2\2.\60\t\3\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2"+
		"\2\2\62\63\3\2\2\2\63\64\b\4\3\2\64\t\3\2\2\2\65\66\7\177\2\2\66\67\3"+
		"\2\2\2\678\b\5\4\28\13\3\2\2\29:\7-\2\2:\r\3\2\2\2;<\7H\2\2<=\7q\2\2="+
		">\7n\2\2>?\7f\2\2?@\7g\2\2@A\7t\2\2AB\7a\2\2BC\7N\2\2CD\7q\2\2DE\7i\2"+
		"\2EF\7O\2\2FG\7g\2\2GH\7u\2\2HI\7u\2\2IJ\7c\2\2JK\7i\2\2KL\7g\2\2LM\7"+
		"u\2\2M\17\3\2\2\2NO\7H\2\2OP\7q\2\2PQ\7n\2\2QR\7f\2\2RS\7g\2\2ST\7t\2"+
		"\2TU\7a\2\2UV\7Z\2\2VW\7O\2\2WX\7N\2\2X\21\3\2\2\2YZ\7H\2\2Z[\7k\2\2["+
		"\\\7n\2\2\\]\7g\2\2]^\7a\2\2^_\7Q\2\2_`\7M\2\2`a\7Y\2\2ab\7a\2\2bc\7E"+
		"\2\2cd\7q\2\2de\7p\2\2ef\7u\2\2fg\7v\2\2gh\7a\2\2hi\7z\2\2ij\7o\2\2jk"+
		"\7n\2\2k\23\3\2\2\2lm\7H\2\2mn\7k\2\2no\7n\2\2op\7g\2\2pq\7a\2\2qr\7Q"+
		"\2\2rs\7M\2\2st\7Y\2\2tu\7a\2\2uv\7F\2\2vw\7q\2\2wx\7e\2\2xy\7w\2\2yz"+
		"\7a\2\2z{\7z\2\2{|\7o\2\2|}\7n\2\2}\25\3\2\2\2~\177\7H\2\2\177\u0080\7"+
		"k\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2\2\u0082\u0083\7a\2\2\u0083\u0084"+
		"\7Q\2\2\u0084\u0085\7M\2\2\u0085\u0086\7Y\2\2\u0086\u0087\7a\2\2\u0087"+
		"\u0088\7K\2\2\u0088\u0089\7o\2\2\u0089\u008a\7r\2\2\u008a\u008b\7n\2\2"+
		"\u008b\u008c\7g\2\2\u008c\u008d\7o\2\2\u008d\u008e\7g\2\2\u008e\u008f"+
		"\7p\2\2\u008f\u0090\7v\2\2\u0090\u0091\7c\2\2\u0091\u0092\7v\2\2\u0092"+
		"\u0093\7k\2\2\u0093\u0094\7q\2\2\u0094\u0095\7p\2\2\u0095\u0096\7O\2\2"+
		"\u0096\u0097\7c\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2\u0099\u009a"+
		"\7k\2\2\u009a\u009b\7z\2\2\u009b\u009c\7a\2\2\u009c\u009d\7z\2\2\u009d"+
		"\u009e\7o\2\2\u009e\u009f\7n\2\2\u009f\27\3\2\2\2\u00a0\u00a1\7H\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7g\2\2\u00a4\u00a5\7a\2\2"+
		"\u00a5\u00a6\7Q\2\2\u00a6\u00a7\7M\2\2\u00a7\u00a8\7Y\2\2\u00a8\u00a9"+
		"\7a\2\2\u00a9\u00aa\7K\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7k\2\2\u00ac"+
		"\u00ad\7a\2\2\u00ad\u00ae\7z\2\2\u00ae\u00af\7o\2\2\u00af\u00b0\7n\2\2"+
		"\u00b0\31\3\2\2\2\u00b1\u00b2\7H\2\2\u00b2\u00b3\7k\2\2\u00b3\u00b4\7"+
		"n\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7a\2\2\u00b6\u00b7\7Q\2\2\u00b7\u00b8"+
		"\7M\2\2\u00b8\u00b9\7Y\2\2\u00b9\u00ba\7a\2\2\u00ba\u00bb\7M\2\2\u00bb"+
		"\u00bc\7g\2\2\u00bc\u00bd\7{\2\2\u00bd\u00be\7o\2\2\u00be\u00bf\7c\2\2"+
		"\u00bf\u00c0\7r\2\2\u00c0\u00c1\7u\2\2\u00c1\u00c2\7a\2\2\u00c2\u00c3"+
		"\7z\2\2\u00c3\u00c4\7o\2\2\u00c4\u00c5\7n\2\2\u00c5\33\3\2\2\2\u00c6\u00c7"+
		"\7H\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"\u00cb\7a\2\2\u00cb\u00cc\7Q\2\2\u00cc\u00cd\7M\2\2\u00cd\u00ce\7Y\2\2"+
		"\u00ce\u00cf\7a\2\2\u00cf\u00d0\7O\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2"+
		"\7o\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7k\2\2\u00d5"+
		"\u00d6\7|\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7a\2\2\u00d8\u00d9\7z\2\2"+
		"\u00d9\u00da\7o\2\2\u00da\u00db\7n\2\2\u00db\35\3\2\2\2\u00dc\u00dd\7"+
		"V\2\2\u00dd\u00de\7c\2\2\u00de\u00df\7u\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1"+
		"\7g\2\2\u00e1\u00e2\7\60\2\2\u00e2\37\3\2\2\2\u00e3\u00e4\5\"\21\2\u00e4"+
		"!\3\2\2\2\u00e5\u00e7\t\4\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2"+
		"\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9#\3\2\2\2\7\2\3,\61\u00e8"+
		"\5\4\3\2\b\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}