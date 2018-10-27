package com.suushiemaniac.cubing.alglib.exception

class InvalidNotationException(notation: String, antlrMessage: String) : RuntimeException("The following is no valid WCA notation: $notation. $antlrMessage")
