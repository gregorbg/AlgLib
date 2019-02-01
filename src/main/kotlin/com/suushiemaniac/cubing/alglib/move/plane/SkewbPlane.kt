package com.suushiemaniac.cubing.alglib.move.plane

enum class SkewbPlane(override val notation: String) : Plane {
    UP("U"), LEFT("L"), RIGHT("R"), BACK("B");

    override val isRotation = false
}
