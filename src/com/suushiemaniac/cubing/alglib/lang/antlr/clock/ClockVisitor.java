// Generated from /jvdocs/AlgLib/src/com/suushiemaniac/cubing/alglib/lang/res/grammar/Clock.g4 by ANTLR 4.5.3
package com.suushiemaniac.cubing.alglib.lang.antlr.clock;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ClockParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ClockVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ClockParser#clock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClock(ClockParser.ClockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#clockAlg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockAlg(ClockParser.ClockAlgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#clockSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockSimple(ClockParser.ClockSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#clockMove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockMove(ClockParser.ClockMoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#turnPinClock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTurnPinClock(ClockParser.TurnPinClockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#rotationClock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRotationClock(ClockParser.RotationClockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#endPinClock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndPinClock(ClockParser.EndPinClockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#clockComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockComm(ClockParser.ClockCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#clockPureComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockPureComm(ClockParser.ClockPureCommContext ctx);
	/**
	 * Visit a parse tree produced by {@link ClockParser#clockSetupComm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClockSetupComm(ClockParser.ClockSetupCommContext ctx);
}