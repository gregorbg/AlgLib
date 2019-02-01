package com.suushiemaniac.cubing.alglib.alg

import com.suushiemaniac.cubing.alglib.move.Move
import com.suushiemaniac.cubing.alglib.transform.Transform

class SimpleAlg(moves: List<Move> = emptyList(), private val formatDelimiter: String = " ") : Algorithm {
    private val moves = reduced(moves)

    override val subGroup: SubGroup
        get() = SubGroup.fromAlg(this, false)

    override val rotationGroup: SubGroup
        get() = SubGroup.fromAlg(this, true)

    override fun inverse() = SimpleAlg(this.moves.reversed().map(Move::inverse))
    override fun plain() = this.copy()

    override fun allMoves() = this.moves.toList()

    override fun moveLength() = this.moves.count { !it.plane.isRotation }
    override fun algLength() = this.moves.size

    override fun merge(other: Algorithm) = SimpleAlg(this.allMoves() + other.allMoves())
    override fun append(other: Move) = SimpleAlg(this.allMoves() + other)

    override fun transform(transform: Transform) = SimpleAlg(this.allMoves().map(transform::transform))

    override fun equals(other: Any?) = other is SimpleAlg && this.allMoves() == other.allMoves()
    override fun hashCode() = this.allMoves().hashCode()
    override fun toString() = this.allMoves().joinToString(this.formatDelimiter)

    override fun copy() = SimpleAlg(this.allMoves())

    companion object {
        fun reduced(raw: List<Move>): List<Move> {
            val reduced = mutableListOf<Move>()

            for (move in raw) {
                when {
                    reduced.isEmpty() -> reduced.add(move)
                    reduced.last().cancels(move) -> reduced.removeAt(reduced.size - 1)
                    reduced.last().merges(move) -> reduced[reduced.size - 1] = reduced[reduced.size - 1].merge(move)
                    reduced.last().mayAppend(move) -> reduced.add(move)
                }
            }

            return reduced
        }
    }
}