package com.suushiemaniac.cubing.alglib.move.plane

enum class ClockPlane(override val notation: String) : Plane {
    UP("U"), UP_RIGHT("UR"), UP_LEFT("UL"), RIGHT("R"), DOWN("D"), DOWN_LEFT("DL"), DOWN_RIGHT("DR"), LEFT("L"), ALL("ALL"), VERTICAL("y");

    override val isRotation: Boolean
        get() = this == VERTICAL

    companion object {
        fun fromNotation(notation: String): ClockPlane? {
            return values().find { it.notation == notation }
        }
    }
}
