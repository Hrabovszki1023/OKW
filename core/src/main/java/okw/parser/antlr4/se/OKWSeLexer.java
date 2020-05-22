// Generated from OKWSeLexer.g4 by ANTLR 4.7.2

package okw.parser.antlr4.se;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OKWSeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KLAMMERAUF=1, TEXT=2, WS=3, KLAMMERZU=4, PLUS=5, ALT=6, CTRL=7, SHIFT=8, 
		COMMAND=9, KEYVALUE=10, VALUE=11;
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
			"KLAMMERAUF", "TEXT", "WS", "KLAMMERZU", "PLUS", "ALT", "CTRL", "SHIFT", 
			"COMMAND", "KEYVALUE", "VALUE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'#{'", null, null, "'}'", "'+'", null, null, null, "'COMMAND'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KLAMMERAUF", "TEXT", "WS", "KLAMMERZU", "PLUS", "ALT", "CTRL", 
			"SHIFT", "COMMAND", "KEYVALUE", "VALUE"
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


	public OKWSeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OKWSeLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u01a8\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\3\6\3!\n\3\r\3\16\3\"\3\4\6\4"+
		"&\n\4\r\4\16\4\'\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7=\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bV\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tg\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u01a2\n\13\3\f\6\f\u01a5\n\f\r\f\16\f\u01a6\2\2\r\4\3"+
		"\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\4\2\3\5\3\2%%\3\2\17\17"+
		"\7\2\60\60\62;C\\aac|\2\u01e4\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\3\n"+
		"\3\2\2\2\3\f\3\2\2\2\3\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2"+
		"\2\3\26\3\2\2\2\3\30\3\2\2\2\4\32\3\2\2\2\6 \3\2\2\2\b%\3\2\2\2\n+\3\2"+
		"\2\2\f/\3\2\2\2\16<\3\2\2\2\20U\3\2\2\2\22f\3\2\2\2\24h\3\2\2\2\26\u01a1"+
		"\3\2\2\2\30\u01a4\3\2\2\2\32\33\7%\2\2\33\34\7}\2\2\34\35\3\2\2\2\35\36"+
		"\b\2\2\2\36\5\3\2\2\2\37!\n\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\""+
		"#\3\2\2\2#\7\3\2\2\2$&\t\3\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2"+
		"\2\2()\3\2\2\2)*\b\4\3\2*\t\3\2\2\2+,\7\177\2\2,-\3\2\2\2-.\b\5\4\2.\13"+
		"\3\2\2\2/\60\7-\2\2\60\r\3\2\2\2\61\62\7C\2\2\62\63\7N\2\2\63=\7V\2\2"+
		"\64\65\7N\2\2\65\66\7G\2\2\66\67\7H\2\2\678\7V\2\289\7a\2\29:\7C\2\2:"+
		";\7N\2\2;=\7V\2\2<\61\3\2\2\2<\64\3\2\2\2=\17\3\2\2\2>?\7E\2\2?@\7Q\2"+
		"\2@A\7P\2\2AB\7V\2\2BC\7T\2\2CD\7Q\2\2DV\7N\2\2EF\7E\2\2FG\7V\2\2GH\7"+
		"T\2\2HV\7N\2\2IJ\7N\2\2JK\7G\2\2KL\7H\2\2LM\7V\2\2MN\7a\2\2NO\7E\2\2O"+
		"P\7Q\2\2PQ\7P\2\2QR\7V\2\2RS\7T\2\2ST\7Q\2\2TV\7N\2\2U>\3\2\2\2UE\3\2"+
		"\2\2UI\3\2\2\2V\21\3\2\2\2WX\7U\2\2XY\7J\2\2YZ\7K\2\2Z[\7H\2\2[g\7V\2"+
		"\2\\]\7N\2\2]^\7G\2\2^_\7H\2\2_`\7V\2\2`a\7a\2\2ab\7U\2\2bc\7J\2\2cd\7"+
		"K\2\2de\7H\2\2eg\7V\2\2fW\3\2\2\2f\\\3\2\2\2g\23\3\2\2\2hi\7E\2\2ij\7"+
		"Q\2\2jk\7O\2\2kl\7O\2\2lm\7C\2\2mn\7P\2\2no\7F\2\2o\25\3\2\2\2pq\7C\2"+
		"\2qr\7F\2\2r\u01a2\7F\2\2st\7C\2\2tu\7T\2\2uv\7T\2\2vw\7Q\2\2wx\7Y\2\2"+
		"xy\7a\2\2yz\7F\2\2z{\7Q\2\2{|\7Y\2\2|\u01a2\7P\2\2}~\7C\2\2~\177\7T\2"+
		"\2\177\u0080\7T\2\2\u0080\u0081\7Q\2\2\u0081\u0082\7Y\2\2\u0082\u0083"+
		"\7a\2\2\u0083\u0084\7N\2\2\u0084\u0085\7G\2\2\u0085\u0086\7H\2\2\u0086"+
		"\u01a2\7V\2\2\u0087\u0088\7C\2\2\u0088\u0089\7T\2\2\u0089\u008a\7T\2\2"+
		"\u008a\u008b\7Q\2\2\u008b\u008c\7Y\2\2\u008c\u008d\7a\2\2\u008d\u008e"+
		"\7T\2\2\u008e\u008f\7K\2\2\u008f\u0090\7I\2\2\u0090\u0091\7J\2\2\u0091"+
		"\u01a2\7V\2\2\u0092\u0093\7C\2\2\u0093\u0094\7T\2\2\u0094\u0095\7T\2\2"+
		"\u0095\u0096\7Q\2\2\u0096\u0097\7Y\2\2\u0097\u0098\7a\2\2\u0098\u0099"+
		"\7W\2\2\u0099\u01a2\7R\2\2\u009a\u009b\7D\2\2\u009b\u009c\7C\2\2\u009c"+
		"\u009d\7E\2\2\u009d\u009e\7M\2\2\u009e\u009f\7a\2\2\u009f\u00a0\7U\2\2"+
		"\u00a0\u00a1\7R\2\2\u00a1\u00a2\7C\2\2\u00a2\u00a3\7E\2\2\u00a3\u01a2"+
		"\7G\2\2\u00a4\u00a5\7E\2\2\u00a5\u00a6\7C\2\2\u00a6\u00a7\7P\2\2\u00a7"+
		"\u00a8\7E\2\2\u00a8\u00a9\7G\2\2\u00a9\u01a2\7N\2\2\u00aa\u00ab\7E\2\2"+
		"\u00ab\u00ac\7N\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae\7C\2\2\u00ae\u01a2"+
		"\7T\2\2\u00af\u00b0\7F\2\2\u00b0\u00b1\7G\2\2\u00b1\u00b2\7E\2\2\u00b2"+
		"\u00b3\7K\2\2\u00b3\u00b4\7O\2\2\u00b4\u00b5\7C\2\2\u00b5\u01a2\7N\2\2"+
		"\u00b6\u00b7\7F\2\2\u00b7\u00b8\7G\2\2\u00b8\u00b9\7N\2\2\u00b9\u00ba"+
		"\7G\2\2\u00ba\u00bb\7V\2\2\u00bb\u01a2\7G\2\2\u00bc\u00bd\7F\2\2\u00bd"+
		"\u00be\7K\2\2\u00be\u00bf\7X\2\2\u00bf\u00c0\7K\2\2\u00c0\u00c1\7F\2\2"+
		"\u00c1\u01a2\7G\2\2\u00c2\u00c3\7N\2\2\u00c3\u00c4\7G\2\2\u00c4\u00c5"+
		"\7H\2\2\u00c5\u01a2\7V\2\2\u00c6\u00c7\7T\2\2\u00c7\u00c8\7K\2\2\u00c8"+
		"\u00c9\7I\2\2\u00c9\u00ca\7J\2\2\u00ca\u01a2\7V\2\2\u00cb\u00cc\7W\2\2"+
		"\u00cc\u01a2\7R\2\2\u00cd\u00ce\7F\2\2\u00ce\u00cf\7Q\2\2\u00cf\u00d0"+
		"\7Y\2\2\u00d0\u01a2\7P\2\2\u00d1\u00d2\7G\2\2\u00d2\u00d3\7P\2\2\u00d3"+
		"\u01a2\7F\2\2\u00d4\u00d5\7G\2\2\u00d5\u00d6\7P\2\2\u00d6\u00d7\7V\2\2"+
		"\u00d7\u00d8\7G\2\2\u00d8\u01a2\7T\2\2\u00d9\u00da\7G\2\2\u00da\u00db"+
		"\7S\2\2\u00db\u00dc\7W\2\2\u00dc\u00dd\7C\2\2\u00dd\u00de\7N\2\2\u00de"+
		"\u01a2\7U\2\2\u00df\u00e0\7G\2\2\u00e0\u00e1\7U\2\2\u00e1\u00e2\7E\2\2"+
		"\u00e2\u00e3\7C\2\2\u00e3\u00e4\7R\2\2\u00e4\u01a2\7G\2\2\u00e5\u00e6"+
		"\7H\2\2\u00e6\u01a2\7\63\2\2\u00e7\u00e8\7H\2\2\u00e8\u00e9\7\63\2\2\u00e9"+
		"\u01a2\7\62\2\2\u00ea\u00eb\7H\2\2\u00eb\u00ec\7\63\2\2\u00ec\u01a2\7"+
		"\63\2\2\u00ed\u00ee\7H\2\2\u00ee\u00ef\7\63\2\2\u00ef\u01a2\7\64\2\2\u00f0"+
		"\u00f1\7H\2\2\u00f1\u01a2\7\64\2\2\u00f2\u00f3\7H\2\2\u00f3\u01a2\7\65"+
		"\2\2\u00f4\u00f5\7H\2\2\u00f5\u01a2\7\66\2\2\u00f6\u00f7\7H\2\2\u00f7"+
		"\u01a2\7\67\2\2\u00f8\u00f9\7H\2\2\u00f9\u01a2\78\2\2\u00fa\u00fb\7H\2"+
		"\2\u00fb\u01a2\79\2\2\u00fc\u00fd\7H\2\2\u00fd\u01a2\7:\2\2\u00fe\u00ff"+
		"\7H\2\2\u00ff\u01a2\7;\2\2\u0100\u0101\7J\2\2\u0101\u0102\7G\2\2\u0102"+
		"\u0103\7N\2\2\u0103\u01a2\7R\2\2\u0104\u0105\7J\2\2\u0105\u0106\7Q\2\2"+
		"\u0106\u0107\7O\2\2\u0107\u01a2\7G\2\2\u0108\u0109\7K\2\2\u0109\u010a"+
		"\7P\2\2\u010a\u010b\7U\2\2\u010b\u010c\7G\2\2\u010c\u010d\7T\2\2\u010d"+
		"\u01a2\7V\2\2\u010e\u010f\7O\2\2\u010f\u0110\7G\2\2\u0110\u0111\7V\2\2"+
		"\u0111\u01a2\7C\2\2\u0112\u0113\7O\2\2\u0113\u0114\7W\2\2\u0114\u0115"+
		"\7N\2\2\u0115\u0116\7V\2\2\u0116\u0117\7K\2\2\u0117\u0118\7R\2\2\u0118"+
		"\u0119\7N\2\2\u0119\u01a2\7[\2\2\u011a\u011b\7P\2\2\u011b\u011c\7W\2\2"+
		"\u011c\u011d\7N\2\2\u011d\u01a2\7N\2\2\u011e\u011f\7P\2\2\u011f\u0120"+
		"\7W\2\2\u0120\u0121\7O\2\2\u0121\u0122\7R\2\2\u0122\u0123\7C\2\2\u0123"+
		"\u0124\7F\2\2\u0124\u01a2\7\62\2\2\u0125\u0126\7P\2\2\u0126\u0127\7W\2"+
		"\2\u0127\u0128\7O\2\2\u0128\u0129\7R\2\2\u0129\u012a\7C\2\2\u012a\u012b"+
		"\7F\2\2\u012b\u01a2\7\63\2\2\u012c\u012d\7P\2\2\u012d\u012e\7W\2\2\u012e"+
		"\u012f\7O\2\2\u012f\u0130\7R\2\2\u0130\u0131\7C\2\2\u0131\u0132\7F\2\2"+
		"\u0132\u01a2\7\64\2\2\u0133\u0134\7P\2\2\u0134\u0135\7W\2\2\u0135\u0136"+
		"\7O\2\2\u0136\u0137\7R\2\2\u0137\u0138\7C\2\2\u0138\u0139\7F\2\2\u0139"+
		"\u01a2\7\65\2\2\u013a\u013b\7P\2\2\u013b\u013c\7W\2\2\u013c\u013d\7O\2"+
		"\2\u013d\u013e\7R\2\2\u013e\u013f\7C\2\2\u013f\u0140\7F\2\2\u0140\u01a2"+
		"\7\66\2\2\u0141\u0142\7P\2\2\u0142\u0143\7W\2\2\u0143\u0144\7O\2\2\u0144"+
		"\u0145\7R\2\2\u0145\u0146\7C\2\2\u0146\u0147\7F\2\2\u0147\u01a2\7\67\2"+
		"\2\u0148\u0149\7P\2\2\u0149\u014a\7W\2\2\u014a\u014b\7O\2\2\u014b\u014c"+
		"\7R\2\2\u014c\u014d\7C\2\2\u014d\u014e\7F\2\2\u014e\u01a2\78\2\2\u014f"+
		"\u0150\7P\2\2\u0150\u0151\7W\2\2\u0151\u0152\7O\2\2\u0152\u0153\7R\2\2"+
		"\u0153\u0154\7C\2\2\u0154\u0155\7F\2\2\u0155\u01a2\79\2\2\u0156\u0157"+
		"\7P\2\2\u0157\u0158\7W\2\2\u0158\u0159\7O\2\2\u0159\u015a\7R\2\2\u015a"+
		"\u015b\7C\2\2\u015b\u015c\7F\2\2\u015c\u01a2\7:\2\2\u015d\u015e\7P\2\2"+
		"\u015e\u015f\7W\2\2\u015f\u0160\7O\2\2\u0160\u0161\7R\2\2\u0161\u0162"+
		"\7C\2\2\u0162\u0163\7F\2\2\u0163\u01a2\7;\2\2\u0164\u0165\7R\2\2\u0165"+
		"\u0166\7C\2\2\u0166\u0167\7I\2\2\u0167\u0168\7G\2\2\u0168\u0169\7a\2\2"+
		"\u0169\u016a\7F\2\2\u016a\u016b\7Q\2\2\u016b\u016c\7Y\2\2\u016c\u01a2"+
		"\7P\2\2\u016d\u016e\7R\2\2\u016e\u016f\7C\2\2\u016f\u0170\7I\2\2\u0170"+
		"\u0171\7G\2\2\u0171\u0172\7a\2\2\u0172\u0173\7W\2\2\u0173\u01a2\7R\2\2"+
		"\u0174\u0175\7R\2\2\u0175\u0176\7C\2\2\u0176\u0177\7W\2\2\u0177\u0178"+
		"\7U\2\2\u0178\u01a2\7G\2\2\u0179\u017a\7T\2\2\u017a\u017b\7G\2\2\u017b"+
		"\u017c\7V\2\2\u017c\u017d\7W\2\2\u017d\u017e\7T\2\2\u017e\u01a2\7P\2\2"+
		"\u017f\u0180\7U\2\2\u0180\u0181\7G\2\2\u0181\u0182\7O\2\2\u0182\u0183"+
		"\7K\2\2\u0183\u0184\7E\2\2\u0184\u0185\7Q\2\2\u0185\u0186\7N\2\2\u0186"+
		"\u0187\7Q\2\2\u0187\u01a2\7P\2\2\u0188\u0189\7U\2\2\u0189\u018a\7G\2\2"+
		"\u018a\u018b\7R\2\2\u018b\u018c\7C\2\2\u018c\u018d\7T\2\2\u018d\u018e"+
		"\7C\2\2\u018e\u018f\7V\2\2\u018f\u0190\7Q\2\2\u0190\u01a2\7T\2\2\u0191"+
		"\u0192\7U\2\2\u0192\u0193\7R\2\2\u0193\u0194\7C\2\2\u0194\u0195\7E\2\2"+
		"\u0195\u01a2\7G\2\2\u0196\u0197\7U\2\2\u0197\u0198\7W\2\2\u0198\u0199"+
		"\7D\2\2\u0199\u019a\7V\2\2\u019a\u019b\7T\2\2\u019b\u019c\7C\2\2\u019c"+
		"\u019d\7E\2\2\u019d\u01a2\7V\2\2\u019e\u019f\7V\2\2\u019f\u01a0\7C\2\2"+
		"\u01a0\u01a2\7D\2\2\u01a1p\3\2\2\2\u01a1s\3\2\2\2\u01a1}\3\2\2\2\u01a1"+
		"\u0087\3\2\2\2\u01a1\u0092\3\2\2\2\u01a1\u009a\3\2\2\2\u01a1\u00a4\3\2"+
		"\2\2\u01a1\u00aa\3\2\2\2\u01a1\u00af\3\2\2\2\u01a1\u00b6\3\2\2\2\u01a1"+
		"\u00bc\3\2\2\2\u01a1\u00c2\3\2\2\2\u01a1\u00c6\3\2\2\2\u01a1\u00cb\3\2"+
		"\2\2\u01a1\u00cd\3\2\2\2\u01a1\u00d1\3\2\2\2\u01a1\u00d4\3\2\2\2\u01a1"+
		"\u00d9\3\2\2\2\u01a1\u00df\3\2\2\2\u01a1\u00e5\3\2\2\2\u01a1\u00e7\3\2"+
		"\2\2\u01a1\u00ea\3\2\2\2\u01a1\u00ed\3\2\2\2\u01a1\u00f0\3\2\2\2\u01a1"+
		"\u00f2\3\2\2\2\u01a1\u00f4\3\2\2\2\u01a1\u00f6\3\2\2\2\u01a1\u00f8\3\2"+
		"\2\2\u01a1\u00fa\3\2\2\2\u01a1\u00fc\3\2\2\2\u01a1\u00fe\3\2\2\2\u01a1"+
		"\u0100\3\2\2\2\u01a1\u0104\3\2\2\2\u01a1\u0108\3\2\2\2\u01a1\u010e\3\2"+
		"\2\2\u01a1\u0112\3\2\2\2\u01a1\u011a\3\2\2\2\u01a1\u011e\3\2\2\2\u01a1"+
		"\u0125\3\2\2\2\u01a1\u012c\3\2\2\2\u01a1\u0133\3\2\2\2\u01a1\u013a\3\2"+
		"\2\2\u01a1\u0141\3\2\2\2\u01a1\u0148\3\2\2\2\u01a1\u014f\3\2\2\2\u01a1"+
		"\u0156\3\2\2\2\u01a1\u015d\3\2\2\2\u01a1\u0164\3\2\2\2\u01a1\u016d\3\2"+
		"\2\2\u01a1\u0174\3\2\2\2\u01a1\u0179\3\2\2\2\u01a1\u017f\3\2\2\2\u01a1"+
		"\u0188\3\2\2\2\u01a1\u0191\3\2\2\2\u01a1\u0196\3\2\2\2\u01a1\u019e\3\2"+
		"\2\2\u01a2\27\3\2\2\2\u01a3\u01a5\t\4\2\2\u01a4\u01a3\3\2\2\2\u01a5\u01a6"+
		"\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\31\3\2\2\2\13\2"+
		"\3\"\'<Uf\u01a1\u01a6\5\4\3\2\b\2\2\4\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}