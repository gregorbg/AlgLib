package com.suushiemaniac.cubing.alglib.move.plane

class ImageLetterPlane(private var letter: Char) : Plane {
    override val isRotation: Boolean = false

    override val notation: String
        get() = letter.toString()

    override fun hashCode(): Int {
        return this.letter.toInt()
    }

    override fun equals(other: Any?): Boolean {
        return other is ImageLetterPlane && other.letter == this.letter
    }
}
