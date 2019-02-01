package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SubGroup
import com.suushiemaniac.cubing.alglib.move.Move

abstract class Commutator : Algorithm {
    override val subGroup: SubGroup
        get() = this.plain().subGroup

    override val rotationGroup: SubGroup
        get() = this.plain().rotationGroup

    abstract fun ownCancellationLength(): Int

    fun cancels() = this.ownCancellationLength() > 0

    override fun allMoves() = this.plain().allMoves()
    override fun merge(other: Algorithm) = this.plain().merge(other)
    override fun append(other: Move) = this.plain().append(other)
    override fun moveLength() = this.plain().moveLength()
    override fun algLength() = this.plain().algLength()
}
