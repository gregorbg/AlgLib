package com.suushiemaniac.cubing.alglib.transform.rotate

import com.suushiemaniac.cubing.alglib.move.CubicMove
import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane.*

enum class CubicRotation : Rotation {
    Y_90, X_90, Z_90, Y_180, X_180, Z_180, Y_270, X_270, Z_270;

    override fun rotate(origin: Move): Move {
        if (origin !is CubicMove)
            return origin
        else {
            val rotBaseOrdinal = this.ordinal % 3
            val rotAmountOrdinal = this.ordinal / 3

            val cPlane = origin.plane
            val ordinal = cPlane.ordinal
            val base = if (ordinal < 6) 0 else if (ordinal < 12) 6 else if (ordinal < 15) 12 else 15
            val size = if (base < 12) 6 else 3
            val isPlaneAffected = rotBaseOrdinal != (ordinal - base) / (size / 3)

            val typeBase = if (ordinal < 6) 0 else if (ordinal < 12) 1 else if (ordinal < 15) 2 else 3
            var rotIndex = if (isPlaneAffected) ROT_ORDER[rotBaseOrdinal][typeBase].indexOf(cPlane) else 0
            val modLen = size / 3 * 2
            val fullIndex = (rotIndex + rotAmountOrdinal + 1) % modLen
            val plane = if (isPlaneAffected) ROT_ORDER[rotBaseOrdinal][typeBase][fullIndex] else cPlane

            var modifier = origin.modifier
            for (i in 0..rotAmountOrdinal)
                if (isPlaneAffected && modLen == 2 && ++rotIndex % 2 % 2 == 1)
                    modifier = modifier.inverse()

            return CubicMove(plane, modifier, origin.depth, origin.fromDepth)
        }
    }

    companion object {
        private val ROT_ORDER = arrayOf(
                arrayOf(
                        arrayOf(RIGHT, FRONT, LEFT, BACK),
                        arrayOf(MIDDLE, SANDWICH),
                        arrayOf(SPATIAL, HORIZONTAL)
                ),
                arrayOf(
                        arrayOf(UP, BACK, DOWN, FRONT),
                        arrayOf(SANDWICH, EQUATOR),
                        arrayOf(VERTICAL, SPATIAL)
                ),
                arrayOf(
                        arrayOf(RIGHT, DOWN, LEFT, UP),
                        arrayOf(MIDDLE, EQUATOR),
                        arrayOf(HORIZONTAL, VERTICAL)
                )
        )
    }
}
