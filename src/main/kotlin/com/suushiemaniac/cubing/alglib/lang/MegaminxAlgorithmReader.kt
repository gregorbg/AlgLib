package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm
import com.suushiemaniac.cubing.alglib.antlr.MegaminxBaseVisitor
import com.suushiemaniac.cubing.alglib.antlr.MegaminxLexer
import com.suushiemaniac.cubing.alglib.antlr.MegaminxParser
import com.suushiemaniac.cubing.alglib.move.MegaminxMove
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxUpModifier
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxWideModifier
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxUpPlane
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxWidePlane
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

class MegaminxAlgorithmReader : MegaminxBaseVisitor<Algorithm>(), NotationReader {
    private val moveReader: MegaminxMoveReader
    private val commReader: MegaminxCommReader

    override fun parse(input: String): Algorithm {
        val errorListener = InvalidNotationErrorListener(input)
        val lexer = MegaminxLexer(CharStreams.fromString(input))
        lexer.removeErrorListeners()
        lexer.addErrorListener(errorListener)
        val tokens = CommonTokenStream(lexer)
        val parser = MegaminxParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(errorListener)
        val tree = parser.megaminx()
        return this.visit(tree)
    }

    private inner class MegaminxMoveReader : MegaminxBaseVisitor<MegaminxMove>() {
        override fun visitGripMegaminx(ctx: MegaminxParser.GripMegaminxContext): MegaminxMove {
            val plane = MegaminxWidePlane.fromNotation(ctx.MEGAMINX_WIDE_PLANE().text)
            val modifier = MegaminxWideModifier.fromNotation(ctx.MEGAMINX_WIDE_MODIFIER().text)
            return MegaminxMove(plane!!, modifier!!)
        }

        override fun visitUMegaminx(ctx: MegaminxParser.UMegaminxContext): MegaminxMove {
            val plane = MegaminxUpPlane.fromNotation(ctx.MEGAMINX_U_PLANE().text)
            val modifier = MegaminxUpModifier.fromNotation(ctx.MEGAMINX_U_MODIFIER().text)
            return MegaminxMove(plane!!, modifier!!)
        }
    }

    private inner class MegaminxCommReader(private val algorithmReader: MegaminxAlgorithmReader) : MegaminxBaseVisitor<Commutator>() {

        override fun visitMegaminxPureComm(ctx: MegaminxParser.MegaminxPureCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.megaminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.megaminxAlg(1))
            return PureComm(partA, partB)
        }

        override fun visitMegaminxSetupComm(ctx: MegaminxParser.MegaminxSetupCommContext): Commutator {
            val partA = this.algorithmReader.visit(ctx.megaminxAlg(0))
            val partB = this.algorithmReader.visit(ctx.megaminxAlg(1))
            return SetupComm(partA, partB)
        }
    }

    init {
        this.moveReader = MegaminxMoveReader()
        this.commReader = MegaminxCommReader(this)
    }

    override fun visitMegaminx(ctx: MegaminxParser.MegaminxContext): Algorithm {
        return if (ctx.megaminxAlg() != null) this.visit(ctx.megaminxAlg()) else SimpleAlg()
    }

    override fun visitMegaminxSimple(ctx: MegaminxParser.MegaminxSimpleContext): SimpleAlg {
        val moves = ctx.megaminxMove().map { this.moveReader.visit(it) }.toTypedArray()
        return SimpleAlg(*moves)
    }

    override fun visitMegaminxComm(ctx: MegaminxParser.MegaminxCommContext): Commutator {
        return this.commReader.visit(ctx)
    }
}
