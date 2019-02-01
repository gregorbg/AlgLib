package com.suushiemaniac.cubing.alglib.move.modifier

data class SquareOneModifier(val halfModifierUp: SquareOneHalfModifier, val halfModifierDown: SquareOneHalfModifier) : Modifier {
    override val notation = "(${this.halfModifierUp},${this.halfModifierDown})"

    override fun inverse() = SquareOneModifier(this.halfModifierUp.inverse(), this.halfModifierDown.inverse())

    override fun merge(other: Modifier): SquareOneModifier {
        return if (other !is SquareOneModifier) other as SquareOneModifier else SquareOneModifier(this.halfModifierUp.merge(other.halfModifierUp), this.halfModifierDown.merge(other.halfModifierDown))
    }

    override fun toString() = this.notation
}
