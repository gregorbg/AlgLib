// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Megaminx.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.megaminx;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MegaminxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MegaminxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminx(MegaminxParser.MegaminxContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminxAlg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminxAlg(MegaminxParser.MegaminxAlgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminxSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminxSimple(MegaminxParser.MegaminxSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminxMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminxMove(MegaminxParser.MegaminxMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#gripMegaminx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGripMegaminx(MegaminxParser.GripMegaminxContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#uMegaminx}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUMegaminx(MegaminxParser.UMegaminxContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminxComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminxComm(MegaminxParser.MegaminxCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminxPureComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminxPureComm(MegaminxParser.MegaminxPureCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link MegaminxParser#megaminxSetupComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMegaminxSetupComm(MegaminxParser.MegaminxSetupCommContext ctx);
}