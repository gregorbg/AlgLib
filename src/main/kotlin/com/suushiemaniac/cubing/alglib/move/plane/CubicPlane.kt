package com.suushiemaniac.cubing.alglib.move.plane

enum class CubicPlane(override val notation: String) : Plane {
    UP("U"), DOWN("D"), LEFT("L"), RIGHT("R"), FRONT("F"), BACK("B"), UP_SLICE("u"), DOWN_SLICE("d"), LEFT_SLICE("l"), RIGHT_SLICE("r"), FRONT_SLICE("f"), BACK_SLICE("b"), EQUATOR("E"), MIDDLE("M"), SANDWICH("S"), VERTICAL("y"), HORIZONTAL("x"), SPATIAL("z");

    override val isRotation: Boolean
        get() = this == HORIZONTAL || this == VERTICAL || this == SPATIAL
}