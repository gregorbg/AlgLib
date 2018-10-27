package com.suushiemaniac.cubing.alglib.move.plane

enum class MegaminxWidePlane(override val notation: String) : MegaminxPlane {
    RIGHT("R"), DOWN("D");

    override val isRotation: Boolean = false
    override val type: String = "WIDE"

    companion object {
        fun fromNotation(notation: String): MegaminxWidePlane? {
            return values().find { it.notation == notation }
        }
    }
}
