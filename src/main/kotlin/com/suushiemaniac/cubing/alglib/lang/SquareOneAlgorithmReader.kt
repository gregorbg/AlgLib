package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.SquareOneBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.SquareOneLexer
import com.suushiemaniac.cubing.alglib.antlr.SquareOneParser
import com.suushiemaniac.cubing.alglib.move.SquareOneMove
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneHalfModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneNumModifier
import com.suushiemaniac.cubing.alglib.util.ArrayUtils.denullify
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.CharStreams

class SquareOneAlgorithmReader : SquareOneBaseVisitor<Algorithm>(), NotationReader {
    private val modifierReader: SquareOneModifierReader
    private val moveReader: SquareOneMoveReader
    private val commReader: SquareOneCommReader

    override fun parse(input: String): Algorithm {
        val errorListener = InvalidNotationErrorListener(input)
        val lexer = SquareOneLexer(CharStreams.fromString(input))
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = SquareOneParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        val tree = parser.squareOne()
        return this.visit(tree)
    }

    private inner class SquareOneMoveReader(private val modifierReader: SquareOneModifierReader) : SquareOneBaseVisitor<SquareOneMove>() {
        override fun visitSquareOneMoveSlash(ctx: SquareOneParser.SquareOneMoveSlashContext): SquareOneMove {
            val modifier = this.modifierReader.visit(ctx.squareOneModifier())
            val endSlash = ctx.SQUARE_ONE_SLASH() != null
            return SquareOneMove(modifier, false, endSlash)
        }
    }

    private inner class SquareOneModifierReader : SquareOneBaseVisitor<SquareOneModifier>() {
        private val halfModifierReader = SquareOneHalfModifierReader()

        override fun visitSquareOneModifier(ctx: SquareOneParser.SquareOneModifierContext): SquareOneModifier {
            val halfUp = this.halfModifierReader.visit(ctx.squareOneFaceTurn(0))
            val halfDown = this.halfModifierReader.visit(ctx.squareOneFaceTurn(1))
            return SquareOneModifier(halfUp, halfDown)
        }
    }

    private inner class SquareOneHalfModifierReader : SquareOneBaseVisitor<SquareOneHalfModifier>() {
        override fun visitSquareOneFaceTurn(ctx: SquareOneParser.SquareOneFaceTurnContext): SquareOneHalfModifier {
            val directionModifier = SquareOneDirectionModifier.fromNotation(if (ctx.SQUARE_ONE_PLANE_ZERO() == null) if (ctx.SQUARE_ONE_DIRECTION_MODIFIER() == null) "" else ctx.SQUARE_ONE_DIRECTION_MODIFIER().text else "")
            val halfModifier = SquareOneNumModifier.fromNotation(if (ctx.SQUARE_ONE_PLANE_ZERO() == null) ctx.SQUARE_ONE_PLANE_POS().text else "0")
            return SquareOneHalfModifier(directionModifier!!, halfModifier!!)
        }
    }

    private inner class SquareOneCommReader(private val algorithmReader: SquareOneAlgorithmReader) : SquareOneBaseVisitor<Commutator>() {
        override fun visitSquareOnePureComm(ctx: SquareOneParser.SquareOnePureCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.squareOneAlg(0))
            val partB = this.algorithmReader.visit(ctx.squareOneAlg(1))
            return PureComm(partA, partB)
        }

        override fun visitSquareOneSetupComm(ctx: SquareOneParser.SquareOneSetupCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.squareOneAlg(0))
            val partB = this.algorithmReader.visit(ctx.squareOneAlg(1))
            return SetupComm(partA, partB)
        }
    }

    init {
        this.modifierReader = SquareOneModifierReader()
        this.moveReader = SquareOneMoveReader(this.modifierReader)
        this.commReader = SquareOneCommReader(this)
    }

    override fun visitSquareOne(ctx: SquareOneParser.SquareOneContext): Algorithm {
        return if (ctx.squareOneAlg() != null) this.visit(ctx.squareOneAlg()) else SimpleAlg()
    }

    override fun visitSquareOneSimple(ctx: SquareOneParser.SquareOneSimpleContext): SimpleAlg {
        val moves = arrayOfNulls<SquareOneMove>(ctx.squareOneMoveSlash().size + 1)
        val firstModifier = this.modifierReader.visit(if (ctx.squareOneMoveSlash().size > 0) ctx.squareOneMoveSlash(0).squareOneModifier() else ctx.squareOneModifier())
        val firstBeginSlash = ctx.squareOneBeginSlash() != null
        val firstEndSlash = (if (ctx.squareOneMoveSlash().size > 0) ctx.squareOneMoveSlash(0).SQUARE_ONE_SLASH() else ctx.SQUARE_ONE_SLASH()) != null
        val firstMove = SquareOneMove(firstModifier, firstBeginSlash, firstEndSlash)
        moves[0] = firstMove
        if (ctx.squareOneMoveSlash().size < 1) return SimpleAlg(*moves.denullify())
        if (ctx.squareOneMoveSlash().size > 1)
            for (i in 1 until ctx.squareOneMoveSlash().size) moves[i] = this.moveReader.visit(ctx.squareOneMoveSlash(i))
        val lastModifier = this.modifierReader.visit(ctx.squareOneModifier())
        val lastEndSlash = ctx.SQUARE_ONE_SLASH() != null
        moves[moves.size - 1] = SquareOneMove(lastModifier, false, lastEndSlash)
        return SimpleAlg(*moves.denullify())
    }

    override fun visitSquareOneComm(ctx: SquareOneParser.SquareOneCommContext): Commutator {
        return this.commReader.visit(ctx)
    }
}