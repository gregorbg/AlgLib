package com.suushiemaniac.cubing.alglib.move.modifier

import com.suushiemaniac.cubing.alglib.util.StringFormat

interface Modifier : StringFormat {
    fun inverse(): Modifier

    fun merge(other: Modifier): Modifier

    override fun equals(other: Any?): Boolean
}
