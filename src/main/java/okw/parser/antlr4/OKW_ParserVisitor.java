// Generated from OKW_Parser.g4 by ANTLR 4.5.2

package okw.parser.antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OKW_Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OKW_ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(OKW_Parser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#okw_internal_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_internal_var(OKW_Parser.Okw_internal_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#okw_typekey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_typekey(OKW_Parser.Okw_typekeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(OKW_Parser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#okw_env_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOkw_env_var(OKW_Parser.Okw_env_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#envvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnvvalue(OKW_Parser.EnvvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKW_Parser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(OKW_Parser.TextContext ctx);
}