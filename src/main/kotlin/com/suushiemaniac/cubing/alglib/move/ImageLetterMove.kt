package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.ImageLetterModifier
import com.suushiemaniac.cubing.alglib.move.modifier.Modifier
import com.suushiemaniac.cubing.alglib.move.plane.ImageLetterPlane
import com.suushiemaniac.cubing.alglib.transform.Transform

class ImageLetterMove(override val plane: ImageLetterPlane) : Move {
    override val modifier: Modifier
        get() = ImageLetterModifier.INST

    override val depth: Int
        get() = 1

    override fun toFormatString(): String {
        return this.plane.toFormatString()
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun merges(other: Move): Boolean {
        return false
    }

    override fun cancels(other: Move): Boolean {
        return false
    }

    override fun mayAppend(other: Move): Boolean {
        return true
    }

    override fun merge(other: Move): Move {
        return other
    }

    override fun inverse(): Move {
        return ImageLetterMove(this.plane)
    }

    override fun equals(other: Any?): Boolean {
        return other is ImageLetterMove && other.plane == this.plane
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}
