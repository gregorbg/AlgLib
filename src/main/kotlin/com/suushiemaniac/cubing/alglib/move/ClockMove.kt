package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.ClockDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.ClockModifier
import com.suushiemaniac.cubing.alglib.move.modifier.ClockNumModifier
import com.suushiemaniac.cubing.alglib.move.plane.ClockPlane

class ClockMove : Move {
    override val plane: ClockPlane
    override val modifier: ClockModifier

    val isEndPinConfig: Boolean

    override val depth: Int
        get() = 1

    constructor(plane: ClockPlane) {
        this.plane = plane
        this.modifier = ClockModifier.endPinModifier
        this.isEndPinConfig = true
    }

    constructor(plane: ClockPlane, numModifier: ClockNumModifier, directionModifier: ClockDirectionModifier) {
        this.plane = plane
        this.modifier = ClockModifier(numModifier, directionModifier)
        this.isEndPinConfig = false
    }

    constructor(plane: ClockPlane, modifier: ClockModifier) {
        this.plane = plane
        this.modifier = modifier
        this.isEndPinConfig = false
    }

    override fun merges(other: Move): Boolean {
        return (other is ClockMove
                && this.mayAppend(other)
                && !other.isEndPinConfig
                && this.plane == other.plane
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is ClockMove
                && this.mayAppend(other)
                && !other.isEndPinConfig
                && this.plane == other.plane
                && this.modifier.toNumber() + other.modifier.toNumber() == 0)
    }

    override fun mayAppend(other: Move): Boolean {
        return !this.isEndPinConfig
    }

    override fun merge(other: Move): ClockMove {
        return if (other !is ClockMove || this.isEndPinConfig) other as ClockMove else ClockMove(this.plane, this.modifier.merge(other.modifier))
    }

    override fun inverse(): Move {
        return if (this.isEndPinConfig) ClockMove(this.plane) else ClockMove(this.plane, this.modifier.inverse())
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun equals(other: Any?): Boolean {
        return (other is ClockMove
                && other.modifier == this.modifier
                && other.plane == this.plane
                && other.isEndPinConfig == this.isEndPinConfig)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }

    override fun toFormatString(): String {
        return if (this.isEndPinConfig)
            this.plane.toFormatString()
        else
            this.plane.toFormatString() + if (this.plane.isRotation) this.modifier.numModifier.toFormatString() else this.modifier.toFormatString()
    }
}