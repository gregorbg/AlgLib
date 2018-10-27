package com.suushiemaniac.cubing.alglib.move.plane

class SquareOnePlane : Plane {
    override val isRotation: Boolean = false
    override val notation: String = ""

    override fun equals(other: Any?): Boolean {
        return other is SquareOnePlane
    }

    override fun hashCode(): Int {
        return 0
    }

    companion object {
        val INST = SquareOnePlane()
    }
}
