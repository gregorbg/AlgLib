package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.SkewbModifier;
import com.suushiemaniac.cubing.alglib.move.plane.SkewbPlane;
import com.suushiemaniac.cubing.alglib.transform.Transform;

public class SkewbMove implements Move {
    private final SkewbPlane plane;
    private final SkewbModifier modifier;

    public SkewbMove(SkewbPlane plane, SkewbModifier modifier) {
        this.plane = plane;
        this.modifier = modifier;
    }

    @Override
    public boolean merges(Move other) {
        return other instanceof SkewbMove
                && this.plane == other.getPlane()
                && !this.cancels(other);
    }

    @Override
    public boolean cancels(Move other) {
        return other instanceof SkewbMove
                && this.plane == other.getPlane()
                && this.modifier == other.getModifier().inverse();
    }

    @Override
    public boolean mayAppend(Move other) {
        return true;
    }

    @Override
    public SkewbPlane getPlane() {
        return this.plane;
    }

    @Override
    public SkewbModifier getModifier() {
        return this.modifier;
    }

    @Override
    public SkewbMove merge(Move other) {
        if (!(other instanceof SkewbMove)) return null;
        return new SkewbMove(this.plane, this.modifier.merge(other.getModifier()));
    }

    @Override
    public int getDepth() {
        return 1;
    }

    @Override
    public SkewbMove inverse() {
        return new SkewbMove(this.plane, this.modifier.inverse());
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
