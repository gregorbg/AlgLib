// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Cubic.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.cubic;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CubicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CubicVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubic(CubicParser.CubicContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubicAlg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubicAlg(CubicParser.CubicAlgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubicSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubicSimple(CubicParser.CubicSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubicMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubicMove(CubicParser.CubicMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#singleDepthCubic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleDepthCubic(CubicParser.SingleDepthCubicContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#nDepthCubic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNDepthCubic(CubicParser.NDepthCubicContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#centralSliceCubic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCentralSliceCubic(CubicParser.CentralSliceCubicContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#outerSliceCubic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOuterSliceCubic(CubicParser.OuterSliceCubicContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubicComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubicComm(CubicParser.CubicCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubicPureComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubicPureComm(CubicParser.CubicPureCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link CubicParser#cubicSetupComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCubicSetupComm(CubicParser.CubicSetupCommContext ctx);
}