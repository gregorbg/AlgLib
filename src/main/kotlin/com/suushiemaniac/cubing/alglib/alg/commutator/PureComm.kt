package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.transform.Transform

data class PureComm(val partA: Algorithm, val partB: Algorithm) : Commutator() {
    override fun ownCancellationLength() = 2 * this.partA.moveLength() + 2 * this.partB.moveLength() - this.moveLength()

    override fun plain() = this.partA + this.partB + this.partA.inverse() + this.partB.inverse()
    override fun inverse() = PureComm(this.partB.copy(), this.partA.copy())
    override fun transform(transform: Transform) = PureComm(this.partA.transform(transform), this.partB.transform(transform))
    override fun copy() = PureComm(this.partA.copy(), this.partB.copy())
    override fun toString() = "[${this.partA}, ${this.partB}]"

    companion object {
        fun isPureCommutable(algorithm: Algorithm): Boolean {
            //Not very useful atm, add functionality as long-term project??
            return algorithm is PureComm
        }
    }
}