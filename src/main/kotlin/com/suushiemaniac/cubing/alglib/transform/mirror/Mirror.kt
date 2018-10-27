package com.suushiemaniac.cubing.alglib.transform.mirror

import com.suushiemaniac.cubing.alglib.transform.Transform
import com.suushiemaniac.cubing.alglib.move.Move

interface Mirror : Transform {
    fun mirror(origin: Move): Move

    override fun transform(origin: Move) = mirror(origin)
}
