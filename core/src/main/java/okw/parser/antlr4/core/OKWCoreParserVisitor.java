// Generated from OKWCoreParser.g4 by ANTLR 4.8

package okw.parser.antlr4.core;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OKWCoreParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OKWCoreParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(OKWCoreParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#okw_internal_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_internal_var(OKWCoreParser.Okw_internal_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#okw_typekey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_typekey(OKWCoreParser.Okw_typekeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(OKWCoreParser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#okw_env_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_env_var(OKWCoreParser.Okw_env_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#envvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvvalue(OKWCoreParser.EnvvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWCoreParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(OKWCoreParser.TextContext ctx);
}