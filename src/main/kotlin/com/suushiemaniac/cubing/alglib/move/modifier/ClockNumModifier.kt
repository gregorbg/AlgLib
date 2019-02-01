package com.suushiemaniac.cubing.alglib.move.modifier

enum class ClockNumModifier(override val notation: String) : Modifier {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6");

    override fun inverse() = this
    override fun merge(other: Modifier) = other
}