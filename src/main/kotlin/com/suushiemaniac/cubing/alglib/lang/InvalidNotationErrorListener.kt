package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException
import org.antlr.v4.runtime.BaseErrorListener
import org.antlr.v4.runtime.RecognitionException
import org.antlr.v4.runtime.Recognizer

class InvalidNotationErrorListener(private val notation: String) : BaseErrorListener() {
    override fun syntaxError(recognizer: Recognizer<*, *>?, offendingSymbol: Any?, line: Int, charPositionInLine: Int, msg: String?, e: RecognitionException?) {
        throw InvalidNotationException(this.notation, msg!!)
    }
}
