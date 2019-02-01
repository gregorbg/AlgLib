package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.CubicBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.CubicLexer
import com.suushiemaniac.cubing.alglib.antlr.CubicParser
import com.suushiemaniac.cubing.alglib.move.CubicMove
import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane
import com.suushiemaniac.cubing.alglib.util.ParseUtils.fromNotation

class CubicAlgorithmReader : CubicBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader = CubicMoveReader()
    private val commReader = CubicCommReader(this)

    override fun parse(input: String): Algorithm {
        return NotationReader.parseString(input, ::CubicLexer, ::CubicParser, CubicParser::cubic, this::visit)
    }

    private inner class CubicMoveReader : CubicBaseVisitor<CubicMove>() {
        private val modifierReader = CubicModifierReader()

        override fun visitSingleDepthCubic(ctx: CubicParser.SingleDepthCubicContext): CubicMove {
            val plane = CubicPlane.values().fromNotation(ctx.CUBIC_PLANE().text)
            val modifier = this.modifierReader.visit(ctx.cubicModifier())

            return CubicMove(plane, modifier, 1)
        }

        override fun visitOuterSliceCubic(ctx: CubicParser.OuterSliceCubicContext): CubicMove {
            val plane = CubicPlane.values().fromNotation(ctx.CUBIC_OUTER_SLICE().text)
            val modifier = this.modifierReader.visit(ctx.cubicModifier())
            val depth = if (ctx.CUBIC_DEPTH() == null) if (ctx.CUBIC_MODIFIER_DOUBLE() == null) 1 else 2 else Integer.parseInt(ctx.CUBIC_DEPTH().text)

            return CubicMove(plane, modifier, depth)
        }

        override fun visitCentralSliceCubic(ctx: CubicParser.CentralSliceCubicContext): CubicMove {
            val plane = CubicPlane.values().fromNotation(ctx.CUBIC_CENTRAL_SLICE().text)
            val modifier = this.modifierReader.visit(ctx.cubicModifier())

            return CubicMove(plane, modifier, 1)
        }

        override fun visitNDepthCubic(ctx: CubicParser.NDepthCubicContext): CubicMove {
            val plane = CubicPlane.values().fromNotation(ctx.CUBIC_PLANE().text)
            val modifier = this.modifierReader.visit(ctx.cubicModifier())
            val depth = if (ctx.CUBIC_DEPTH() == null) 2 else Integer.parseInt(ctx.CUBIC_DEPTH().text)

            return CubicMove(plane, modifier, depth)
        }
    }

    private inner class CubicModifierReader : CubicBaseVisitor<CubicModifier>() {
        override fun visitCubicModifier(ctx: CubicParser.CubicModifierContext): CubicModifier {
            return when {
                ctx.CUBIC_MODIFIER_DOUBLE() != null -> CubicModifier.DOUBLE
                ctx.CUBIC_MODIFIER_CCW() != null -> CubicModifier.CCW
                else -> CubicModifier.CW
            }
        }
    }

    private inner class CubicCommReader(private val algorithmReader: CubicAlgorithmReader) : CubicBaseVisitor<Commutator>() {
        override fun visitCubicPureComm(ctx: CubicParser.CubicPureCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.cubicAlg(0))
            val partB = this.algorithmReader.visit(ctx.cubicAlg(1))

            return PureComm(partA, partB)
        }

        override fun visitCubicSetupComm(ctx: CubicParser.CubicSetupCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.cubicAlg(0))
            val partB = this.algorithmReader.visit(ctx.cubicAlg(1))

            return SetupComm(partA, partB)
        }
    }

    override fun visitCubic(ctx: CubicParser.CubicContext): Algorithm {
        return if (ctx.cubicAlg() != null) this.visit(ctx.cubicAlg()) else SimpleAlg()
    }

    override fun visitCubicSimple(ctx: CubicParser.CubicSimpleContext): SimpleAlg {
        return SimpleAlg(ctx.cubicMove().map(this.moveReader::visit))
    }

    override fun visitCubicComm(ctx: CubicParser.CubicCommContext): Commutator {
        return this.commReader.visit(ctx)
    }
}