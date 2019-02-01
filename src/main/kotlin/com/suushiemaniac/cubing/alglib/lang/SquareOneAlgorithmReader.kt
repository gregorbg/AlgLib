package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.SquareOneBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.SquareOneLexer
import com.suushiemaniac.cubing.alglib.antlr.SquareOneParser
import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.SquareOneMove
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneHalfModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneNumModifier
import com.suushiemaniac.cubing.alglib.util.ParseUtils.fromNotation

class SquareOneAlgorithmReader : SquareOneBaseVisitor<Algorithm>(), NotationReader {
    private val modifierReader = SquareOneModifierReader()

    private val moveReader = SquareOneMoveReader(this.modifierReader)
    private val commReader = SquareOneCommReader(this)

    override fun parse(input: String): Algorithm {
        return NotationReader.parseString(input, ::SquareOneLexer, ::SquareOneParser, SquareOneParser::squareOne, this::visit)
    }

    private inner class SquareOneMoveReader(private val modifierReader: SquareOneModifierReader) : SquareOneBaseVisitor<SquareOneMove>() {
        override fun visitSquareOneModifierSlash(ctx: SquareOneParser.SquareOneModifierSlashContext): SquareOneMove {
            val modifier = this.modifierReader.visit(ctx.squareOneModifier())

            return SquareOneMove(modifier, isBeginSlash = false, isEndSlash = true)
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
            val directNotation = if (ctx.SQUARE_ONE_PLANE_ZERO() == null) if (ctx.SQUARE_ONE_DIRECTION_MODIFIER() == null) "" else ctx.SQUARE_ONE_DIRECTION_MODIFIER().text else ""
            val directionModifier = SquareOneDirectionModifier.values().fromNotation(directNotation)

            val halfNotation = if (ctx.SQUARE_ONE_PLANE_ZERO() == null) ctx.SQUARE_ONE_PLANE_POS().text else "0"
            val halfModifier = SquareOneNumModifier.values().fromNotation(halfNotation)

            return SquareOneHalfModifier(directionModifier, halfModifier)
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

    override fun visitSquareOne(ctx: SquareOneParser.SquareOneContext): Algorithm {
        return if (ctx.squareOneAlg() != null) this.visit(ctx.squareOneAlg()) else SimpleAlg()
    }

    override fun visitSquareOneSimple(ctx: SquareOneParser.SquareOneSimpleContext): SimpleAlg {
        val seqMoves = ctx.squareOneModifierSlash().map(this.moveReader::visit) +
                SquareOneMove(this.modifierReader.visit(ctx.squareOneModifier()), false, ctx.squareOneEndSlash() != null)

        val algMoves = listOf(seqMoves.first().copy(isBeginSlash = ctx.squareOneBeginSlash() != null)) +
                seqMoves.drop(1)

        return SimpleAlg(algMoves)
    }

    override fun visitSquareOneComm(ctx: SquareOneParser.SquareOneCommContext): Commutator {
        return this.commReader.visit(ctx)
    }
}