// Generated from OKWSeParser.g4 by ANTLR 4.7.2
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
	 * Visit a parse tree produced by {@link OKWSeParser#typekey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypekey(OKWSeParser.TypekeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#keyvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyvalue(OKWSeParser.KeyvalueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Alt}
	 * labeled alternative in {@link OKWSeParser#modifierkey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlt(OKWSeParser.AltContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Ctrl}
	 * labeled alternative in {@link OKWSeParser#modifierkey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtrl(OKWSeParser.CtrlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Shift}
	 * labeled alternative in {@link OKWSeParser#modifierkey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift(OKWSeParser.ShiftContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Command}
	 * labeled alternative in {@link OKWSeParser#modifierkey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(OKWSeParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(OKWSeParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link OKWSeParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(OKWSeParser.TextContext ctx);
}