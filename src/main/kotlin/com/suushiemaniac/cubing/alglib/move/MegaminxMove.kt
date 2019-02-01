package com.suushiemaniac.cubing.alglib.move

import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxModifier
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxUpModifier
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxWideModifier
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxPlane
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxUpPlane
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxWidePlane

data class MegaminxMove(override val plane: MegaminxPlane, override val modifier: MegaminxModifier) : Move {
    override val notation = "${this.plane.notation}${this.modifier.notation}"
    override val depth = if (this.plane is MegaminxUpPlane) 1 else 6

    override fun cancels(other: Move): Boolean {
        return (other is MegaminxMove
                && this.plane === other.plane
                && this.modifier === other.modifier.inverse())
    }

    override fun mayAppend(other: Move) = other is MegaminxMove
    override fun merges(other: Move) = false
    override fun merge(other: Move) = other as MegaminxMove

    override fun inverse(): MegaminxMove {
        if (this.plane.type != this.modifier.type) return this

        return if (this.plane is MegaminxWidePlane && this.modifier is MegaminxWideModifier)
            MegaminxMove(this.plane, this.modifier.inverse())
        else if (this.plane is MegaminxUpPlane && this.modifier is MegaminxUpModifier)
            MegaminxMove(this.plane, this.modifier.inverse())
        else
            this
    }

    override fun toString() = this.notation
}
