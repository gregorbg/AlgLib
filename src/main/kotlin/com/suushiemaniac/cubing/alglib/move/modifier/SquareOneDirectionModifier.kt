package com.suushiemaniac.cubing.alglib.move.modifier

enum class SquareOneDirectionModifier(val notation: String) : Modifier {
    POS(""), NEG("-");

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): SquareOneDirectionModifier {
        return SquareOneDirectionModifier.values()[(this.ordinal + 1) % SquareOneDirectionModifier.values().size]
    }

    //TODO
    override fun merge(other: Modifier): Modifier {
        return other
    }

    companion object {

        fun fromNotation(notation: String): SquareOneDirectionModifier? {
            for (modifier in SquareOneDirectionModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}
