package com.suushiemaniac.cubing.alglib.exception;

public class InvalidNotationException extends RuntimeException {
    public InvalidNotationException(String notation, String antlrMessage) {
        super("The following is no valid WCA notation: " + notation + ". " + antlrMessage);
    }
}
