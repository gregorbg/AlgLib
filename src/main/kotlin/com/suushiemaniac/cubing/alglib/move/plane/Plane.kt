package com.suushiemaniac.cubing.alglib.move.plane

import com.suushiemaniac.cubing.alglib.util.StringFormat

interface Plane : StringFormat {
    val isRotation: Boolean
    val notation: String

    override fun equals(other: Any?): Boolean

    override fun toFormatString(): String {
        return notation
    }
}
