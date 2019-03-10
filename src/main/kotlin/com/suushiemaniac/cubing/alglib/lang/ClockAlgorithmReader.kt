package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.CombinedAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.Conjugate
import com.suushiemaniac.cubing.alglib.antlr.ClockBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.ClockLexer
import com.suushiemaniac.cubing.alglib.antlr.ClockParser
import com.suushiemaniac.cubing.alglib.move.ClockMove
import com.suushiemaniac.cubing.alglib.move.modifier.ClockDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.ClockNumModifier
import com.suushiemaniac.cubing.alglib.move.plane.ClockPlane
import com.suushiemaniac.cubing.alglib.util.ParseUtils.fromNotation

class ClockAlgorithmReader : ClockBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader = ClockMoveReader()
    private val commReader = ClockCommReader(this)

    override fun parse(input: String): Algorithm {
        return NotationReader.parseString(input, ::ClockLexer, ::ClockParser, ClockParser::clock, this::visit)
    }

    private inner class ClockMoveReader : ClockBaseVisitor<ClockMove>() {
        override fun visitTurnPinClock(ctx: ClockParser.TurnPinClockContext): ClockMove {
            val plane = ClockPlane.values().fromNotation(ctx.CLOCK_PLANE_SINGLE().text)
            val numModifier = ClockNumModifier.values().fromNotation(ctx.CLOCK_NUM_MODIFIER().text)
            val directionModifier = ClockDirectionModifier.values().fromNotation(ctx.CLOCK_DIRECTION_MODIFIER().text)

            return ClockMove(plane, numModifier, directionModifier)
        }

        override fun visitRotationClock(ctx: ClockParser.RotationClockContext): ClockMove {
            return ClockMove(ClockPlane.VERTICAL, ClockNumModifier.TWO, ClockDirectionModifier.POS)
        }

        override fun visitEndPinClock(ctx: ClockParser.EndPinClockContext): ClockMove {
            val plane = ClockPlane.values().fromNotation(ctx.CLOCK_PLANE_SINGLE().text)

            return ClockMove(plane)
        }
    }

    private inner class ClockCommReader(private val algorithmReader: ClockAlgorithmReader) : ClockBaseVisitor<CombinedAlg>() {
        override fun visitClockPureComm(ctx: ClockParser.ClockPureCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.clockAlg(0))
            val partB = this.algorithmReader.visit(ctx.clockAlg(1))

            return Commutator(partA, partB)
        }

        override fun visitClockSetupComm(ctx: ClockParser.ClockSetupCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.clockAlg(0))
            val partB = this.algorithmReader.visit(ctx.clockAlg(1))

            return Conjugate(partA, partB)
        }
    }

    override fun visitClock(ctx: ClockParser.ClockContext): Algorithm {
        return if (ctx.clockAlg() != null) this.visit(ctx.clockAlg()) else SimpleAlg()
    }

    override fun visitClockSimple(ctx: ClockParser.ClockSimpleContext): SimpleAlg {
        val moves = ctx.clockMove().map(this.moveReader::visit).toMutableList()
        ctx.endPinClock()?.let { moves.add(this.moveReader.visit(it)) }

        return SimpleAlg(moves)
    }

    override fun visitClockComm(ctx: ClockParser.ClockCommContext): Algorithm {
        return this.commReader.visit(ctx)
    }
}
