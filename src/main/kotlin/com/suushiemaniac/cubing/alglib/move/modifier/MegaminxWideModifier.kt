package com.suushiemaniac.cubing.alglib.move.modifier

enum class MegaminxWideModifier(override val notation: String) : MegaminxModifier {
    PLUS("++"), MINUS("--");

    override val type = "WIDE"

    override fun inverse() = MegaminxWideModifier.values()[(this.ordinal + 1) % MegaminxWideModifier.values().size]
    override fun merge(other: Modifier) = other as MegaminxWideModifier
}