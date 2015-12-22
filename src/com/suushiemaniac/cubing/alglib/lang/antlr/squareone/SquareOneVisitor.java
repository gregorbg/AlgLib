// Generated from C:/Users/suushie_maniac/Desktop/tnoodle-master/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar\SquareOne.g4 by ANTLR 4.5.1
package com.suushiemaniac.cubing.alglib.lang.antlr.squareone;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SquareOneParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SquareOneVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOne(SquareOneParser.SquareOneContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneAlg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneAlg(SquareOneParser.SquareOneAlgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneBeginSlash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneBeginSlash(SquareOneParser.SquareOneBeginSlashContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneMoveSlash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneMoveSlash(SquareOneParser.SquareOneMoveSlashContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneModifier(SquareOneParser.SquareOneModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneFaceTurn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneFaceTurn(SquareOneParser.SquareOneFaceTurnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneComm(SquareOneParser.SquareOneCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOnePureComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOnePureComm(SquareOneParser.SquareOnePureCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link SquareOneParser#squareOneSetupComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquareOneSetupComm(SquareOneParser.SquareOneSetupCommContext ctx);
}