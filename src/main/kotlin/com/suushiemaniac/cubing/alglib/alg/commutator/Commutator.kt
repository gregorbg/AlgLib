package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.transform.Transform

data class Commutator(val partA: Algorithm, val partB: Algorithm) : CombinedAlg(partA, partB) {
    override fun ownCancellationLength() = 2 * this.partA.moveLength() + 2 * this.partB.moveLength() - this.moveLength()

    override fun plain() = this.partA + this.partB + this.partA.inverse() + this.partB.inverse()
    override fun inverse() = Commutator(this.partB.copy(), this.partA.copy())
    override operator fun invoke(first: Algorithm, second: Algorithm) = this.copy(partA = first, partB = second)

    override fun toString() = "[${this.partA} , ${this.partB}]"

    companion object {
        fun isCommutator(algorithm: Algorithm): Boolean {
            //Not very useful atm, add functionality as long-term project??
            return algorithm is Commutator
        }
    }
}