package com.suushiemaniac.cubing.alglib.transform.rotate

import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.move.SkewbMove

enum class SkewbRotation : Rotation {
    ;

    override fun rotate(origin: Move): Move {
        return origin as SkewbMove
    }
}
