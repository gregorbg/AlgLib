package com.suushiemaniac.cubing.alglib.move.modifier

class ClockModifier(val numModifier: ClockNumModifier, val directionModifier: ClockDirectionModifier) : Modifier {
    override fun inverse(): ClockModifier {
        return ClockModifier(this.numModifier, this.directionModifier.inverse())
    }

    override fun merge(other: Modifier): ClockModifier {
        if (other !is ClockModifier) return other as ClockModifier

        var newRot = this.toNumber() + other.toNumber()

        if (newRot < -6) {
            newRot = 6 + (newRot + 6)
        } else if (newRot > 6) {
            newRot = -6 + (newRot - 6)
        }

        return ClockModifier.fromNumber(newRot)
    }

    override fun toFormatString(): String {
        return this.numModifier.toFormatString() + this.directionModifier.toFormatString()
    }

    fun toNumString(): String {
        return this.directionModifier.toFormatString() + this.numModifier.toFormatString()
    }

    fun toNumber(): Int {
        return Integer.parseInt(this.toNumString())
    }

    override fun equals(other: Any?): Boolean {
        return (other is ClockModifier
                && other.numModifier == this.numModifier
                && other.directionModifier == this.directionModifier)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }

    companion object {
        val endPinModifier = ClockModifier(ClockNumModifier.ZERO, ClockDirectionModifier.NEG)

        fun fromNumber(number: Int): ClockModifier {
            val numModifier = ClockNumModifier.fromNotation(Math.abs(number).toString())
            val directionModifier = if (number < 0) ClockDirectionModifier.NEG else ClockDirectionModifier.POS
            return ClockModifier(numModifier!!, directionModifier)
        }
    }
}