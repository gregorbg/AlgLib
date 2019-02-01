package com.suushiemaniac.cubing.alglib.move.modifier

enum class CubicModifier(override val notation: String) : Modifier {
    CW(""), DOUBLE("2"), CCW("'");

    override fun inverse() = CubicModifier.values()[-this.ordinal + CubicModifier.values().size - 1]

    //TODO correct merging index;
    override fun merge(other: Modifier): CubicModifier {
        val switchModifier = if (other is CubicModifier)
            other
        else return other as CubicModifier

        return if (switchModifier == this.inverse())
            other
        else
            CubicModifier.values()[-2 * this.ordinal * this.ordinal + 3 * this.ordinal + 1 + (2 * this.ordinal * this.ordinal - 4 * this.ordinal + 1) * other.ordinal]
    }
}