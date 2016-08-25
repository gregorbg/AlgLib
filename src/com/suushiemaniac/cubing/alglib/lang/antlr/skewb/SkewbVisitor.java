// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Skewb.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.skewb;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SkewbParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SkewbVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewb}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewb(SkewbParser.SkewbContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewbAlg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewbAlg(SkewbParser.SkewbAlgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewbSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewbSimple(SkewbParser.SkewbSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewbMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewbMove(SkewbParser.SkewbMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewbComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewbComm(SkewbParser.SkewbCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewbPureComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewbPureComm(SkewbParser.SkewbPureCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link SkewbParser#skewbSetupComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkewbSetupComm(SkewbParser.SkewbSetupCommContext ctx);
}