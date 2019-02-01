package com.suushiemaniac.cubing.alglib.move.modifier

class ImageLetterModifier : Modifier {
    override val notation = ""

    override fun inverse() = this
    override fun merge(other: Modifier) = other

    override fun hashCode() = 0
    override fun equals(other: Any?) = other === INST

    companion object {
        val INST = ImageLetterModifier()
    }
}
