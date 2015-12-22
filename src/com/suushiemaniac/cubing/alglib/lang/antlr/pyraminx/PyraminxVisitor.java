// Generated from C:/Users/suushie_maniac/Desktop/tnoodle-master/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar\Pyraminx.g4 by ANTLR 4.5.1
package com.suushiemaniac.cubing.alglib.lang.antlr.pyraminx;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PyraminxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PyraminxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminx(PyraminxParser.PyraminxContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxAlg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxAlg(PyraminxParser.PyraminxAlgContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxMove(PyraminxParser.PyraminxMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxFullMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxFullMove(PyraminxParser.PyraminxFullMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxTipMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxTipMove(PyraminxParser.PyraminxTipMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxComm(PyraminxParser.PyraminxCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxPureComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxPureComm(PyraminxParser.PyraminxPureCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyraminxParser#pyraminxSetupComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPyraminxSetupComm(PyraminxParser.PyraminxSetupCommContext ctx);
}