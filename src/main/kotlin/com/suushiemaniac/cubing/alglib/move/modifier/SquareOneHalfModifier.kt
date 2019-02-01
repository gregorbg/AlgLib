package com.suushiemaniac.cubing.alglib.move.modifier

import kotlin.math.abs

data class SquareOneHalfModifier(val directionModifier: SquareOneDirectionModifier, val numModifier: SquareOneNumModifier) : Modifier {
    override val notation = "${this.directionModifier.notation}${this.numModifier.notation}"

    override fun inverse() = SquareOneHalfModifier(this.directionModifier.inverse(), this.numModifier)

    override fun merge(other: Modifier): SquareOneHalfModifier {
        if (other !is SquareOneHalfModifier) return other as SquareOneHalfModifier

        val newRot = (this.toNumber() + other.toNumber()).let {
            when {
                it < -6 -> 6 + (it + 6)
                it > 6 -> -6 + (it - 6)
                else -> it
            }
        }

        return SquareOneHalfModifier.fromNumber(newRot)
    }

    fun toNumber() = this.notation.toInt()
    override fun toString() = this.notation

    companion object {
        fun fromNumber(number: Int): SquareOneHalfModifier {
            val directionModifier = if (number < 0) SquareOneDirectionModifier.NEG else SquareOneDirectionModifier.POS
            val numModifier = SquareOneNumModifier.values().find { it.notation == abs(number).toString() }!!

            return SquareOneHalfModifier(directionModifier, numModifier)
        }
    }
}
