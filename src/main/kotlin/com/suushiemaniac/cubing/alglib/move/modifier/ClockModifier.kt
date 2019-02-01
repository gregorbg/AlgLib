package com.suushiemaniac.cubing.alglib.move.modifier

import kotlin.math.abs

data class ClockModifier(val numModifier: ClockNumModifier, val directionModifier: ClockDirectionModifier) : Modifier {
    override val notation = "${this.numModifier.notation}${this.directionModifier.notation}"

    override fun inverse() = ClockModifier(this.numModifier, this.directionModifier.inverse())

    override fun merge(other: Modifier): ClockModifier {
        if (other !is ClockModifier) return other as ClockModifier

        val newRot = (this.toNumber() + other.toNumber()).let {
            when {
                it < -6 -> 6 + (it + 6)
                it > 6 -> -6 + (it - 6)
                else -> it
            }
        }

        return ClockModifier.fromNumber(newRot)
    }

    fun toNumber() = "${this.directionModifier.notation}${this.numModifier.notation}".toInt()

    override fun toString() = this.notation

    companion object {
        val endPinModifier = ClockModifier(ClockNumModifier.ZERO, ClockDirectionModifier.NEG)

        fun fromNumber(number: Int): ClockModifier {
            val directionModifier = if (number < 0) ClockDirectionModifier.NEG else ClockDirectionModifier.POS
            val numModifier = ClockNumModifier.values().find { it.notation == abs(number).toString() }!!

            return ClockModifier(numModifier, directionModifier)
        }
    }
}