package com.suushiemaniac.cubing.alglib.transform.mirror

import com.suushiemaniac.cubing.alglib.move.Move

enum class SquareOneMirror : Mirror {
    ;

    override fun mirror(origin: Move): Move {
        return origin
    }
}
