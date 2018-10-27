package com.suushiemaniac.cubing.alglib.alg

import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.transform.Transform
import com.suushiemaniac.cubing.alglib.util.StringFormat

interface Algorithm : StringFormat, Iterable<Move>, Comparable<Algorithm> {
    val subGroup: SubGroup

    val rotationGroup: SubGroup

    fun inverse(): Algorithm

    fun plain(): Algorithm

    fun moveLength(): Int

    fun algLength(): Int

    fun cancellationLength(other: Algorithm): Int

    fun merge(other: Algorithm): Algorithm

    fun append(other: Move): Algorithm

    fun transform(transform: Transform): Algorithm

    fun nMove(n: Int): Move

    fun firstMove(): Move

    fun lastMove(): Move

    fun allMoves(): List<Move>

    fun subAlg(from: Int, to: Int): Algorithm

    fun copy(): Algorithm

    override fun iterator(): Iterator<Move> {
        return this.plain().allMoves().iterator()
    }

    operator fun get(index: Int): Move {
        return this.nMove(index)
    }

    override operator fun compareTo(other: Algorithm): Int {
        return this.toFormatString().compareTo(other.toFormatString())
    }
}
