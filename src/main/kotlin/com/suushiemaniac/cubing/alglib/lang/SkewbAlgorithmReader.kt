package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.SkewbBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.SkewbLexer
import com.suushiemaniac.cubing.alglib.antlr.SkewbParser
import com.suushiemaniac.cubing.alglib.move.SkewbMove
import com.suushiemaniac.cubing.alglib.move.modifier.SkewbModifier
import com.suushiemaniac.cubing.alglib.move.plane.SkewbPlane
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class SkewbAlgorithmReader : SkewbBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader: SkewbMoveReader
    private val commReader: SkewbCommReader

    override fun parse(input: String): Algorithm {
        val errorListener = InvalidNotationErrorListener(input)
        val lexer = SkewbLexer(CharStreams.fromString(input))
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = SkewbParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        val tree = parser.skewb()
        return this.visit(tree)
    }

    private inner class SkewbMoveReader : SkewbBaseVisitor<SkewbMove>() {
        override fun visitSkewbMove(ctx: SkewbParser.SkewbMoveContext): SkewbMove {
            val plane = SkewbPlane.fromNotation(ctx.SKEWB_PLANE().text)
            val modifier = SkewbModifier.fromNotation(if (ctx.SKEWB_MODIFIER() == null) "" else ctx.SKEWB_MODIFIER().text)
            return SkewbMove(plane!!, modifier!!)
        }
    }

    private inner class SkewbCommReader(private val algorithmReader: SkewbAlgorithmReader) : SkewbBaseVisitor<Commutator>() {

        override fun visitSkewbPureComm(ctx: SkewbParser.SkewbPureCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.skewbAlg(0))
            val partB = this.algorithmReader.visit(ctx.skewbAlg(1))
            return PureComm(partA, partB)
        }

        override fun visitSkewbSetupComm(ctx: SkewbParser.SkewbSetupCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.skewbAlg(0))
            val partB = this.algorithmReader.visit(ctx.skewbAlg(1))
            return SetupComm(partA, partB)
        }
    }

    init {
        this.moveReader = SkewbMoveReader()
        this.commReader = SkewbCommReader(this)
    }

    override fun visitSkewb(ctx: SkewbParser.SkewbContext): Algorithm {
        return if (ctx.skewbAlg() != null) this.visit(ctx.skewbAlg()) else SimpleAlg()
    }

    override fun visitSkewbSimple(ctx: SkewbParser.SkewbSimpleContext): SimpleAlg {
        val moves = ctx.skewbMove().map { this.moveReader.visit(it) }.toTypedArray()
        return SimpleAlg(*moves)
    }

    override fun visitSkewbComm(ctx: SkewbParser.SkewbCommContext): Algorithm {
        return this.commReader.visit(ctx)
    }
}
