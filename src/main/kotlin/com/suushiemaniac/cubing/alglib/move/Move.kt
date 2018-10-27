package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.Modifier
import com.suushiemaniac.cubing.alglib.move.plane.Plane
import com.suushiemaniac.cubing.alglib.transform.Transform
import com.suushiemaniac.cubing.alglib.util.StringFormat

interface Move : StringFormat {
    val plane: Plane
    val modifier: Modifier
    val depth: Int

    fun merges(other: Move): Boolean

    fun cancels(other: Move): Boolean

    fun mayAppend(other: Move): Boolean

    fun merge(other: Move): Move // FIXME nullability

    fun inverse(): Move // FIXME nullability (Megaminx…)

    fun transform(transform: Transform): Move = transform.transform(this)
}
