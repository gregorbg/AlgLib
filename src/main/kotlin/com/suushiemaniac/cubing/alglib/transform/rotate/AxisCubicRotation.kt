package com.suushiemaniac.cubing.alglib.transform.rotate

import com.suushiemaniac.cubing.alglib.move.Move

enum class AxisCubicRotation(val baseRotation: CubicRotation) : Rotation {
    Y_90(CubicRotation(CubicRotation.ROT_ORDER_Y, 1)), X_90(CubicRotation(CubicRotation.ROT_ORDER_X, 1)), Z_90(CubicRotation(CubicRotation.ROT_ORDER_Z, 1)),
    Y_180(CubicRotation(CubicRotation.ROT_ORDER_Y, 2)), X_180(CubicRotation(CubicRotation.ROT_ORDER_X, 2)), Z_180(CubicRotation(CubicRotation.ROT_ORDER_Z, 2)),
    Y_270(CubicRotation(CubicRotation.ROT_ORDER_Y, 3)), X_270(CubicRotation(CubicRotation.ROT_ORDER_X, 3)), Z_270(CubicRotation(CubicRotation.ROT_ORDER_Z, 3));

    override fun rotate(origin: Move) = this.baseRotation.transform(origin)
}
