package com.suushiemaniac.cubing.alglib.transform.mirror

import com.suushiemaniac.cubing.alglib.move.CubicMove
import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane

data class CubicMirror(private val axis: CubicPlane, private val swapPair: Pair<CubicPlane, CubicPlane>, private val offset: Int = 0) : Mirror {
    override fun mirror(origin: Move): Move {
        return if (origin !is CubicMove)
            origin
        else {
            val safeZone = this.offset > 0 && origin.fromDepth >= this.offset

            val planeSwap = listOf(this.swapPair.first, this.swapPair.second)
            val plane = if (origin.plane in planeSwap && !safeZone) planeSwap.find { it !== origin.plane }!! else origin.plane

            val isModifierAffected = origin.plane.ordinal < 6 || this.axis != origin.plane
            val modifier = if (isModifierAffected && !safeZone) origin.modifier.inverse() else origin.modifier

            CubicMove(plane, modifier, origin.depth, origin.fromDepth)
        }
    }
}
