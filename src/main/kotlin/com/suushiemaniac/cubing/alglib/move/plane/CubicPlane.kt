package com.suushiemaniac.cubing.alglib.move.plane

enum class CubicPlane(override val notation: String) : Plane {
    UP("U"), DOWN("D"), LEFT("L"), RIGHT("R"), FRONT("F"), BACK("B"),
    EQUATOR("E"), MIDDLE("M"), SANDWICH("S"),
    VERTICAL("y"), HORIZONTAL("x"), SPATIAL("z");

    override val isRotation: Boolean
        get() = this == HORIZONTAL || this == VERTICAL || this == SPATIAL
}