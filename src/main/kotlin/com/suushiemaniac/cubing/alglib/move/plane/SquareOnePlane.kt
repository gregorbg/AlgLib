package com.suushiemaniac.cubing.alglib.move.plane

class SquareOnePlane : Plane {
    override val isRotation = false
    override val notation = ""

    override fun equals(other: Any?) = other === INST
    override fun hashCode() = 0

    companion object {
        val INST = SquareOnePlane()
    }
}
