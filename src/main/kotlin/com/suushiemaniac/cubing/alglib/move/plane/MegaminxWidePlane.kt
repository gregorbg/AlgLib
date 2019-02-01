package com.suushiemaniac.cubing.alglib.move.plane

enum class MegaminxWidePlane(override val notation: String) : MegaminxPlane {
    RIGHT("R"), DOWN("D");

    override val isRotation = false
    override val type = "WIDE"
}
