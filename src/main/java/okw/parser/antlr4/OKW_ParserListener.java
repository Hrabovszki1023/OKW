package okw.parser.antlr4;

// Generated from OKW_Parser.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OKW_Parser}.
 */
public interface OKW_ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#envvalue}.
	 * @param ctx the parse tree
	 */
	void enterEnvvalue(@NotNull OKW_Parser.EnvvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#envvalue}.
	 * @param ctx the parse tree
	 */
	void exitEnvvalue(@NotNull OKW_Parser.EnvvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_internal_var(@NotNull OKW_Parser.Okw_internal_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_internal_var(@NotNull OKW_Parser.Okw_internal_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull OKW_Parser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull OKW_Parser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull OKW_Parser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull OKW_Parser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_env_var(@NotNull OKW_Parser.Okw_env_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_env_var(@NotNull OKW_Parser.Okw_env_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#okw_typekey}.
	 * @param ctx the parse tree
	 */
	void enterOkw_typekey(@NotNull OKW_Parser.Okw_typekeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#okw_typekey}.
	 * @param ctx the parse tree
	 */
	void exitOkw_typekey(@NotNull OKW_Parser.Okw_typekeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue(@NotNull OKW_Parser.KeyvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue(@NotNull OKW_Parser.KeyvalueContext ctx);
}