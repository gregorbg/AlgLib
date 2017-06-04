package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.PyraminxModifier;
import com.suushiemaniac.cubing.alglib.move.plane.PyraminxPlane;
import com.suushiemaniac.cubing.alglib.transform.Transform;

public class PyraminxMove implements Move {
    private final PyraminxPlane plane;
    private final PyraminxModifier modifier;
    private final int depth;

    public PyraminxMove(PyraminxPlane plane, PyraminxModifier modifier, int depth) {
        this.plane = plane;
        this.modifier = modifier;
        this.depth = depth;
    }

    @Override
    public boolean merges(Move other) {
        return other instanceof PyraminxMove
                && this.plane == other.getPlane()
                && this.depth == other.getDepth()
                && !this.cancels(other);
    }

    @Override
    public boolean cancels(Move other) {
        return other instanceof PyraminxMove
                && this.plane == other.getPlane()
                && this.depth == other.getDepth()
                && this.modifier == other.getModifier().inverse();
    }

    @Override
    public boolean mayAppend(Move other) {
        return true;
    }

    @Override
    public PyraminxPlane getPlane() {
        return this.plane;
    }

    @Override
    public PyraminxModifier getModifier() {
        return this.modifier;
    }

    @Override
    public PyraminxMove merge(Move other) {
        if (!(other instanceof PyraminxMove)) return null;
        return new PyraminxMove(this.plane, this.modifier.merge(other.getModifier()), this.depth);
    }

    @Override
    public int getDepth() {
        return this.depth;
    }

    @Override
    public Move inverse() {
        return new PyraminxMove(this.plane, this.modifier.inverse(), this.depth);
    }

    @Override
    public Move transform(Transform transform) {
        return transform.transform(this);
    }

    @Override
    public String toString() {
        return this.toFormatString();
    }

    @Override
    public String toFormatString() {
        return (this.depth == 0 ? this.plane.toFormatString().toLowerCase() : this.plane.toFormatString()) + this.modifier.toFormatString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PyraminxMove
                && ((PyraminxMove) obj).plane == this.plane
                && ((PyraminxMove) obj).modifier == this.modifier
                && ((PyraminxMove) obj).depth == this.depth;
    }

    @Override
	public int hashCode() {
		return this.toFormatString().hashCode();
	}
}
