package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.SkewbModifier
import com.suushiemaniac.cubing.alglib.move.plane.SkewbPlane

class SkewbMove(override val plane: SkewbPlane, override val modifier: SkewbModifier) : Move {
    override val depth: Int
        get() = 1

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

    override fun mayAppend(other: Move): Boolean {
        return true
    }

    override fun merge(other: Move): SkewbMove {
        return if (other !is SkewbMove) other as SkewbMove else SkewbMove(this.plane, this.modifier.merge(other.modifier))
    }

    override fun inverse(): SkewbMove {
        return SkewbMove(this.plane, this.modifier.inverse())
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun toFormatString(): String {
        return this.plane.toFormatString() + this.modifier.toFormatString()
    }

    override fun equals(other: Any?): Boolean {
        return (other is SkewbMove
                && other.plane == this.plane
                && other.modifier == this.modifier)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}
