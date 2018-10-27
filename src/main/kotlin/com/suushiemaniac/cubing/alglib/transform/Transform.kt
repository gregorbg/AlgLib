package com.suushiemaniac.cubing.alglib.transform

import com.suushiemaniac.cubing.alglib.move.Move

interface Transform {
    fun transform(origin: Move): Move
}
