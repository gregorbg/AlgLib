package com.suushiemaniac.cubing.alglib.transform.mirror

import com.suushiemaniac.cubing.alglib.move.Move

enum class MegaminxMirror : Mirror {
    R_GRIP_AXIS;

    override fun mirror(origin: Move): Move {
        return origin.inverse()
    }
}