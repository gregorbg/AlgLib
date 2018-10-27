package com.suushiemaniac.cubing.alglib.util

class FixArrayComparator<T>(private val preOrder: Array<T>) : Comparator<T> {
    override fun compare(o1: T, o2: T): Int {
        return Integer.compare(this.preOrder.indexOf(o1), this.preOrder.indexOf(o2))
    }
}
