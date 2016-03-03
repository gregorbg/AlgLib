package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier;
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import com.suushiemaniac.cubing.alglib.transform.Transform;

public class CubicMove implements Move {
    private final CubicPlane plane;
    private final CubicModifier modifier;
    private final int depth;

    public CubicMove(CubicPlane plane, CubicModifier modifier, int depth) {
        this.plane = plane;
        this.modifier = modifier;
        this.depth = depth;
    }

    @Override
    public boolean merges(Move other) {
        return other instanceof CubicMove
                && this.plane == other.getPlane()
                && this.depth == other.getDepth()
                && !this.cancels(other);
    }

    @Override
    public boolean cancels(Move other) {
        return other instanceof CubicMove
                && this.plane == other.getPlane()
                && this.depth == other.getDepth()
                && this.modifier == other.getModifier().inverse();
    }

    @Override
    public boolean mayAppend(Move other) {
        return true;
    }

    public CubicPlane getPlane() {
        return this.plane;
    }

    public CubicModifier getModifier() {
        return this.modifier;
    }

    public int getDepth() {
        return this.depth;
    }

    @Override
    public CubicMove merge(Move other) {
        if (!(other instanceof CubicMove)) return null;
        return new CubicMove(this.plane, this.modifier.merge(other.getModifier()), this.depth);
    }

    @Override
    public CubicMove inverse() {
        return new CubicMove(this.plane, this.modifier.inverse(), this.depth);
    }

    @Override
    public Move transform(Transform transform) {
        return transform.transform(this);
    }

    @Override
    public String toFormatString() {
        return (this.depth > (this.plane.name().contains("SLICE") ? 1 : 2) ? String.valueOf(this.depth) : "") + this.plane.toFormatString() + (this.depth > 1 && !this.plane.name().contains("SLICE") ? "w" : "") + this.modifier.toFormatString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CubicMove)) return false;
        else {
            CubicMove compareTo = (CubicMove) obj;
            return this.plane == compareTo.getPlane()
                    && this.modifier == compareTo.getModifier()
                    && this.depth == compareTo.getDepth();
        }
    }
}