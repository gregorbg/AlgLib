package com.suushiemaniac.cubing.alglib.alg

import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.transform.Transform

interface Algorithm : List<Move>, Comparable<Algorithm> {
    val subGroup: SubGroup

    val rotationGroup: SubGroup

    override val size: Int
        get() = this.algLength()

    fun inverse(): Algorithm

    fun plain(): Algorithm

    fun algLength(): Int

    fun moveLength(): Int

    fun merge(other: Algorithm): Algorithm

    fun append(other: Move): Algorithm

    fun transform(transform: Transform): Algorithm

    fun copy(): Algorithm

    fun allMoves(): List<Move>

    fun firstMove(): Move {
        return this.plain().allMoves().first()
    }

    fun lastMove(): Move {
        return this.plain().allMoves().last()
    }

    fun nMove(n: Int): Move {
        return this.plain().allMoves()[n]
    }

    fun cancellationLength(other: Algorithm): Int {
        val sumLength = this.algLength() + other.algLength()
        val actualMerged = this + other

        return (sumLength - actualMerged.algLength()) / 2
    }

    override fun contains(element: Move) = this.allMoves().contains(element)
    override fun containsAll(elements: Collection<Move>) = this.allMoves().containsAll(elements)
    override fun get(index: Int) = this.allMoves()[index]
    override fun indexOf(element: Move) = this.allMoves().indexOf(element)
    override fun lastIndexOf(element: Move) = this.allMoves().lastIndexOf(element)
    override fun isEmpty() = this.allMoves().isEmpty()
    override fun listIterator() = this.allMoves().listIterator()
    override fun listIterator(index: Int) = this.allMoves().listIterator(index)
    override fun subList(fromIndex: Int, toIndex: Int) = this.allMoves().subList(fromIndex, toIndex)

    operator fun plus(other: Algorithm): Algorithm {
        return this.merge(other)
    }

    operator fun plus(other: Move): Algorithm {
        return this.append(other)
    }

    override fun iterator(): Iterator<Move> {
        return this.allMoves().iterator()
    }

    override operator fun compareTo(other: Algorithm): Int {
        return this.toString().compareTo(other.toString())
    }
}
