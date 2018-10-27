package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.transform.Transform

class PureComm(val partA: Algorithm, val partB: Algorithm) : Commutator() {
    override fun toFormatString(): String {
        return "[${this.partA}, ${this.partB}]"
    }

    override fun develop(): Algorithm {
        return this.partA.copy().merge(this.partB).merge(this.partA.inverse()).merge(this.partB.inverse())
    }

    override fun inverse(): PureComm {
        return PureComm(this.partB.copy(), this.partA.copy())
    }

    override fun cancelationLength(): Int {
        return 2 * this.partA.moveLength() + 2 * this.partB.moveLength() - this.moveLength()
    }

    override fun transform(transform: Transform): PureComm {
        return PureComm(this.partA.transform(transform), this.partB.transform(transform))
    }

    override fun equals(other: Any?): Boolean {
        return other is PureComm && this.partA == other.partA && this.partB == other.partB
    }

    override fun hashCode(): Int {
        return this.partA.hashCode() + this.partB.hashCode()
    }

    override fun copy(): PureComm {
        return PureComm(this.partA.copy(), this.partB.copy())
    }

    companion object {
        fun isPureCommutable(algorithm: Algorithm): Boolean {
            //Not very useful atm, add functionality as long-term project??
            return algorithm is PureComm
        }
    }
}