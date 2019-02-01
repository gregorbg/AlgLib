package com.suushiemaniac.cubing.alglib.move.modifier

enum class SquareOneDirectionModifier(override val notation: String) : Modifier {
    POS(""), NEG("-");

    override fun inverse() = SquareOneDirectionModifier.values()[(this.ordinal + 1) % SquareOneDirectionModifier.values().size]

    //TODO
    override fun merge(other: Modifier) = other
}
