package com.suushiemaniac.cubing.alglib.move.plane

enum class MegaminxUpPlane(override val notation: String) : MegaminxPlane {
    UP("U");

    override val isRotation: Boolean = false
    override val type: String = "UP"

    companion object {
        fun fromNotation(notation: String): MegaminxUpPlane? {
            return values().find { it.notation == notation }
        }
    }
}
