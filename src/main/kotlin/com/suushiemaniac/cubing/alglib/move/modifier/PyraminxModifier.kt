package com.suushiemaniac.cubing.alglib.move.modifier

enum class PyraminxModifier(val notation: String) : Modifier {
    CW(""), CCW("'");

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): PyraminxModifier {
        return PyraminxModifier.values()[(this.ordinal + 1) % PyraminxModifier.values().size]
    }

    override fun merge(other: Modifier): PyraminxModifier {
        return this.inverse()
    }

    companion object {

        fun fromNotation(notation: String): PyraminxModifier? {
            for (modifier in PyraminxModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}