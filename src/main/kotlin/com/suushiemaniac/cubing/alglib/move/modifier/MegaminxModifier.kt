package com.suushiemaniac.cubing.alglib.move.modifier

interface MegaminxModifier : Modifier {
    val type: String

    override fun inverse(): MegaminxModifier

    override fun merge(other: Modifier): MegaminxModifier
}
