package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.transform.Transform

data class SetupComm(val setup: Algorithm, val inner: Algorithm) : Commutator() {
    override fun ownCancellationLength() = 2 * this.setup.moveLength() + this.inner.moveLength() - this.moveLength()

    override fun plain() = this.setup + this.inner + this.setup.inverse()
    override fun inverse() = SetupComm(this.setup.copy(), this.inner.inverse())
    override fun transform(transform: Transform) = SetupComm(this.setup.transform(transform), this.inner.transform(transform))
    override fun copy() = SetupComm(this.setup.copy(), this.inner.copy())
    override fun toString() = "[${this.setup}${if (this.cancels()) ":" else ";"} ${this.inner}]"

    companion object {
        fun isSetupCommutable(algorithm: Algorithm): Boolean {
            //Not very useful atm, add functionality as long-term project??
            return algorithm is SetupComm
        }
    }
}