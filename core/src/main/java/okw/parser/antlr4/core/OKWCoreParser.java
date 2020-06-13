// Generated from OKWCoreParser.g4 by ANTLR 4.7.2
 package okw.parser.antlr4.core; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OKWCoreParser extends Parser {
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
		RULE_root = 0, RULE_okw_internal_var = 1, RULE_okw_env_var = 2, RULE_envvalue = 3, 
		RULE_text = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "okw_internal_var", "okw_env_var", "envvalue", "text"
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

	@Override
	public String getGrammarFileName() { return "OKWCoreParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OKWCoreParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public List<Okw_internal_varContext> okw_internal_var() {
			return getRuleContexts(Okw_internal_varContext.class);
		}
		public Okw_internal_varContext okw_internal_var(int i) {
			return getRuleContext(Okw_internal_varContext.class,i);
		}
		public List<Okw_env_varContext> okw_env_var() {
			return getRuleContexts(Okw_env_varContext.class);
		}
		public Okw_env_varContext okw_env_var(int i) {
			return getRuleContext(Okw_env_varContext.class,i);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWCoreParserVisitor ) return ((OKWCoreParserVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(13);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(10);
					okw_internal_var();
					}
					break;
				case 2:
					{
					setState(11);
					okw_env_var();
					}
					break;
				case 3:
					{
					setState(12);
					text();
					}
					break;
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KLAMMERAUF || _la==TEXT );
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

	public static class Okw_internal_varContext extends ParserRuleContext {
		public TerminalNode KLAMMERAUF() { return getToken(OKWCoreParser.KLAMMERAUF, 0); }
		public TerminalNode KLAMMERZU() { return getToken(OKWCoreParser.KLAMMERZU, 0); }
		public TerminalNode FOLDER_LOGMESSAGES() { return getToken(OKWCoreParser.FOLDER_LOGMESSAGES, 0); }
		public TerminalNode FOLDER_XML() { return getToken(OKWCoreParser.FOLDER_XML, 0); }
		public TerminalNode FILE_OKW_CONST_XML() { return getToken(OKWCoreParser.FILE_OKW_CONST_XML, 0); }
		public TerminalNode FILE_OKW_DOCU_XML() { return getToken(OKWCoreParser.FILE_OKW_DOCU_XML, 0); }
		public TerminalNode FILE_OKW_IMPLEMENTATIONMATRIX_XML() { return getToken(OKWCoreParser.FILE_OKW_IMPLEMENTATIONMATRIX_XML, 0); }
		public TerminalNode FILE_OKW_INI_XML() { return getToken(OKWCoreParser.FILE_OKW_INI_XML, 0); }
		public TerminalNode FILE_OKW_KEYMAPS_XML() { return getToken(OKWCoreParser.FILE_OKW_KEYMAPS_XML, 0); }
		public TerminalNode FILE_OKW_MEMORIZE_XML() { return getToken(OKWCoreParser.FILE_OKW_MEMORIZE_XML, 0); }
		public Okw_internal_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_okw_internal_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWCoreParserVisitor ) return ((OKWCoreParserVisitor<? extends T>)visitor).visitOkw_internal_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Okw_internal_varContext okw_internal_var() throws RecognitionException {
		Okw_internal_varContext _localctx = new Okw_internal_varContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_okw_internal_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			match(KLAMMERAUF);
			setState(18);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FOLDER_LOGMESSAGES) | (1L << FOLDER_XML) | (1L << FILE_OKW_CONST_XML) | (1L << FILE_OKW_DOCU_XML) | (1L << FILE_OKW_IMPLEMENTATIONMATRIX_XML) | (1L << FILE_OKW_INI_XML) | (1L << FILE_OKW_KEYMAPS_XML) | (1L << FILE_OKW_MEMORIZE_XML))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(19);
			match(KLAMMERZU);
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

	public static class Okw_env_varContext extends ParserRuleContext {
		public TerminalNode KLAMMERAUF() { return getToken(OKWCoreParser.KLAMMERAUF, 0); }
		public EnvvalueContext envvalue() {
			return getRuleContext(EnvvalueContext.class,0);
		}
		public TerminalNode KLAMMERZU() { return getToken(OKWCoreParser.KLAMMERZU, 0); }
		public Okw_env_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_okw_env_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWCoreParserVisitor ) return ((OKWCoreParserVisitor<? extends T>)visitor).visitOkw_env_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Okw_env_varContext okw_env_var() throws RecognitionException {
		Okw_env_varContext _localctx = new Okw_env_varContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_okw_env_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			match(KLAMMERAUF);
			setState(22);
			envvalue();
			setState(23);
			match(KLAMMERZU);
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

	public static class EnvvalueContext extends ParserRuleContext {
		public TerminalNode ENVVAL() { return getToken(OKWCoreParser.ENVVAL, 0); }
		public EnvvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_envvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWCoreParserVisitor ) return ((OKWCoreParserVisitor<? extends T>)visitor).visitEnvvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvvalueContext envvalue() throws RecognitionException {
		EnvvalueContext _localctx = new EnvvalueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_envvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(ENVVAL);
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

	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(OKWCoreParser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWCoreParserVisitor ) return ((OKWCoreParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(TEXT);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22 \4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2\b"+
		"\17\2\35\2\17\3\2\2\2\4\23\3\2\2\2\6\27\3\2\2\2\b\33\3\2\2\2\n\35\3\2"+
		"\2\2\f\20\5\4\3\2\r\20\5\6\4\2\16\20\5\n\6\2\17\f\3\2\2\2\17\r\3\2\2\2"+
		"\17\16\3\2\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2"+
		"\23\24\7\3\2\2\24\25\t\2\2\2\25\26\7\6\2\2\26\5\3\2\2\2\27\30\7\3\2\2"+
		"\30\31\5\b\5\2\31\32\7\6\2\2\32\7\3\2\2\2\33\34\7\21\2\2\34\t\3\2\2\2"+
		"\35\36\7\4\2\2\36\13\3\2\2\2\4\17\21";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}