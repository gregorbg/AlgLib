package com.suushiemaniac.cubing.alglib.util;

public class ArrayUtils {
    public static <T> int arrayIndex(T[] searchArray, T element) {
        for (int i = 0; i < searchArray.length; i++) if (searchArray[i].equals(element)) return i;
        return -1;
    }
}