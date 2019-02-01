package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.ClockDirectionModifier
import com.suushiemaniac.cubing.alglib.move.modifier.ClockModifier
import com.suushiemaniac.cubing.alglib.move.modifier.ClockNumModifier
import com.suushiemaniac.cubing.alglib.move.plane.ClockPlane

data class ClockMove(override val plane: ClockPlane, override val modifier: ClockModifier, val isEndPinConfig: Boolean) : Move {
    override val notation = if (this.isEndPinConfig) this.plane.notation else this.plane.notation + if (this.plane.isRotation) this.modifier.numModifier.notation else this.modifier.notation

    override val depth = 1

    constructor(plane: ClockPlane) : this(plane, ClockModifier.endPinModifier, true)
    constructor(plane: ClockPlane, numModifier: ClockNumModifier, directionModifier: ClockDirectionModifier) : this(plane, ClockModifier(numModifier, directionModifier), false)
    constructor(plane: ClockPlane, modifier: ClockModifier) : this(plane, modifier, false)

    override fun merges(other: Move): Boolean {
        return (other is ClockMove
                && !this.isEndPinConfig
                && !other.isEndPinConfig
                && this.plane == other.plane
                && !this.cancels(other))
    }

    override fun cancels(other: Move): Boolean {
        return (other is ClockMove
                && !this.isEndPinConfig
                && !other.isEndPinConfig
                && this.plane == other.plane
                && this.modifier.toNumber() + other.modifier.toNumber() == 0)
    }

    override fun mayAppend(other: Move) = !this.isEndPinConfig
    override fun merge(other: Move) = ClockMove(this.plane, this.modifier.merge(other.modifier))
    override fun inverse() = if (this.isEndPinConfig) ClockMove(this.plane) else ClockMove(this.plane, this.modifier.inverse())

    override fun toString() = this.notation
}