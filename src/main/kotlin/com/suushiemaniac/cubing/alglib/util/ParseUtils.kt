package com.suushiemaniac.cubing.alglib.util

import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException
import com.suushiemaniac.cubing.alglib.lang.*
import com.suushiemaniac.cubing.alglib.move.NotationValue

object ParseUtils {
    fun <T : NotationValue> Array<T>.fromNotation(targetNotation: String): T {
        return this.find { it.notation == targetNotation }!!
    }

    fun isParseable(input: String, parser: NotationReader) = try {
        parser.parse(input).moveLength() >= 0
    } catch (e: InvalidNotationException) {
        false
    }

    fun getReaderForPuzzle(puzzle: String): NotationReader? = when (puzzle) {
        "222", "333", "333ni", "444", "444ni", "555", "555ni", "666", "777" -> CubicAlgorithmReader()
        "skewb" -> SkewbAlgorithmReader()
        "pyram" -> PyraminxAlgorithmReader()
        "minx" -> MegaminxAlgorithmReader()
        "sq1" -> SquareOneAlgorithmReader()
        "clock" -> ClockAlgorithmReader()
        else -> null
    }

    fun guessReaderForAlgString(algString: String): NotationReader? {
        if (algString.contains("/") || algString.contains("(") && algString.contains(")"))
            return SquareOneAlgorithmReader()
        else if (algString.contains("++") || algString.contains("--"))
            return MegaminxAlgorithmReader()
        else if ((algString.contains("0") || algString.contains("1") || algString.contains("2") || algString.contains("3") || algString.contains("4") || algString.contains("5") || algString.contains("6")) && (algString.contains("+") || algString.contains("-")))
            return ClockAlgorithmReader()
        else if (algString.contains("u") || algString.contains("d") || algString.contains("l") || algString.contains("r"))
            return PyraminxAlgorithmReader()
        else if (algString.contains("D") || algString.contains("F") || algString.contains("x") || algString.contains("y") || algString.contains("z"))
            return CubicAlgorithmReader()
        else if (algString.contains("U") || algString.contains("B") || algString.contains("L") || algString.contains("R"))
            return SkewbAlgorithmReader()
        else
            return null
    }
}
