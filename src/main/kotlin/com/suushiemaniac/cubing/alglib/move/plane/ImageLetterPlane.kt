package com.suushiemaniac.cubing.alglib.move.plane

data class ImageLetterPlane(private val letter: Char) : Plane {
    override val isRotation = false
    override val notation = letter.toString()
}
