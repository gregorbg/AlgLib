package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.PyraminxModifier
import com.suushiemaniac.cubing.alglib.move.plane.PyraminxPlane
import com.suushiemaniac.cubing.alglib.transform.Transform

class PyraminxMove(override val plane: PyraminxPlane, override val modifier: PyraminxModifier, override val depth: Int) : Move {
    override fun merges(other: Move): Boolean {
        return (other is PyraminxMove
                && this.plane == other.plane
                && this.depth == other.depth
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is PyraminxMove
                && this.plane == other.plane
                && this.depth == other.depth
                && this.modifier == other.modifier.inverse())
    }

    override fun mayAppend(other: Move): Boolean {
        return true
    }

    override fun merge(other: Move): PyraminxMove {
        return if (other !is PyraminxMove) other as PyraminxMove else PyraminxMove(this.plane, this.modifier.merge(other.modifier), this.depth)
    }

    override fun inverse(): Move {
        return PyraminxMove(this.plane, this.modifier.inverse(), this.depth)
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun toFormatString(): String {
        return (if (this.depth == 0) this.plane.toFormatString().toLowerCase() else this.plane.toFormatString()) + this.modifier.toFormatString()
    }

    override fun equals(other: Any?): Boolean {
        return (other is PyraminxMove
                && other.plane == this.plane
                && other.modifier == this.modifier
                && other.depth == this.depth)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}
