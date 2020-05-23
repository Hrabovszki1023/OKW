// Generated from OKWSeParser.g4 by ANTLR 4.7.2
 package okw.parser.antlr4.se; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OKWSeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KLAMMERAUF=1, TEXT=2, WS=3, KLAMMERZU=4, PLUS=5, ALT=6, CTRL=7, SHIFT=8, 
		COMMAND=9, KEYVALUE=10, VALUE=11;
	public static final int
		RULE_root = 0, RULE_typekey = 1, RULE_keyvalue = 2, RULE_modifierkey = 3, 
		RULE_value = 4, RULE_text = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "typekey", "keyvalue", "modifierkey", "value", "text"
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

	@Override
	public String getGrammarFileName() { return "OKWSeParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OKWSeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RootContext extends ParserRuleContext {
		public List<TypekeyContext> typekey() {
			return getRuleContexts(TypekeyContext.class);
		}
		public TypekeyContext typekey(int i) {
			return getRuleContext(TypekeyContext.class,i);
		}
		public List<KeyvalueContext> keyvalue() {
			return getRuleContexts(KeyvalueContext.class);
		}
		public KeyvalueContext keyvalue(int i) {
			return getRuleContext(KeyvalueContext.class,i);
		}
		public List<ModifierkeyContext> modifierkey() {
			return getRuleContexts(ModifierkeyContext.class);
		}
		public ModifierkeyContext modifierkey(int i) {
			return getRuleContext(ModifierkeyContext.class,i);
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
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitRoot(this);
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
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(16);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case KLAMMERAUF:
					{
					setState(12);
					typekey();
					}
					break;
				case KEYVALUE:
					{
					setState(13);
					keyvalue();
					}
					break;
				case ALT:
				case CTRL:
				case SHIFT:
				case COMMAND:
					{
					setState(14);
					modifierkey();
					}
					break;
				case TEXT:
					{
					setState(15);
					text();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KLAMMERAUF) | (1L << TEXT) | (1L << ALT) | (1L << CTRL) | (1L << SHIFT) | (1L << COMMAND) | (1L << KEYVALUE))) != 0) );
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

	public static class TypekeyContext extends ParserRuleContext {
		public TerminalNode KLAMMERAUF() { return getToken(OKWSeParser.KLAMMERAUF, 0); }
		public TerminalNode KLAMMERZU() { return getToken(OKWSeParser.KLAMMERZU, 0); }
		public List<ModifierkeyContext> modifierkey() {
			return getRuleContexts(ModifierkeyContext.class);
		}
		public ModifierkeyContext modifierkey(int i) {
			return getRuleContext(ModifierkeyContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(OKWSeParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(OKWSeParser.PLUS, i);
		}
		public List<KeyvalueContext> keyvalue() {
			return getRuleContexts(KeyvalueContext.class);
		}
		public KeyvalueContext keyvalue(int i) {
			return getRuleContext(KeyvalueContext.class,i);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TypekeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typekey; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitTypekey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypekeyContext typekey() throws RecognitionException {
		TypekeyContext _localctx = new TypekeyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typekey);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(KLAMMERAUF);
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALT) | (1L << CTRL) | (1L << SHIFT) | (1L << COMMAND))) != 0)) {
				{
				setState(21);
				modifierkey();
				}
			}

			setState(28);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					match(PLUS);
					setState(25);
					modifierkey();
					}
					} 
				}
				setState(30);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					match(PLUS);
					setState(32);
					keyvalue();
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(38);
				match(PLUS);
				setState(39);
				value();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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

	public static class KeyvalueContext extends ParserRuleContext {
		public TerminalNode KEYVALUE() { return getToken(OKWSeParser.KEYVALUE, 0); }
		public KeyvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyvalue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitKeyvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyvalueContext keyvalue() throws RecognitionException {
		KeyvalueContext _localctx = new KeyvalueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(KEYVALUE);
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

	public static class ModifierkeyContext extends ParserRuleContext {
		public ModifierkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierkey; }
	 
		public ModifierkeyContext() { }
		public void copyFrom(ModifierkeyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ShiftContext extends ModifierkeyContext {
		public TerminalNode SHIFT() { return getToken(OKWSeParser.SHIFT, 0); }
		public ShiftContext(ModifierkeyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CommandContext extends ModifierkeyContext {
		public TerminalNode COMMAND() { return getToken(OKWSeParser.COMMAND, 0); }
		public CommandContext(ModifierkeyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AltContext extends ModifierkeyContext {
		public TerminalNode ALT() { return getToken(OKWSeParser.ALT, 0); }
		public AltContext(ModifierkeyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitAlt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtrlContext extends ModifierkeyContext {
		public TerminalNode CTRL() { return getToken(OKWSeParser.CTRL, 0); }
		public CtrlContext(ModifierkeyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitCtrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierkeyContext modifierkey() throws RecognitionException {
		ModifierkeyContext _localctx = new ModifierkeyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_modifierkey);
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALT:
				_localctx = new AltContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(ALT);
				}
				break;
			case CTRL:
				_localctx = new CtrlContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(CTRL);
				}
				break;
			case SHIFT:
				_localctx = new ShiftContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(SHIFT);
				}
				break;
			case COMMAND:
				_localctx = new CommandContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				match(COMMAND);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(OKWSeParser.VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(VALUE);
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
		public TerminalNode TEXT() { return getToken(OKWSeParser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OKWSeParserVisitor ) return ((OKWSeParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\3\3\3\5\3\31\n\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3\3\7\3$"+
		"\n\3\f\3\16\3\'\13\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\5\58\n\5\3\6\3\6\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f\2\2\2B\2"+
		"\22\3\2\2\2\4\26\3\2\2\2\6\61\3\2\2\2\b\67\3\2\2\2\n9\3\2\2\2\f;\3\2\2"+
		"\2\16\23\5\4\3\2\17\23\5\6\4\2\20\23\5\b\5\2\21\23\5\f\7\2\22\16\3\2\2"+
		"\2\22\17\3\2\2\2\22\20\3\2\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2"+
		"\2\24\25\3\2\2\2\25\3\3\2\2\2\26\30\7\3\2\2\27\31\5\b\5\2\30\27\3\2\2"+
		"\2\30\31\3\2\2\2\31\36\3\2\2\2\32\33\7\7\2\2\33\35\5\b\5\2\34\32\3\2\2"+
		"\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37%\3\2\2\2 \36\3\2\2\2!\""+
		"\7\7\2\2\"$\5\6\4\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&,\3\2\2\2"+
		"\'%\3\2\2\2()\7\7\2\2)+\5\n\6\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2"+
		"\2-/\3\2\2\2.,\3\2\2\2/\60\7\6\2\2\60\5\3\2\2\2\61\62\7\f\2\2\62\7\3\2"+
		"\2\2\638\7\b\2\2\648\7\t\2\2\658\7\n\2\2\668\7\13\2\2\67\63\3\2\2\2\67"+
		"\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28\t\3\2\2\29:\7\r\2\2:\13\3\2\2"+
		"\2;<\7\4\2\2<\r\3\2\2\2\t\22\24\30\36%,\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}