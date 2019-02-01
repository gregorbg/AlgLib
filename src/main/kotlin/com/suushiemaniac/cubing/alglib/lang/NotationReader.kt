package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

interface NotationReader {
    fun parse(input: String): Algorithm

    companion object {
        fun <P : Parser> parseString(input: String, lexerGen: (CharStream) -> Lexer, parserGen: (CommonTokenStream) -> P, rootNode: P.() -> ParseTree, visit: (ParseTree) -> Algorithm): Algorithm {
            val errorListener = InvalidNotationErrorListener(input)

            val lexer = lexerGen(CharStreams.fromString(input))

            lexer.removeErrorListeners()
            lexer.addErrorListener(errorListener)

            val tokens = CommonTokenStream(lexer)
            val parser = parserGen(tokens)

            parser.removeErrorListeners()
            parser.addErrorListener(errorListener)

            val tree = parser.rootNode()

            return visit(tree)
        }
    }
}
