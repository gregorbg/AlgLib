package com.suushiemaniac.cubing.alglib.alg

import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.transform.Transform

class SimpleAlg(private var moves: List<Move>) : Algorithm {
    private var formatDelimiter: String = " "

    override val subGroup: SubGroup
        get() = SubGroup.fromAlg(this, false)

    override val rotationGroup: SubGroup
        get() = SubGroup.fromAlg(this, true)

    constructor(other: Algorithm) : this(other.allMoves())
    constructor(vararg moves: Move) : this(listOf(*moves))

    init {
        this.reduce()
    }

    fun setFormatDelimiter(formatDelimiter: String) {
        this.formatDelimiter = formatDelimiter
    }

    protected fun reduce(): SimpleAlg {
        val reduced = mutableListOf<Move>()

        for (move in this.moves) {
            when {
                reduced.isEmpty() -> reduced.add(move)
                reduced.last().cancels(move) -> reduced.removeAt(reduced.size - 1)
                reduced.last().merges(move) -> reduced[reduced.size - 1] = reduced[reduced.size - 1].merge(move)
                reduced.last().mayAppend(move) -> reduced.add(move)
            }
        }

        this.moves = reduced.toMutableList()

        return this
    }

    override fun inverse(): SimpleAlg {
        val reversedMoves = this.moves.reversed().map(Move::inverse)

        return SimpleAlg(reversedMoves)
    }

    override fun plain(): Algorithm {
        return SimpleAlg(this.allMoves())
    }

    override fun toFormatString(): String {
        return this.allMoves().joinToString(this.formatDelimiter)
    }

    override fun moveLength(): Int {
        return this.moves.count { !it.plane.isRotation }
    }

    override fun algLength(): Int {
        return this.moves.size
    }

    override fun merge(other: Algorithm): SimpleAlg {
        val oldMoves = this.allMoves() + other.allMoves()
        this.moves = oldMoves.toMutableList()

        return this.reduce()
    }

    override fun append(other: Move): SimpleAlg {
        val oldMoves = this.allMoves() + other
        this.moves = oldMoves.toMutableList()

        return this.reduce()
    }

    override fun transform(transform: Transform): Algorithm {
        val oldMoves = this.allMoves().map { it.transform(transform) }
        this.moves = oldMoves.toMutableList()

        return this.reduce()
    }

    override fun cancellationLength(other: Algorithm): Int {
        return (this.moveLength() + other.moveLength() - SimpleAlg(this.allMoves()).merge(other).moveLength()) / 2
    }

    override fun nMove(n: Int): Move {
        return this.moves[n]
    }

    override fun firstMove(): Move {
        return this.moves.first()
    }

    override fun lastMove(): Move {
        return this.moves.last()
    }

    override fun allMoves(): List<Move> {
        return this.moves.toList()
    }

    override fun subAlg(from: Int, to: Int): Algorithm {
        return SimpleAlg(this.moves.subList(from, to))
    }

    override fun equals(other: Any?): Boolean {
        return (other is SimpleAlg
                && this.allMoves().containsAll(other.allMoves())
                && other.allMoves().containsAll(this.allMoves()))
    }

    override fun hashCode(): Int {
        return this.allMoves().hashCode()
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun copy(): Algorithm {
        return SimpleAlg(this)
    }
}