package com.suushiemaniac.cubing.alglib.move.modifier

enum class MegaminxUpModifier(val notation: String) : MegaminxModifier {
    CW(""), CCW("'");

    override val type: String
        get() = "UP"

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): MegaminxUpModifier {
        return MegaminxUpModifier.values()[(this.ordinal + 1) % MegaminxUpModifier.values().size]
    }

    override fun merge(other: Modifier): MegaminxModifier {
        return other as MegaminxModifier
    }

    companion object {

        fun fromNotation(notation: String): MegaminxUpModifier? {
            for (modifier in MegaminxUpModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}