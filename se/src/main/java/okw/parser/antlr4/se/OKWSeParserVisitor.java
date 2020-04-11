// Generated from OKWSeParser.g4 by ANTLR 4.8

package okw.parser.antlr4.se;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OKWSeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OKWSeParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(OKWSeParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#okw_internal_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_internal_var(OKWSeParser.Okw_internal_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#okw_typekey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_typekey(OKWSeParser.Okw_typekeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(OKWSeParser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#okw_env_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_env_var(OKWSeParser.Okw_env_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#envvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvvalue(OKWSeParser.EnvvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(OKWSeParser.TextContext ctx);
}