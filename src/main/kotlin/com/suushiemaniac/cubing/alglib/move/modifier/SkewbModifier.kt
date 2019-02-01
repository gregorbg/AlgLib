package com.suushiemaniac.cubing.alglib.move.modifier

enum class SkewbModifier(override val notation: String) : Modifier {
    CW(""), CCW("'");

    override fun inverse() = SkewbModifier.values()[(this.ordinal + 1) % SkewbModifier.values().size]
    override fun merge(other: Modifier) = this.inverse()
}