package com.suushiemaniac.cubing.alglib.alg

import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane
import com.suushiemaniac.cubing.alglib.move.plane.Plane

class SubGroup(vararg planes: Plane) {
    private val groupList = planes.toList().distinct().sortedBy(FIXED_ORDER::indexOf)

    private val elementsAsString
        get() = this.groupList.map { it.notation }

    val size: Int
        get() = this.groupList.size

    fun isEmpty() = this.groupList.isEmpty()

    fun toRawString(): String {
        return this.elementsAsString.joinToString("")
    }

    fun sameSubGroup(other: SubGroup): Boolean {
        return this.groupList == other.groupList
    }

    fun smallerSubGroup(other: SubGroup): Boolean {
        return this.size < other.size && other.groupList.containsAll(this.groupList)
    }

    fun sameOrSmallerSubGroup(other: SubGroup): Boolean {
        return this.sameSubGroup(other) || this.smallerSubGroup(other)
    }

    fun largerSubGroup(other: SubGroup): Boolean {
        return this.size > other.size && this.groupList.containsAll(other.groupList)
    }

    fun sameOrLargerSubGroup(other: SubGroup): Boolean {
        return this.sameSubGroup(other) || this.largerSubGroup(other)
    }

    override fun hashCode() = this.groupList.hashCode()
    override fun equals(other: Any?) = other is SubGroup && other.sameSubGroup(this)
    override fun toString() = this.elementsAsString.joinToString(",", prefix = "<", postfix = ">")

    companion object {
        private val FIXED_ORDER: Array<Plane> = arrayOf(CubicPlane.HORIZONTAL, CubicPlane.VERTICAL, CubicPlane.SPATIAL, CubicPlane.MIDDLE, CubicPlane.SANDWICH, CubicPlane.EQUATOR, CubicPlane.LEFT, CubicPlane.RIGHT, CubicPlane.UP, CubicPlane.DOWN, CubicPlane.FRONT, CubicPlane.BACK)

        fun fromAlg(alg: Algorithm, rotations: Boolean): SubGroup {
            val algPlanes = alg.allMoves()
                    .filter { it.plane.isRotation == rotations }
                    .map { it.plane }
                    .toTypedArray()

            return SubGroup(*algPlanes)
        }

        fun fromCubicGroupString(alg: String): SubGroup {
            val algPlanes = alg.substringAfter("<").substringBeforeLast(">").split(",")
                    .mapNotNull { CubicPlane.values().find { p -> p.notation == it } }
                    .toTypedArray()

            return SubGroup(*algPlanes)
        }
    }
}