package com.suushiemaniac.cubing.alglib.transform.mirror

import com.suushiemaniac.cubing.alglib.move.CubicMove
import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane

enum class CubicMirror : Mirror {
    E, M, S;

    override fun mirror(origin: Move): Move {
        return if (origin !is CubicMove)
            origin
        else {
            val cPlane = origin.plane
            val ordinal = cPlane.ordinal
            val base = if (ordinal < 6) 0 else if (ordinal < 12) 6 else if (ordinal < 15) 12 else 15
            val size = if (base < 12) 6 else 3
            val isPlaneAffected = this.ordinal == (ordinal - base) / (size / 3)

            val offset = if (isPlaneAffected) size / 6 else 0
            val inTuple = ordinal % (size / 3)
            val planeIndex = (inTuple + offset) % (size / 3) + ordinal - inTuple
            val plane = CubicPlane.values()[planeIndex]

            val isModifierAffected = size == 6 || this.ordinal != (ordinal - base) / (size / 3)
            var modifier = origin.modifier
            if (isModifierAffected) modifier = modifier.inverse()

            CubicMove(plane, modifier, origin.depth)
        }
    }
}
