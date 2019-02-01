package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.SkewbModifier
import com.suushiemaniac.cubing.alglib.move.plane.SkewbPlane

data class SkewbMove(override val plane: SkewbPlane, override val modifier: SkewbModifier) : Move {
    override val notation = "${this.plane}${this.modifier}"
    override val depth = 1

    override fun merges(other: Move): Boolean {
        return (other is SkewbMove
                && this.plane == other.plane
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is SkewbMove
                && this.plane == other.plane
                && this.modifier == other.modifier.inverse())
    }

    override fun mayAppend(other: Move) = other is SkewbMove
    override fun merge(other: Move) = SkewbMove(this.plane, this.modifier.merge(other.modifier))
    override fun inverse() = SkewbMove(this.plane, this.modifier.inverse())

    override fun toString() = this.notation
}
