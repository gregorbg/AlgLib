package com.suushiemaniac.cubing.alglib.move.modifier

enum class PyraminxModifier(override val notation: String) : Modifier {
    CW(""), CCW("'");

    override fun inverse() = PyraminxModifier.values()[(this.ordinal + 1) % PyraminxModifier.values().size]
    override fun merge(other: Modifier) = this.inverse()
}