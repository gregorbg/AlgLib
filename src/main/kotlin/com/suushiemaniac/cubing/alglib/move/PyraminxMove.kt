package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.PyraminxModifier
import com.suushiemaniac.cubing.alglib.move.plane.PyraminxPlane
import com.suushiemaniac.cubing.alglib.transform.Transform

data class PyraminxMove(override val plane: PyraminxPlane, override val modifier: PyraminxModifier, override val depth: Int) : Move {
    override val notation = "${if (this.depth == 0) this.plane.notation.toLowerCase() else this.plane.notation}${this.modifier.notation}"

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

    override fun mayAppend(other: Move) = other is PyraminxMove
    override fun merge(other: Move) = PyraminxMove(this.plane, this.modifier.merge(other.modifier), this.depth)
    override fun inverse() = PyraminxMove(this.plane, this.modifier.inverse(), this.depth)

    override fun toString() = this.notation
}
