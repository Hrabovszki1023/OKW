// Generated from OKW_Parser.g4 by ANTLR 4.3

package okw.parser.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OKW_Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KLAMMERZU=4, ENVVAL=15, WS=3, FOLDER_LOGMESSAGES=5, FILE_OKW_KEYMAPS_XML=11, 
		FILE_OKW_MEMORIZE_XML=12, FOLDER_XML=6, FILE_OKW_CONST_XML=7, VALUE=16, 
		TEXT=2, FILE_OKW_INI_XML=10, KEYVALUE=14, FILE_OKW_IMPLEMENTATIONMATRIX_XML=9, 
		KLAMMERAUF=1, KEYPREFIX=13, FILE_OKW_DOCU_XML=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'${'", "TEXT", "WS", "'}'", "'Folder_LogMessages'", "'Folder_XML'", 
		"'File_OKW_Const_xml'", "'File_OKW_Docu_xml'", "'File_OKW_ImplementationMatrix_xml'", 
		"'File_OKW_Ini_xml'", "'File_OKW_Keymaps_xml'", "'File_OKW_Memorize_xml'", 
		"'Taste.'", "KEYVALUE", "ENVVAL", "VALUE"
	};
	public static final int
		RULE_root = 0, RULE_okw_internal_var = 1, RULE_okw_typekey = 2, RULE_keyvalue = 3, 
		RULE_okw_env_var = 4, RULE_envvalue = 5, RULE_text = 6;
	public static final String[] ruleNames = {
		"root", "okw_internal_var", "okw_typekey", "keyvalue", "okw_env_var", 
		"envvalue", "text"
	};

	@Override
	public String getGrammarFileName() { return "OKW_Parser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OKW_Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public List<Okw_internal_varContext> okw_internal_var() {
			return getRuleContexts(Okw_internal_varContext.class);
		}
		public Okw_typekeyContext okw_typekey(int i) {
			return getRuleContext(Okw_typekeyContext.class,i);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<Okw_env_varContext> okw_env_var() {
			return getRuleContexts(Okw_env_varContext.class);
		}
		public Okw_internal_varContext okw_internal_var(int i) {
			return getRuleContext(Okw_internal_varContext.class,i);
		}
		public Okw_env_varContext okw_env_var(int i) {
			return getRuleContext(Okw_env_varContext.class,i);
		}
		public List<Okw_typekeyContext> okw_typekey() {
			return getRuleContexts(Okw_typekeyContext.class);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitRoot(this);
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
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(18);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(14); okw_internal_var();
					}
					break;

				case 2:
					{
					setState(15); okw_env_var();
					}
					break;

				case 3:
					{
					setState(16); okw_typekey();
					}
					break;

				case 4:
					{
					setState(17); text();
					}
					break;
				}
				}
				setState(20); 
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
		public TerminalNode FOLDER_XML() { return getToken(OKW_Parser.FOLDER_XML, 0); }
		public TerminalNode FILE_OKW_INI_XML() { return getToken(OKW_Parser.FILE_OKW_INI_XML, 0); }
		public TerminalNode FILE_OKW_KEYMAPS_XML() { return getToken(OKW_Parser.FILE_OKW_KEYMAPS_XML, 0); }
		public TerminalNode FILE_OKW_DOCU_XML() { return getToken(OKW_Parser.FILE_OKW_DOCU_XML, 0); }
		public TerminalNode FILE_OKW_MEMORIZE_XML() { return getToken(OKW_Parser.FILE_OKW_MEMORIZE_XML, 0); }
		public TerminalNode KLAMMERAUF() { return getToken(OKW_Parser.KLAMMERAUF, 0); }
		public TerminalNode FILE_OKW_CONST_XML() { return getToken(OKW_Parser.FILE_OKW_CONST_XML, 0); }
		public TerminalNode FOLDER_LOGMESSAGES() { return getToken(OKW_Parser.FOLDER_LOGMESSAGES, 0); }
		public TerminalNode KLAMMERZU() { return getToken(OKW_Parser.KLAMMERZU, 0); }
		public TerminalNode FILE_OKW_IMPLEMENTATIONMATRIX_XML() { return getToken(OKW_Parser.FILE_OKW_IMPLEMENTATIONMATRIX_XML, 0); }
		public Okw_internal_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_okw_internal_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterOkw_internal_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitOkw_internal_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitOkw_internal_var(this);
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
			setState(22); match(KLAMMERAUF);
			setState(23);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FOLDER_LOGMESSAGES) | (1L << FOLDER_XML) | (1L << FILE_OKW_CONST_XML) | (1L << FILE_OKW_DOCU_XML) | (1L << FILE_OKW_IMPLEMENTATIONMATRIX_XML) | (1L << FILE_OKW_INI_XML) | (1L << FILE_OKW_KEYMAPS_XML) | (1L << FILE_OKW_MEMORIZE_XML))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(24); match(KLAMMERZU);
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

	public static class Okw_typekeyContext extends ParserRuleContext {
		public TerminalNode KLAMMERAUF() { return getToken(OKW_Parser.KLAMMERAUF, 0); }
		public TerminalNode KEYPREFIX() { return getToken(OKW_Parser.KEYPREFIX, 0); }
		public TerminalNode KLAMMERZU() { return getToken(OKW_Parser.KLAMMERZU, 0); }
		public KeyvalueContext keyvalue() {
			return getRuleContext(KeyvalueContext.class,0);
		}
		public Okw_typekeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_okw_typekey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterOkw_typekey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitOkw_typekey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitOkw_typekey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Okw_typekeyContext okw_typekey() throws RecognitionException {
		Okw_typekeyContext _localctx = new Okw_typekeyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_okw_typekey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); match(KLAMMERAUF);
			setState(27); match(KEYPREFIX);
			setState(28); keyvalue();
			setState(29); match(KLAMMERZU);
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

	public static class KeyvalueContext extends ParserRuleContext {
		public TerminalNode KEYVALUE() { return getToken(OKW_Parser.KEYVALUE, 0); }
		public KeyvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterKeyvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitKeyvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitKeyvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyvalueContext keyvalue() throws RecognitionException {
		KeyvalueContext _localctx = new KeyvalueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_keyvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(KEYVALUE);
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
		public EnvvalueContext envvalue() {
			return getRuleContext(EnvvalueContext.class,0);
		}
		public TerminalNode KLAMMERAUF() { return getToken(OKW_Parser.KLAMMERAUF, 0); }
		public TerminalNode KLAMMERZU() { return getToken(OKW_Parser.KLAMMERZU, 0); }
		public Okw_env_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_okw_env_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterOkw_env_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitOkw_env_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitOkw_env_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Okw_env_varContext okw_env_var() throws RecognitionException {
		Okw_env_varContext _localctx = new Okw_env_varContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_okw_env_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); match(KLAMMERAUF);
			setState(34); envvalue();
			setState(35); match(KLAMMERZU);
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
		public TerminalNode ENVVAL() { return getToken(OKW_Parser.ENVVAL, 0); }
		public EnvvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_envvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterEnvvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitEnvvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitEnvvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnvvalueContext envvalue() throws RecognitionException {
		EnvvalueContext _localctx = new EnvvalueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_envvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(ENVVAL);
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
		public TerminalNode TEXT() { return getToken(OKW_Parser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof OKW_ParserListener ) ((OKW_ParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKW_ParserVisitor ) return ((OKW_ParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(TEXT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\6\2\25\n\2"+
		"\r\2\16\2\26\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\3\3\2\7\16(\2\24\3\2\2\2"+
		"\4\30\3\2\2\2\6\34\3\2\2\2\b!\3\2\2\2\n#\3\2\2\2\f\'\3\2\2\2\16)\3\2\2"+
		"\2\20\25\5\4\3\2\21\25\5\n\6\2\22\25\5\6\4\2\23\25\5\16\b\2\24\20\3\2"+
		"\2\2\24\21\3\2\2\2\24\22\3\2\2\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2"+
		"\2\2\26\27\3\2\2\2\27\3\3\2\2\2\30\31\7\3\2\2\31\32\t\2\2\2\32\33\7\6"+
		"\2\2\33\5\3\2\2\2\34\35\7\3\2\2\35\36\7\17\2\2\36\37\5\b\5\2\37 \7\6\2"+
		"\2 \7\3\2\2\2!\"\7\20\2\2\"\t\3\2\2\2#$\7\3\2\2$%\5\f\7\2%&\7\6\2\2&\13"+
		"\3\2\2\2\'(\7\21\2\2(\r\3\2\2\2)*\7\4\2\2*\17\3\2\2\2\4\24\26";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}