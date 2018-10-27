package com.suushiemaniac.cubing.alglib.alg.commutator

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SubGroup
import com.suushiemaniac.cubing.alglib.move.Move

abstract class Commutator : Algorithm {
    override val subGroup: SubGroup
        get() = this.develop().subGroup

    override val rotationGroup: SubGroup
        get() = this.develop().rotationGroup

    abstract fun cancelationLength(): Int

    abstract fun develop(): Algorithm

    abstract override fun inverse(): Commutator
    abstract override fun equals(other: Any?): Boolean

    fun cancels(): Boolean {
        return this.cancelationLength() > 0
    }

    fun toPlainString(): String {
        return this.develop().toFormatString()
    }

    override fun nMove(n: Int): Move {
        return this.develop().nMove(n)
    }

    override fun firstMove(): Move {
        return this.develop().firstMove()
    }

    override fun lastMove(): Move {
        return this.develop().lastMove()
    }

    override fun allMoves(): List<Move> {
        return this.develop().allMoves()
    }

    override fun subAlg(from: Int, to: Int): Algorithm {
        return this.develop().subAlg(from, to)
    }

    override fun cancellationLength(other: Algorithm): Int {
        return this.develop().cancellationLength(other)
    }

    override fun merge(other: Algorithm): Algorithm {
        return this.develop().merge(other)
    }

    override fun append(other: Move): Algorithm {
        return this.develop().append(other)
    }

    override fun plain(): Algorithm {
        return this.develop()
    }

    override fun moveLength(): Int {
        return this.develop().moveLength()
    }

    override fun algLength(): Int {
        return this.develop().algLength()
    }

    override fun hashCode(): Int {
        return this.develop().hashCode()
    }

    override fun toString(): String {
        return this.toFormatString()
    }
}
