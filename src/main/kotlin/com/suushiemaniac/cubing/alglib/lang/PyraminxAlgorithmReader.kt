package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.CombinedAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.Conjugate
import com.suushiemaniac.cubing.alglib.antlr.PyraminxBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.PyraminxLexer
import com.suushiemaniac.cubing.alglib.antlr.PyraminxParser
import com.suushiemaniac.cubing.alglib.move.PyraminxMove
import com.suushiemaniac.cubing.alglib.move.modifier.PyraminxModifier
import com.suushiemaniac.cubing.alglib.move.plane.PyraminxPlane
import com.suushiemaniac.cubing.alglib.util.ParseUtils.fromNotation

class PyraminxAlgorithmReader : PyraminxBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader = PyraminxMoveReader()
    private val commReader = PyraminxCommReader(this)

    override fun parse(input: String): Algorithm {
        return NotationReader.parseString(input, ::PyraminxLexer, ::PyraminxParser, PyraminxParser::pyraminx, this::visit)
    }

    private inner class PyraminxMoveReader : PyraminxBaseVisitor<PyraminxMove>() {
        override fun visitPyraminxFullMove(ctx: PyraminxParser.PyraminxFullMoveContext): PyraminxMove {
            val plane = PyraminxPlane.values().fromNotation(ctx.PYRAMINX_FULL_PLANE().text)
            val modifier = PyraminxModifier.values().fromNotation(ctx.PYRAMINX_MODIFIER()?.text ?: "")

            return PyraminxMove(plane, modifier, 1)
        }

        override fun visitPyraminxTipMove(ctx: PyraminxParser.PyraminxTipMoveContext): PyraminxMove {
            val plane = PyraminxPlane.values().fromNotation(ctx.PYRAMINX_TIP_PLANE().text.toUpperCase())
            val modifier = PyraminxModifier.values().fromNotation(ctx.PYRAMINX_MODIFIER()?.text ?: "")

            return PyraminxMove(plane, modifier, 0)
        }
    }

    private inner class PyraminxCommReader(private val algorithmReader: PyraminxAlgorithmReader) : PyraminxBaseVisitor<CombinedAlg>() {
        override fun visitPyraminxPureComm(ctx: PyraminxParser.PyraminxPureCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.pyraminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.pyraminxAlg(1))

            return Commutator(partA, partB)
        }

        override fun visitPyraminxSetupComm(ctx: PyraminxParser.PyraminxSetupCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.pyraminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.pyraminxAlg(1))

            return Conjugate(partA, partB)
        }
    }

    override fun visitPyraminx(ctx: PyraminxParser.PyraminxContext): Algorithm {
        return if (ctx.pyraminxAlg() != null) this.visit(ctx.pyraminxAlg()) else SimpleAlg()
    }

    override fun visitPyraminxSimple(ctx: PyraminxParser.PyraminxSimpleContext): SimpleAlg {
        return SimpleAlg(ctx.pyraminxMove().map(this.moveReader::visit))
    }

    override fun visitPyraminxComm(ctx: PyraminxParser.PyraminxCommContext): Algorithm {
        return this.commReader.visit(ctx)
    }
}
