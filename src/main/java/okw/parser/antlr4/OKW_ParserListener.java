// Generated from OKW_Parser.g4 by ANTLR 4.5.2

package okw.parser.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OKW_Parser}.
 */
public interface OKW_ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(OKW_Parser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(OKW_Parser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_internal_var(OKW_Parser.Okw_internal_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_internal_var(OKW_Parser.Okw_internal_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#okw_typekey}.
	 * @param ctx the parse tree
	 */
	void enterOkw_typekey(OKW_Parser.Okw_typekeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#okw_typekey}.
	 * @param ctx the parse tree
	 */
	void exitOkw_typekey(OKW_Parser.Okw_typekeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue(OKW_Parser.KeyvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue(OKW_Parser.KeyvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_env_var(OKW_Parser.Okw_env_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_env_var(OKW_Parser.Okw_env_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#envvalue}.
	 * @param ctx the parse tree
	 */
	void enterEnvvalue(OKW_Parser.EnvvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#envvalue}.
	 * @param ctx the parse tree
	 */
	void exitEnvvalue(OKW_Parser.EnvvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKW_Parser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(OKW_Parser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKW_Parser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(OKW_Parser.TextContext ctx);
}