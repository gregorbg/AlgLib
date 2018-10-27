package com.suushiemaniac.cubing.alglib.move.modifier

enum class ClockNumModifier(val notation: String) : Modifier {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6");

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): Modifier {
        return this
    }

    override fun merge(other: Modifier): Modifier {
        return other
    }

    companion object {
        fun fromNotation(notation: String): ClockNumModifier? {
            for (modifier in ClockNumModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}