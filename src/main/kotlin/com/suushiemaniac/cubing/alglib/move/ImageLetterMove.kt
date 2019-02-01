package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.ImageLetterModifier
import com.suushiemaniac.cubing.alglib.move.modifier.Modifier
import com.suushiemaniac.cubing.alglib.move.plane.ImageLetterPlane
import com.suushiemaniac.cubing.alglib.transform.Transform

data class ImageLetterMove(override val plane: ImageLetterPlane) : Move {
    override val notation = this.plane.notation

    override val modifier = ImageLetterModifier.INST
    override val depth = 1

    override fun merges(other: Move) = false
    override fun cancels(other: Move) = false
    override fun mayAppend(other: Move) = true
    override fun merge(other: Move) = other
    override fun inverse() = ImageLetterMove(this.plane)

    override fun toString() = this.notation
}
