package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneHalfModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneModifier
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneNumModifier
import com.suushiemaniac.cubing.alglib.move.plane.SquareOnePlane

class SquareOneMove : Move {
    override val plane = SquareOnePlane.INST
    override val modifier: SquareOneModifier

    val isEndSlash: Boolean
    val isBeginSlash: Boolean

    override val depth: Int
        get() = 1

    constructor(modifier: SquareOneModifier, beginSlash: Boolean, endSlash: Boolean) {
        this.modifier = modifier
        this.isBeginSlash = beginSlash
        this.isEndSlash = endSlash
    }

    constructor(modifierUp: SquareOneHalfModifier, modifierDown: SquareOneHalfModifier, beginSlash: Boolean, endSlash: Boolean) {
        this.modifier = SquareOneModifier(modifierUp, modifierDown)
        this.isBeginSlash = beginSlash
        this.isEndSlash = endSlash
    }

    constructor(directionModifierUp: SquareOneDirectionModifier, numModifierUp: SquareOneNumModifier, directionModifierDown: SquareOneDirectionModifier, numModifierDown: SquareOneNumModifier, beginSlash: Boolean, endSlash: Boolean) {
        this.modifier = SquareOneModifier(SquareOneHalfModifier(directionModifierUp, numModifierUp), SquareOneHalfModifier(directionModifierDown, numModifierDown))
        this.isBeginSlash = beginSlash
        this.isEndSlash = endSlash
    }

    override fun merges(other: Move): Boolean {
        return (other is SquareOneMove
                && !this.isEndSlash
                && !other.isBeginSlash
                && !this.cancels(other)
                && this.mayAppend(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is SquareOneMove
                && this.mayAppend(other)
                && !this.isEndSlash
                && this.modifier.halfModifierUp.toNumber() + other.modifier.halfModifierUp.toNumber() == 0
                && this.modifier.halfModifierDown.toNumber() + other.modifier.halfModifierDown.toNumber() == 0)
    }

    override fun mayAppend(other: Move): Boolean {
        return !this.isEndSlash || !(other as SquareOneMove).isBeginSlash
    }

    override fun merge(other: Move): SquareOneMove {
        return if (other !is SquareOneMove) other as SquareOneMove else SquareOneMove(this.modifier.merge(other.modifier), this.isBeginSlash, this.isEndSlash)
    }

    override fun inverse(): SquareOneMove {
        return SquareOneMove(this.modifier.inverse(), this.isBeginSlash, this.isEndSlash)
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun toFormatString(): String {
        return (if (this.isBeginSlash) "/ " else "") + this.modifier.toFormatString() + if (this.isEndSlash) " /" else ""
    }

    override fun equals(other: Any?): Boolean {
        return (other is SquareOneMove
                && other.modifier === this.modifier
                && other.isBeginSlash == this.isBeginSlash
                && other.isEndSlash == this.isEndSlash)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}