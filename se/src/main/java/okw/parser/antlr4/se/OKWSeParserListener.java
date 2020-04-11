// Generated from OKWSeParser.g4 by ANTLR 4.8

package okw.parser.antlr4.se;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OKWSeParser}.
 */
public interface OKWSeParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(OKWSeParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(OKWSeParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_internal_var(OKWSeParser.Okw_internal_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_internal_var(OKWSeParser.Okw_internal_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#okw_typekey}.
	 * @param ctx the parse tree
	 */
	void enterOkw_typekey(OKWSeParser.Okw_typekeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#okw_typekey}.
	 * @param ctx the parse tree
	 */
	void exitOkw_typekey(OKWSeParser.Okw_typekeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void enterKeyvalue(OKWSeParser.KeyvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#keyvalue}.
	 * @param ctx the parse tree
	 */
	void exitKeyvalue(OKWSeParser.KeyvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_env_var(OKWSeParser.Okw_env_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_env_var(OKWSeParser.Okw_env_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#envvalue}.
	 * @param ctx the parse tree
	 */
	void enterEnvvalue(OKWSeParser.EnvvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#envvalue}.
	 * @param ctx the parse tree
	 */
	void exitEnvvalue(OKWSeParser.EnvvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWSeParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(OKWSeParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWSeParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(OKWSeParser.TextContext ctx);
}