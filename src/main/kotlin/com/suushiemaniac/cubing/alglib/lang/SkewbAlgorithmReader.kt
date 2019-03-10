package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.CombinedAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.Conjugate
import com.suushiemaniac.cubing.alglib.antlr.SkewbBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.SkewbLexer
import com.suushiemaniac.cubing.alglib.antlr.SkewbParser
import com.suushiemaniac.cubing.alglib.move.SkewbMove
import com.suushiemaniac.cubing.alglib.move.modifier.SkewbModifier
import com.suushiemaniac.cubing.alglib.move.plane.SkewbPlane
import com.suushiemaniac.cubing.alglib.util.ParseUtils.fromNotation

class SkewbAlgorithmReader : SkewbBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader = SkewbMoveReader()
    private val commReader = SkewbCommReader(this)

    override fun parse(input: String): Algorithm {
        return NotationReader.parseString(input, ::SkewbLexer, ::SkewbParser, SkewbParser::skewb, this::visit)
    }

    private inner class SkewbMoveReader : SkewbBaseVisitor<SkewbMove>() {
        override fun visitSkewbMove(ctx: SkewbParser.SkewbMoveContext): SkewbMove {
            val plane = SkewbPlane.values().fromNotation(ctx.SKEWB_PLANE().text)

            val modifNotation = if (ctx.SKEWB_MODIFIER() == null) "" else ctx.SKEWB_MODIFIER().text
            val modifier = SkewbModifier.values().fromNotation(modifNotation)

            return SkewbMove(plane, modifier)
        }
    }

    private inner class SkewbCommReader(private val algorithmReader: SkewbAlgorithmReader) : SkewbBaseVisitor<CombinedAlg>() {
        override fun visitSkewbPureComm(ctx: SkewbParser.SkewbPureCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.skewbAlg(0))
            val partB = this.algorithmReader.visit(ctx.skewbAlg(1))

            return Commutator(partA, partB)
        }

        override fun visitSkewbSetupComm(ctx: SkewbParser.SkewbSetupCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.skewbAlg(0))
            val partB = this.algorithmReader.visit(ctx.skewbAlg(1))

            return Conjugate(partA, partB)
        }
    }

    override fun visitSkewb(ctx: SkewbParser.SkewbContext): Algorithm {
        return if (ctx.skewbAlg() != null) this.visit(ctx.skewbAlg()) else SimpleAlg()
    }

    override fun visitSkewbSimple(ctx: SkewbParser.SkewbSimpleContext): SimpleAlg {
        return SimpleAlg(ctx.skewbMove().map(this.moveReader::visit))
    }

    override fun visitSkewbComm(ctx: SkewbParser.SkewbCommContext): Algorithm {
        return this.commReader.visit(ctx)
    }
}
