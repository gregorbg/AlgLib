package com.suushiemaniac.cubing.alglib.util;

import java.util.Comparator;

public class FixArrayComparator<T> implements Comparator<T> {
    private T[] preOrder;

    public FixArrayComparator(T[] preOrder) {
        this.preOrder = preOrder;
    }

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(ArrayUtils.arrayIndex(this.preOrder, o1), ArrayUtils.arrayIndex(this.preOrder, o2));
    }
}
