package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxUpModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxWideModifier;
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxPlane;
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxUpPlane;
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxWidePlane;
import com.suushiemaniac.cubing.alglib.transform.Transform;

public class MegaminxMove implements Move {
    private final MegaminxPlane plane;
    private final MegaminxModifier modifier;

    public MegaminxMove(MegaminxWidePlane plane, MegaminxWideModifier modifier) {
        this.plane = plane;
        this.modifier = modifier;
    }

    public MegaminxMove(MegaminxUpPlane plane, MegaminxUpModifier modifier) {
        this.plane = plane;
        this.modifier = modifier;
    }

    @Override
    public boolean merges(Move other) {
        return false;
    }

    @Override
    public boolean cancels(Move other) {
        return other instanceof MegaminxMove
                && this.plane == other.getPlane()
                && this.modifier == other.getModifier().inverse();
    }

    @Override
    public boolean mayAppend(Move other) {
        return true;
    }

    @Override
    public MegaminxPlane getPlane() {
        return this.plane;
    }

    @Override
    public MegaminxModifier getModifier() {
        return this.modifier;
    }

    @Override
    public MegaminxMove merge(Move other) {
        return null;
    }

    @Override
    public int getDepth() {
        return this.plane instanceof MegaminxUpPlane ? 1 : 6;
    }

    @Override
    public MegaminxMove inverse() {
        if (!this.plane.getType().equals(this.modifier.getType())) return null;
        if (this.plane instanceof MegaminxWidePlane && this.modifier instanceof MegaminxWideModifier)
            return new MegaminxMove((MegaminxWidePlane) this.plane, (MegaminxWideModifier) this.modifier.inverse());
        else if (this.plane instanceof MegaminxUpPlane && this.modifier instanceof MegaminxUpModifier)
            return new MegaminxMove((MegaminxUpPlane) this.plane, (MegaminxUpModifier) this.modifier.inverse());
        else return null;
    }

    @Override
    public Move transform(Transform transform) {
        return transform.supportsMoveClass(this) ? transform.transform(this) : this;
    }

    @Override
    public String toFormatString() {
        return this.plane.toFormatString() + this.modifier.toFormatString();
    }
}
