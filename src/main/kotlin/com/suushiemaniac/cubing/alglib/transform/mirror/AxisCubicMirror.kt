package com.suushiemaniac.cubing.alglib.transform.mirror

import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane

enum class AxisCubicMirror(private val baseMirror: CubicMirror) : Mirror {
    E(CubicMirror(CubicPlane.EQUATOR, CubicPlane.UP to CubicPlane.DOWN)),
    M(CubicMirror(CubicPlane.MIDDLE, CubicPlane.RIGHT to CubicPlane.LEFT)),
    S(CubicMirror(CubicPlane.SANDWICH, CubicPlane.FRONT to CubicPlane.BACK));

    override fun mirror(origin: Move) = this.baseMirror.mirror(origin)
}
