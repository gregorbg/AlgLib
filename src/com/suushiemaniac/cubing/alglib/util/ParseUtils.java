package com.suushiemaniac.cubing.alglib.util;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException;
import com.suushiemaniac.cubing.alglib.lang.*;

public class ParseUtils {
    public static boolean isParseable(String input, NotationReader parser) {
        try {
            Algorithm alg = parser.parse(input);
            return alg.length() >= 0;
        } catch (InvalidNotationException e) {
            return false;
        }
    }

    public static NotationReader getReaderForPuzzle(String puzzle) {
        switch (puzzle) {
            case "222":
            case "333":
            case "333ni":
            case "444":
            case "444ni":
            case "555":
            case "555ni":
            case "666":
            case "777":
                return new CubicAlgorithmReader();
            case "skewb":
                return new SkewbAlgorithmReader();
            case "pyram":
                return new PyraminxAlgorithmReader();
            case "minx":
                return new MegaminxAlgorithmReader();
            case "sq1":
                return new SquareOneAlgorithmReader();
            case "clock":
                return new ClockAlgorithmReader();
            default:
                return null;
        }
    }

    public static NotationReader guessReaderForAlgString(String algString) {
        if (algString.contains("/") || (algString.contains("(") && algString.contains(")")))
            return new SquareOneAlgorithmReader();
        else if (algString.contains("++") || algString.contains("--"))
            return new MegaminxAlgorithmReader();
        else if ((algString.contains("0") || algString.contains("1") || algString.contains("2") || algString.contains("3") || algString.contains("4") || algString.contains("5") || algString.contains("6")) && (algString.contains("+") || algString.contains("-")))
            return new ClockAlgorithmReader();
        else if (algString.contains("u") || algString.contains("d") || algString.contains("l") || algString.contains("r"))
            return new PyraminxAlgorithmReader();
        else if (algString.contains("D") || algString.contains("F"))
            return new CubicAlgorithmReader();
        else if (algString.contains("U") || algString.contains("B") || algString.contains("L") || algString.contains("R"))
            return new SkewbAlgorithmReader();
        else return null;
    }
}
