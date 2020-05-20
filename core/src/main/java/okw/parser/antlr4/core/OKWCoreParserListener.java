// Generated from OKWCoreParser.g4 by ANTLR 4.8

package okw.parser.antlr4.core;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OKWCoreParser}.
 */
public interface OKWCoreParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OKWCoreParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(OKWCoreParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWCoreParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(OKWCoreParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWCoreParser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_internal_var(OKWCoreParser.Okw_internal_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWCoreParser#okw_internal_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_internal_var(OKWCoreParser.Okw_internal_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWCoreParser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void enterOkw_env_var(OKWCoreParser.Okw_env_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWCoreParser#okw_env_var}.
	 * @param ctx the parse tree
	 */
	void exitOkw_env_var(OKWCoreParser.Okw_env_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWCoreParser#envvalue}.
	 * @param ctx the parse tree
	 */
	void enterEnvvalue(OKWCoreParser.EnvvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWCoreParser#envvalue}.
	 * @param ctx the parse tree
	 */
	void exitEnvvalue(OKWCoreParser.EnvvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link OKWCoreParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(OKWCoreParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link OKWCoreParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(OKWCoreParser.TextContext ctx);
}