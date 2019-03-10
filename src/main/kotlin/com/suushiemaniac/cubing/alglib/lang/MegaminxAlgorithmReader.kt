package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.CombinedAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.Conjugate
import com.suushiemaniac.cubing.alglib.antlr.MegaminxBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.MegaminxLexer
import com.suushiemaniac.cubing.alglib.antlr.MegaminxParser
import com.suushiemaniac.cubing.alglib.move.MegaminxMove
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxUpModifier
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxWideModifier
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxUpPlane
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxWidePlane
import com.suushiemaniac.cubing.alglib.util.ParseUtils.fromNotation

class MegaminxAlgorithmReader : MegaminxBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader = MegaminxMoveReader()
    private val commReader = MegaminxCommReader(this)

    override fun parse(input: String): Algorithm {
        return NotationReader.parseString(input, ::MegaminxLexer, ::MegaminxParser, MegaminxParser::megaminx, this::visit)
    }

    private inner class MegaminxMoveReader : MegaminxBaseVisitor<MegaminxMove>() {
        override fun visitGripMegaminx(ctx: MegaminxParser.GripMegaminxContext): MegaminxMove {
            val plane = MegaminxWidePlane.values().fromNotation(ctx.MEGAMINX_WIDE_PLANE().text)
            val modifier = MegaminxWideModifier.values().fromNotation(ctx.MEGAMINX_WIDE_MODIFIER().text)

            return MegaminxMove(plane, modifier)
        }

        override fun visitUMegaminx(ctx: MegaminxParser.UMegaminxContext): MegaminxMove {
            val plane = MegaminxUpPlane.values().fromNotation(ctx.MEGAMINX_U_PLANE().text)
            val modifier = MegaminxUpModifier.values().fromNotation(ctx.MEGAMINX_U_MODIFIER().text)

            return MegaminxMove(plane, modifier)
        }
    }

    private inner class MegaminxCommReader(private val algorithmReader: MegaminxAlgorithmReader) : MegaminxBaseVisitor<CombinedAlg>() {
        override fun visitMegaminxPureComm(ctx: MegaminxParser.MegaminxPureCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.megaminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.megaminxAlg(1))
            return Commutator(partA, partB)
        }

        override fun visitMegaminxSetupComm(ctx: MegaminxParser.MegaminxSetupCommContext): CombinedAlg {
            val partA = this.algorithmReader.visit(ctx.megaminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.megaminxAlg(1))
            return Conjugate(partA, partB)
        }
    }

    override fun visitMegaminx(ctx: MegaminxParser.MegaminxContext): Algorithm {
        return if (ctx.megaminxAlg() != null) this.visit(ctx.megaminxAlg()) else SimpleAlg()
    }

    override fun visitMegaminxSimple(ctx: MegaminxParser.MegaminxSimpleContext): SimpleAlg {
        return SimpleAlg(ctx.megaminxMove().map(this.moveReader::visit))
    }

    override fun visitMegaminxComm(ctx: MegaminxParser.MegaminxCommContext): CombinedAlg {
        return this.commReader.visit(ctx)
    }
}
