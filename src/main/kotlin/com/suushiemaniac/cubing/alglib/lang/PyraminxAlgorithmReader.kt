package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.PyraminxBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.PyraminxLexer
import com.suushiemaniac.cubing.alglib.antlr.PyraminxParser
import com.suushiemaniac.cubing.alglib.move.PyraminxMove
import com.suushiemaniac.cubing.alglib.move.modifier.PyraminxModifier
import com.suushiemaniac.cubing.alglib.move.plane.PyraminxPlane
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class PyraminxAlgorithmReader : PyraminxBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader: PyraminxMoveReader
    private val commReader: PyraminxCommReader

    override fun parse(input: String): Algorithm {
        val errorListener = InvalidNotationErrorListener(input)
        val lexer = PyraminxLexer(CharStreams.fromString(input))
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = PyraminxParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        val tree = parser.pyraminx()
        return this.visit(tree)
    }

    private inner class PyraminxMoveReader : PyraminxBaseVisitor<PyraminxMove>() {
        override fun visitPyraminxFullMove(ctx: PyraminxParser.PyraminxFullMoveContext): PyraminxMove {
            val plane = PyraminxPlane.fromNotation(ctx.PYRAMINX_FULL_PLANE().text)
            val modifier = PyraminxModifier.fromNotation(if (ctx.PYRAMINX_MODIFIER() == null) "" else ctx.PYRAMINX_MODIFIER().text)

            return PyraminxMove(plane!!, modifier!!, 1)
        }

        override fun visitPyraminxTipMove(ctx: PyraminxParser.PyraminxTipMoveContext): PyraminxMove {
            val plane = PyraminxPlane.fromNotation(ctx.PYRAMINX_TIP_PLANE().text.toUpperCase())
            val modifier = PyraminxModifier.fromNotation(if (ctx.PYRAMINX_MODIFIER() == null) "" else ctx.PYRAMINX_MODIFIER().text)

            return PyraminxMove(plane!!, modifier!!, 0)
        }
    }

    private inner class PyraminxCommReader(private val algorithmReader: PyraminxAlgorithmReader) : PyraminxBaseVisitor<Commutator>() {
        override fun visitPyraminxPureComm(ctx: PyraminxParser.PyraminxPureCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.pyraminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.pyraminxAlg(1))

            return PureComm(partA, partB)
        }

        override fun visitPyraminxSetupComm(ctx: PyraminxParser.PyraminxSetupCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.pyraminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.pyraminxAlg(1))

            return SetupComm(partA, partB)
        }
    }

    init {
        this.moveReader = PyraminxMoveReader()
        this.commReader = PyraminxCommReader(this)
    }

    override fun visitPyraminx(ctx: PyraminxParser.PyraminxContext): Algorithm {
        return if (ctx.pyraminxAlg() != null) this.visit(ctx.pyraminxAlg()) else SimpleAlg()
    }

    override fun visitPyraminxSimple(ctx: PyraminxParser.PyraminxSimpleContext): SimpleAlg {
        val moves = ctx.pyraminxMove().map { this.moveReader.visit(it) }.toTypedArray()
        return SimpleAlg(*moves)
    }

    override fun visitPyraminxComm(ctx: PyraminxParser.PyraminxCommContext): Algorithm {
        return this.commReader.visit(ctx)
    }
}
