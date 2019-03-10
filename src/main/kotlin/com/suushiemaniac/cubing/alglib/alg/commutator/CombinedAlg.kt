package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SubGroup
import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.transform.Transform

abstract class CombinedAlg(val first: Algorithm, val second: Algorithm) : Algorithm {
    override val subGroup: SubGroup
        get() = this.plain().subGroup

    override val rotationGroup: SubGroup
        get() = this.plain().rotationGroup

    abstract fun ownCancellationLength(): Int
    abstract operator fun invoke(first: Algorithm, second: Algorithm): Algorithm

    fun cancels() = this.ownCancellationLength() > 0

    override fun allMoves() = this.plain().allMoves()
    override fun merge(other: Algorithm) = this.plain().merge(other)
    override fun append(other: Move) = this.plain().append(other)
    override fun moveLength() = this.plain().moveLength()
    override fun algLength() = this.plain().algLength()
    override fun transform(transform: Transform) = this(this.first.transform(transform), this.second.transform(transform))
    override fun copy() = this(this.first.copy(), this.second.copy())
}
