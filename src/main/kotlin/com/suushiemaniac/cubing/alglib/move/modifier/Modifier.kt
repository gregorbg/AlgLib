package com.suushiemaniac.cubing.alglib.move.modifier

import com.suushiemaniac.cubing.alglib.move.NotationValue

interface Modifier : NotationValue {
    fun inverse(): Modifier

    fun merge(other: Modifier): Modifier
}
