package com.suushiemaniac.cubing.alglib.util;

import java.util.List;

public class StringUtils {
    public static String join(String delimiter, String... elements) {
        String toReturn = "";
        for (String element : elements) toReturn += (toReturn.length() > 0 ? delimiter : "") + element;
        return toReturn;
    }

    public static String join(String delimiter, StringFormat... elements) {
        String toReturn = "";
        for (StringFormat element : elements) toReturn += (toReturn.length() > 0 ? delimiter : "") + element.toFormatString();
        return toReturn;
    }

    public static String join(String delimiter, List<? extends StringFormat> elements) {
        String toReturn = "";
        for (StringFormat element : elements)
            toReturn += (toReturn.length() > 0 ? delimiter : "") + element.toFormatString();
        return toReturn;
    }
}
