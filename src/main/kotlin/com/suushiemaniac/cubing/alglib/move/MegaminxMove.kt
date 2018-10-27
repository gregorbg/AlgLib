package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxModifier
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxUpModifier
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxWideModifier
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxPlane
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxUpPlane
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxWidePlane

class MegaminxMove : Move {
    override val plane: MegaminxPlane
    override val modifier: MegaminxModifier

    override val depth: Int
        get() = if (this.plane is MegaminxUpPlane) 1 else 6

    constructor(plane: MegaminxWidePlane, modifier: MegaminxWideModifier) {
        this.plane = plane
        this.modifier = modifier
    }

    constructor(plane: MegaminxUpPlane, modifier: MegaminxUpModifier) {
        this.plane = plane
        this.modifier = modifier
    }

    override fun merges(other: Move): Boolean {
        return false
    }

    override fun cancels(other: Move): Boolean {
        return (other is MegaminxMove
                && this.plane === other.plane
                && this.modifier === other.modifier.inverse())
    }

    override fun mayAppend(other: Move): Boolean {
        return true
    }

    override fun merge(other: Move): MegaminxMove {
        return other as MegaminxMove
    }

    override fun inverse(): MegaminxMove {
        if (this.plane.type != this.modifier.type) return this

        return if (this.plane is MegaminxWidePlane && this.modifier is MegaminxWideModifier)
            MegaminxMove(this.plane, this.modifier.inverse())
        else if (this.plane is MegaminxUpPlane && this.modifier is MegaminxUpModifier)
            MegaminxMove(this.plane, this.modifier.inverse())
        else
            this
    }

    override fun toString(): String {
        return this.toFormatString()
    }

    override fun toFormatString(): String {
        return this.plane.toFormatString() + this.modifier.toFormatString()
    }

    override fun equals(other: Any?): Boolean {
        return (other is MegaminxMove
                && other.plane === this.plane
                && other.modifier === this.modifier)
    }

    override fun hashCode(): Int {
        return this.toFormatString().hashCode()
    }
}
