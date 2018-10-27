package com.suushiemaniac.cubing.alglib.move.modifier

class ImageLetterModifier : Modifier {
    override fun toFormatString(): String {
        return ""
    }

    override fun inverse(): Modifier {
        return this
    }

    override fun merge(other: Modifier): Modifier {
        return other
    }

    override fun hashCode(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        return other is ImageLetterModifier
    }

    companion object {
        val INST = ImageLetterModifier()
    }
}
