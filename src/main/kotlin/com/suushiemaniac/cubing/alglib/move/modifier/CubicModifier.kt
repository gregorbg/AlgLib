package com.suushiemaniac.cubing.alglib.move.modifier

enum class CubicModifier(val notation: String) : Modifier {
    CW(""), DOUBLE("2"), CCW("'");

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): CubicModifier {
        return CubicModifier.values()[-this.ordinal + CubicModifier.values().size - 1]
    }

    //TODO correct merging index;
    override fun merge(other: Modifier): CubicModifier {
        val switchModifier: CubicModifier

        if (other is CubicModifier)
            switchModifier = other
        else
            return other as CubicModifier

        return if (switchModifier == this.inverse())
            other
        else
            CubicModifier.values()[-2 * this.ordinal * this.ordinal + 3 * this.ordinal + 1 + (2 * this.ordinal * this.ordinal - 4 * this.ordinal + 1) * other.ordinal]
    }

    companion object {

        fun fromNotation(notation: String): CubicModifier? {
            for (modifier in CubicModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}