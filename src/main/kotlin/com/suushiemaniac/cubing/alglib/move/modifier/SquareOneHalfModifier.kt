package com.suushiemaniac.cubing.alglib.move.modifier

class SquareOneHalfModifier(val directionModifier: SquareOneDirectionModifier, val numModifier: SquareOneNumModifier) : Modifier {

    override fun inverse(): SquareOneHalfModifier {
        return SquareOneHalfModifier(this.directionModifier.inverse(), this.numModifier)
    }

    override fun merge(other: Modifier): SquareOneHalfModifier {
        if (other !is SquareOneHalfModifier) return other as SquareOneHalfModifier

        var newRot = this.toNumber() + other.toNumber()

        if (newRot < -6) {
            newRot = 6 + (newRot + 6)
        } else if (newRot > 6) {
            newRot = -6 + (newRot - 6)
        }

        return SquareOneHalfModifier.fromNumber(newRot)
    }

    override fun toFormatString(): String {
        return this.directionModifier.toFormatString() + this.numModifier.toFormatString()
    }

    override fun equals(other: Any?): Boolean {
        return (other is SquareOneHalfModifier
                && other.directionModifier == this.directionModifier
                && other.numModifier == this.numModifier)
    }

    override fun hashCode(): Int {
        return this.toNumber()
    }

    fun toNumber(): Int {
        return Integer.parseInt(this.toFormatString())
    }

    companion object {
        fun fromNumber(number: Int): SquareOneHalfModifier {
            val directionModifier = if (number < 0) SquareOneDirectionModifier.NEG else SquareOneDirectionModifier.POS
            val numModifier = SquareOneNumModifier.fromNotation(Math.abs(number).toString() + "")
            return SquareOneHalfModifier(directionModifier, numModifier!!)
        }
    }
}
