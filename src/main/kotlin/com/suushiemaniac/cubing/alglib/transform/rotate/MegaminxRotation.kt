package com.suushiemaniac.cubing.alglib.transform.rotate

import com.suushiemaniac.cubing.alglib.move.Move

enum class MegaminxRotation : Rotation {
    ;

    override fun rotate(origin: Move): Move {
        return origin
    }
}
