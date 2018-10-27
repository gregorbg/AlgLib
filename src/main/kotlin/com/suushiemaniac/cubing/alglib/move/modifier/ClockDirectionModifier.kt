package com.suushiemaniac.cubing.alglib.move.modifier

enum class ClockDirectionModifier(val notation: String) : Modifier {
    POS("+"), NEG("-");

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): ClockDirectionModifier {
        return ClockDirectionModifier.values()[(this.ordinal + 1) % ClockDirectionModifier.values().size]
    }

    //TODO
    override fun merge(other: Modifier): Modifier {
        return other
    }

    companion object {
        fun fromNotation(notation: String): ClockDirectionModifier? {
            for (modifier in ClockDirectionModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}