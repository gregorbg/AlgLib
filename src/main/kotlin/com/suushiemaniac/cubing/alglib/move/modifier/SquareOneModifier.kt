package com.suushiemaniac.cubing.alglib.move.modifier

class SquareOneModifier(val halfModifierUp: SquareOneHalfModifier, val halfModifierDown: SquareOneHalfModifier) : Modifier {

    override fun inverse(): SquareOneModifier {
        return SquareOneModifier(this.halfModifierUp.inverse(), this.halfModifierDown.inverse())
    }

    override fun merge(other: Modifier): SquareOneModifier {
        return if (other !is SquareOneModifier) other as SquareOneModifier else SquareOneModifier(this.halfModifierUp.merge(other.halfModifierUp), this.halfModifierDown.merge(other.halfModifierDown))
    }

    override fun toFormatString(): String {
        return "(${this.halfModifierUp},${this.halfModifierDown})"
    }

    override fun equals(other: Any?): Boolean {
        return (other is SquareOneModifier
                && other.halfModifierUp == this.halfModifierUp
                && other.halfModifierDown == this.halfModifierDown)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}
