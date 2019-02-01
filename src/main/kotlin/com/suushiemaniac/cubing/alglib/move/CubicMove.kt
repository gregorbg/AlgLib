package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane

data class CubicMove(override val plane: CubicPlane, override val modifier: CubicModifier, override val depth: Int) : Move {
    override val notation = "${if (this.depth > (if (this.plane.name.contains("SLICE")) 1 else 2)) this.depth.toString() else ""}${this.plane.notation}${if (this.depth > 1 && !this.plane.name.contains("SLICE")) "w" else ""}${this.modifier.notation}"

    override fun merges(other: Move): Boolean {
        return (other is CubicMove
                && this.plane == other.plane
                && this.depth == other.depth
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is CubicMove
                && this.plane == other.plane
                && this.depth == other.depth
                && this.modifier == other.modifier.inverse())
    }

    override fun mayAppend(other: Move) = other is CubicMove
    override fun merge(other: Move) = CubicMove(this.plane, this.modifier.merge(other.modifier), this.depth)
    override fun inverse() = CubicMove(this.plane, this.modifier.inverse(), this.depth)

    override fun toString() = this.notation
}