package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.transform.Transform

data class Conjugate(val setup: Algorithm, val inner: Algorithm) : CombinedAlg(setup, inner) {
    override fun ownCancellationLength() = 2 * this.setup.moveLength() + this.inner.moveLength() - this.moveLength()

    override fun plain() = this.setup + this.inner + this.setup.inverse()
    override fun inverse() = Conjugate(this.setup.copy(), this.inner.inverse())
    override operator fun invoke(first: Algorithm, second: Algorithm) = this.copy(setup = first, inner = second)

    override fun toString() = "[${this.setup} ${if (this.cancels()) ':' else ';'} ${this.inner}]"

    companion object {
        fun isConjugate(algorithm: Algorithm): Boolean {
            //Not very useful atm, add functionality as long-term project??
            return algorithm is Conjugate
        }
    }
}