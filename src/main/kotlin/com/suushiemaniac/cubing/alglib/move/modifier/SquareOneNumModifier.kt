package com.suushiemaniac.cubing.alglib.move.modifier

enum class SquareOneNumModifier(val notation: String) : Modifier {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6");

    override fun inverse(): SquareOneNumModifier {
        return this // FIXME
    }

    override fun merge(other: Modifier): SquareOneNumModifier {
        return other as SquareOneNumModifier
    }

    override fun toFormatString(): String {
        return this.notation
    }

    companion object {

        fun fromNotation(notation: String): SquareOneNumModifier? {
            for (modifier in SquareOneNumModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}
