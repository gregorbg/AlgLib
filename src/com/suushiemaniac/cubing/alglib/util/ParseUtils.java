package com.suushiemaniac.cubing.alglib.util;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException;
import com.suushiemaniac.cubing.alglib.lang.NotationReader;

public class ParseUtils {
    public static boolean isParseable(String input, NotationReader parser) {
        try {
            Algorithm alg = parser.parse(input);
            return alg.length() >= 0;
        } catch (InvalidNotationException e) {
            return false;
        }
    }
}
