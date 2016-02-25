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
        if (puzzle.equals("222") || puzzle.equals("333") || puzzle.equals("333ni") || puzzle.equals("444") || puzzle.equals("444ni") || puzzle.equals("555") || puzzle.equals("555ni") || puzzle.equals("666") || puzzle.equals("777"))
            return new CubicAlgorithmReader();
        else if (puzzle.equals("skewb")) return new SkewbAlgorithmReader();
        else if (puzzle.equals("pyram")) return new PyraminxAlgorithmReader();
        else if (puzzle.equals("minx")) return new MegaminxAlgorithmReader();
        else if (puzzle.equals("sq1")) return new SquareOneAlgorithmReader();
        else if (puzzle.equals("clock")) return new ClockAlgorithmReader();
        else return null;
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
