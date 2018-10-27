package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.transform.Transform

class SetupComm(val setup: Algorithm, val inner: Algorithm) : Commutator() {
    override fun toFormatString(): String {
        return "[${this.setup}${if (this.cancels()) ": " else "; "}${this.inner}]"
    }

    override fun develop(): Algorithm {
        return this.setup.copy().merge(this.inner).merge(this.setup.inverse())
    }

    override fun inverse(): SetupComm {
        return SetupComm(this.setup.copy(), this.inner.inverse())
    }

    override fun cancelationLength(): Int {
        return 2 * this.setup.moveLength() + this.inner.moveLength() - this.moveLength()
    }

    override fun transform(transform: Transform): SetupComm {
        return SetupComm(this.setup.transform(transform), this.inner.transform(transform))
    }

    override fun equals(other: Any?): Boolean {
        return other is SetupComm && this.setup == other.setup && this.inner == other.inner
    }

    override fun hashCode(): Int {
        return this.setup.hashCode() + this.inner.hashCode()
    }

    override fun copy(): SetupComm {
        return SetupComm(this.setup.copy(), this.inner.copy())
    }

    companion object {
        fun isSetupCommutable(algorithm: Algorithm): Boolean {
            //Not very useful atm, add functionality as long-term project??
            return algorithm is SetupComm
        }
    }
}