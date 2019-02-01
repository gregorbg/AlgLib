package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneHalfModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneNumModifier
import com.suushiemaniac.cubing.alglib.move.plane.SquareOnePlane

data class SquareOneMove(override val modifier: SquareOneModifier, val isBeginSlash: Boolean, val isEndSlash: Boolean) : Move {
    override val plane = SquareOnePlane.INST
    override val notation = "${if (this.isBeginSlash) "/ " else ""}${this.modifier.notation}${if (this.isEndSlash) " /" else ""}"

    override val depth = 1

    constructor(modifierUp: SquareOneHalfModifier, modifierDown: SquareOneHalfModifier, beginSlash: Boolean, endSlash: Boolean) : this(SquareOneModifier(modifierUp, modifierDown), beginSlash, endSlash)
    constructor(directionModifierUp: SquareOneDirectionModifier, numModifierUp: SquareOneNumModifier, directionModifierDown: SquareOneDirectionModifier, numModifierDown: SquareOneNumModifier, beginSlash: Boolean, endSlash: Boolean) : this(SquareOneModifier(SquareOneHalfModifier(directionModifierUp, numModifierUp), SquareOneHalfModifier(directionModifierDown, numModifierDown)), beginSlash, endSlash)

    override fun merges(other: Move): Boolean {
        return (other is SquareOneMove
                && this.isEndSlash == other.isBeginSlash
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is SquareOneMove
                && this.isEndSlash == other.isBeginSlash
                && this.modifier.halfModifierUp.toNumber() + other.modifier.halfModifierUp.toNumber() == 0
                && this.modifier.halfModifierDown.toNumber() + other.modifier.halfModifierDown.toNumber() == 0)
    }

    override fun mayAppend(other: Move) = !this.isEndSlash || (other is SquareOneMove && !other.isBeginSlash)
    override fun merge(other: Move) = SquareOneMove(this.modifier.merge(other.modifier), this.isBeginSlash, this.isEndSlash)
    override fun inverse() = SquareOneMove(this.modifier.inverse(), this.isBeginSlash, this.isEndSlash)

    override fun toString() = this.notation
}