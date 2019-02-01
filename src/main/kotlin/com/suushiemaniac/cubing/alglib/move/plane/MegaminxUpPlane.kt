package com.suushiemaniac.cubing.alglib.move.plane

enum class MegaminxUpPlane(override val notation: String) : MegaminxPlane {
    UP("U");

    override val isRotation = false
    override val type = "UP"
}
