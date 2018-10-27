package com.suushiemaniac.cubing.alglib.transform.rotate

import com.suushiemaniac.cubing.alglib.transform.Transform
import com.suushiemaniac.cubing.alglib.move.Move

interface Rotation : Transform {
    fun rotate(origin: Move): Move

    override fun transform(origin: Move) = rotate(origin)
}
