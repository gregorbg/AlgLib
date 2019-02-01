package com.suushiemaniac.cubing.alglib.move.modifier

enum class ClockDirectionModifier(override val notation: String) : Modifier {
    POS("+"), NEG("-");

    override fun inverse() = ClockDirectionModifier.values()[(this.ordinal + 1) % ClockDirectionModifier.values().size]

    //TODO
    override fun merge(other: Modifier) = other
}