package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane

data class CubicMove(override val plane: CubicPlane, override val modifier: CubicModifier, override val depth: Int, val fromDepth: Int) : Move {
    override val notation = "${if (this.fromDepth > 1) this.fromDepth.toString() else if (this.depth > 2) this.depth.toString() else ""}${if (this.fromDepth > 0) this.plane.notation.toLowerCase() else this.plane.notation}${if (this.depth > 1 && this.fromDepth == 0) "w" else ""}${this.modifier.notation}"

    override fun merges(other: Move): Boolean {
        return (other is CubicMove
                && this.plane == other.plane
                && this.depth == other.depth
                && this.fromDepth == other.fromDepth
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is CubicMove
                && this.plane == other.plane
                && this.depth == other.depth
                && this.fromDepth == other.fromDepth
                && this.modifier == other.modifier.inverse())
    }

    override fun mayAppend(other: Move) = other is CubicMove
    override fun merge(other: Move) = CubicMove(this.plane, this.modifier.merge(other.modifier), this.depth, this.fromDepth)
    override fun inverse() = CubicMove(this.plane, this.modifier.inverse(), this.depth, this.fromDepth)

    override fun toString() = this.notation
}