package com.suushiemaniac.cubing.alglib.alg

import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane
import com.suushiemaniac.cubing.alglib.move.plane.Plane
import com.suushiemaniac.cubing.alglib.util.FixArrayComparator
import com.suushiemaniac.cubing.alglib.util.StringFormat

class SubGroup(vararg planes: Plane) : StringFormat {
    private val groupList: MutableList<Plane> = mutableListOf()

    private val elementsAsString
        get() = this.groupList.map { it.toFormatString() }

    val isEmpty
        get() = this.size() == 0

    init {
        for (p in planes) {
            if (!this.groupList.contains(p)) {
                this.groupList.add(p)
            }
        }

        val orderedPlanes: Array<Plane> = arrayOf(CubicPlane.HORIZONTAL, CubicPlane.VERTICAL, CubicPlane.SPATIAL, CubicPlane.MIDDLE, CubicPlane.SANDWICH, CubicPlane.EQUATOR, CubicPlane.LEFT, CubicPlane.RIGHT, CubicPlane.UP, CubicPlane.DOWN, CubicPlane.FRONT, CubicPlane.BACK)
        this.groupList.sortedWith(FixArrayComparator(orderedPlanes))
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun toFormatString(): String {
        return this.elementsAsString.joinToString(",", prefix = "<", postfix = ">")
    }

    fun toRawString(): String {
        return this.elementsAsString.joinToString("")
    }

    fun sameSubGroup(other: SubGroup): Boolean {
        return this.size() == other.size() && this.containsAll(other) && other.containsAll(this)
    }

    fun smallerSubGroup(other: SubGroup): Boolean {
        return this.size() < other.size() && other.containsAll(this)
    }

    fun sameOrSmallerSubGroup(other: SubGroup): Boolean {
        return this.sameSubGroup(other) || this.smallerSubGroup(other)
    }

    fun largerSubGroup(other: SubGroup): Boolean {
        return this.size() > other.size() && this.containsAll(other)
    }

    fun sameOrLargerSubGroup(other: SubGroup): Boolean {
        return this.sameSubGroup(other) || this.largerSubGroup(other)
    }

    fun size(): Int {
        return this.groupList.size
    }

    fun containsAll(other: SubGroup): Boolean {
        return this.groupList.containsAll(other.groupList)
    }

    override fun hashCode(): Int {
        return this.toRawString().hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is SubGroup && other.sameSubGroup(this)
    }

    companion object {
        fun fromAlg(alg: Algorithm, rotations: Boolean): SubGroup {
            val algPlanes = alg.allMoves()
                    .filter { it.plane.isRotation == rotations }
                    .map { it.plane }
                    .toTypedArray()

            return SubGroup(*algPlanes)
        }

        fun fromCubicGroupString(alg: String): SubGroup {
            val algPlanes = alg.substringAfter("<").substringBeforeLast(">").split(",")
                    .map { CubicPlane.fromNotation(it) }
                    .filterNotNull()
                    .toTypedArray()

            return SubGroup(*algPlanes)
        }
    }
}