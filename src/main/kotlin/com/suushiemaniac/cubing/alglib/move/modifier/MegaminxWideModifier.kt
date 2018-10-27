package com.suushiemaniac.cubing.alglib.move.modifier

enum class MegaminxWideModifier(val notation: String) : MegaminxModifier {
    PLUS("++"), MINUS("--");

    override val type: String
        get() = "WIDE"

    override fun toFormatString(): String {
        return this.notation
    }

    override fun inverse(): MegaminxWideModifier {
        return MegaminxWideModifier.values()[(this.ordinal + 1) % MegaminxWideModifier.values().size]
    }

    override fun merge(other: Modifier): MegaminxWideModifier {
        return other as MegaminxWideModifier
    }

    companion object {

        fun fromNotation(notation: String): MegaminxWideModifier? {
            for (modifier in MegaminxWideModifier.values())
                if (modifier.notation == notation) return modifier
            return null
        }
    }
}