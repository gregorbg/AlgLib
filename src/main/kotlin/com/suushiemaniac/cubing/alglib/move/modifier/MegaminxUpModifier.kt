package com.suushiemaniac.cubing.alglib.move.modifier

enum class MegaminxUpModifier(override val notation: String) : MegaminxModifier {
    CW(""), CCW("'");

    override val type: String
        get() = "UP"

    override fun inverse() = MegaminxUpModifier.values()[(this.ordinal + 1) % MegaminxUpModifier.values().size]
    override fun merge(other: Modifier) = other as MegaminxModifier
}