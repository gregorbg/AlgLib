package com.suushiemaniac.cubing.alglib.move.modifier

enum class SkewbModifier(val notation: String) : Modifier {
    CW(""), CCW("'");

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): SkewbModifier {
        return SkewbModifier.values()[(this.ordinal + 1) % SkewbModifier.values().size]
    }

    override fun merge(other: Modifier): SkewbModifier {
        return this.inverse()
    }

    companion object {

        fun fromNotation(notation: String): SkewbModifier? {
            for (modifier in SkewbModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}