package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane

class CubicMove(override val plane: CubicPlane, override val modifier: CubicModifier, override val depth: Int) : Move {
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

    override fun mayAppend(other: Move): Boolean {
        return true
    }

    override fun merge(other: Move): CubicMove {
        return if (other !is CubicMove) other as CubicMove else CubicMove(this.plane, this.modifier.merge(other.modifier), this.depth)
    }

    override fun inverse(): CubicMove {
        return CubicMove(this.plane, this.modifier.inverse(), this.depth)
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun toFormatString(): String {
        return (if (this.depth > (if (this.plane.name.contains("SLICE")) 1 else 2)) this.depth.toString() else "") + this.plane.toFormatString() + (if (this.depth > 1 && !this.plane.name.contains("SLICE")) "w" else "") + this.modifier.toFormatString()
    }

    override fun equals(other: Any?): Boolean {
        return (other is CubicMove
                && other.plane == this.plane
                && other.modifier == this.modifier
                && other.depth == this.depth)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}