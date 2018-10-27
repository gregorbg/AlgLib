package com.suushiemaniac.cubing.alglib.util

object ArrayUtils {
    inline fun <reified T : Any> Array<T?>.denullify(): Array<T> {
        return this.filterNotNull().toTypedArray()
    }
}