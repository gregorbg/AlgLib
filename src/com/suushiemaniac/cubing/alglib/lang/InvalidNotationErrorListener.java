package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class InvalidNotationErrorListener extends BaseErrorListener {
    private String notation;

    public InvalidNotationErrorListener(String notation) {
        this.notation = notation;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new InvalidNotationException(this.notation, msg);
    }
}
