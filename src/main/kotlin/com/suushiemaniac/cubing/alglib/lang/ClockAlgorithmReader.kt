package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.ClockBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.ClockLexer
import com.suushiemaniac.cubing.alglib.antlr.ClockParser
import com.suushiemaniac.cubing.alglib.move.ClockMove
import com.suushiemaniac.cubing.alglib.move.modifier.ClockDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.ClockNumModifier
import com.suushiemaniac.cubing.alglib.move.plane.ClockPlane
import com.suushiemaniac.cubing.alglib.util.ArrayUtils.denullify
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class ClockAlgorithmReader : ClockBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader: ClockMoveReader
    private val commReader: ClockCommReader

    override fun parse(input: String): Algorithm {
        val errorListener = InvalidNotationErrorListener(input)
        val lexer = ClockLexer(CharStreams.fromString(input))
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = ClockParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        val tree = parser.clock()
        return this.visit(tree)
    }

    private inner class ClockMoveReader : ClockBaseVisitor<ClockMove>() {
        override fun visitTurnPinClock(ctx: ClockParser.TurnPinClockContext): ClockMove {
            val plane = ClockPlane.fromNotation(ctx.CLOCK_PLANE_SINGLE().text)
            val numModifier = ClockNumModifier.fromNotation(ctx.CLOCK_NUM_MODIFIER().text)
            val directionModifier = ClockDirectionModifier.fromNotation(ctx.CLOCK_DIRECTION_MODIFIER().text)

            return ClockMove(plane!!, numModifier!!, directionModifier!!)
        }

        override fun visitRotationClock(ctx: ClockParser.RotationClockContext): ClockMove {
            return ClockMove(ClockPlane.VERTICAL, ClockNumModifier.TWO, ClockDirectionModifier.POS)
        }

        override fun visitEndPinClock(ctx: ClockParser.EndPinClockContext): ClockMove {
            val plane = ClockPlane.fromNotation(ctx.CLOCK_PLANE_SINGLE().text)

            return ClockMove(plane!!)
        }
    }

    private inner class ClockCommReader(private val algorithmReader: ClockAlgorithmReader) : ClockBaseVisitor<Commutator>() {
        override fun visitClockPureComm(ctx: ClockParser.ClockPureCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.clockAlg(0))
            val partB = this.algorithmReader.visit(ctx.clockAlg(1))

            return PureComm(partA, partB)
        }

        override fun visitClockSetupComm(ctx: ClockParser.ClockSetupCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.clockAlg(0))
            val partB = this.algorithmReader.visit(ctx.clockAlg(1))

            return SetupComm(partA, partB)
        }
    }

    init {
        this.moveReader = ClockMoveReader()
        this.commReader = ClockCommReader(this)
    }

    override fun visitClock(ctx: ClockParser.ClockContext): Algorithm {
        return if (ctx.clockAlg() != null) this.visit(ctx.clockAlg()) else SimpleAlg()
    }

    override fun visitClockSimple(ctx: ClockParser.ClockSimpleContext): SimpleAlg {
        val endConfigLength = if (ctx.endPinClock() == null) 0 else 1

        val moves = arrayOfNulls<ClockMove>(ctx.clockMove().size + endConfigLength)
        for (i in 0 until moves.size - endConfigLength) moves[i] = this.moveReader.visit(ctx.clockMove(i))

        if (ctx.endPinClock() != null) moves[moves.size - 1] = this.moveReader.visit(ctx.endPinClock())

        return SimpleAlg(*moves.denullify())
    }

    override fun visitClockComm(ctx: ClockParser.ClockCommContext): Algorithm {
        return this.commReader.visit(ctx)
    }
}
