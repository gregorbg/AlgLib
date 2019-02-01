package com.suushiemaniac.cubing.alglib.transform.rotate

import com.suushiemaniac.cubing.alglib.move.CubicMove
import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane.*

data class CubicRotation(val rotationOrders: List<List<CubicPlane>>, val pow: Int) : Rotation {
    override fun rotate(origin: Move): Move {
        if (origin !is CubicMove)
            return origin
        else {
            val planeOrder = this.rotationOrders.find { origin.plane in it } ?: listOf(origin.plane)

            val rotationIndex = (planeOrder.indexOf(origin.plane) + this.pow) % planeOrder.size
            val rotatedPlane = planeOrder[rotationIndex]

            return CubicMove(rotatedPlane, origin.modifier, origin.depth, origin.fromDepth)
        }
    }

    companion object {
        val ROT_ORDER_X = listOf(
                listOf(UP, BACK, DOWN, FRONT),
                listOf(SANDWICH, EQUATOR),
                listOf(VERTICAL, SPATIAL)
        )

        val ROT_ORDER_Y = listOf(
                listOf(RIGHT, FRONT, LEFT, BACK),
                listOf(MIDDLE, SANDWICH),
                listOf(SPATIAL, HORIZONTAL)
        )

        val ROT_ORDER_Z = listOf(
                listOf(RIGHT, DOWN, LEFT, UP),
                listOf(MIDDLE, EQUATOR),
                listOf(HORIZONTAL, VERTICAL)
        )
    }
}
