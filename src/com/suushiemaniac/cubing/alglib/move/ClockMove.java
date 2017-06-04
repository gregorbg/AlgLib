package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.ClockDirectionModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.ClockModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.ClockNumModifier;
import com.suushiemaniac.cubing.alglib.move.plane.ClockPlane;
import com.suushiemaniac.cubing.alglib.transform.Transform;

public class ClockMove implements Move {
    private final ClockPlane plane;
    private final ClockModifier modifier;
    private final boolean endPinConfig;

    public ClockMove(ClockPlane plane) {
        this.plane = plane;
        this.modifier = ClockModifier.endPinModifier;
        this.endPinConfig = true;
    }

    public ClockMove(ClockPlane plane, ClockNumModifier numModifier, ClockDirectionModifier directionModifier) {
        this.plane = plane;
        this.modifier = new ClockModifier(numModifier, directionModifier);
        this.endPinConfig = false;
    }

    public ClockMove(ClockPlane plane, ClockModifier modifier) {
        this.plane = plane;
        this.modifier = modifier;
        this.endPinConfig = false;
    }

    @Override
    public boolean merges(Move other) {
        return other instanceof ClockMove
                && this.mayAppend(other)
                && !((ClockMove) other).isEndPinConfig()
                && this.plane == other.getPlane()
                && !this.cancels(other);
    }

    @Override
    public boolean cancels(Move other) {
        return other instanceof ClockMove
                && this.mayAppend(other)
                && !((ClockMove) other).isEndPinConfig()
                && this.plane == other.getPlane()
                && this.modifier.toNumber() + ((ClockMove) other).getModifier().toNumber() == 0;
    }

    @Override
    public boolean mayAppend(Move other) {
        return !this.endPinConfig;
    }

    @Override
    public ClockPlane getPlane() {
        return this.plane;
    }

    @Override
    public ClockModifier getModifier() {
        return this.modifier;
    }

    @Override
    public ClockMove merge(Move other) {
        if (!(other instanceof ClockMove) || this.endPinConfig) return null;
        return new ClockMove(this.plane, this.modifier.merge(other.getModifier()));
    }

    @Override
    public int getDepth() {
        return 1;
    }

    @Override
    public Move inverse() {
        return this.endPinConfig ? new ClockMove(this.plane) : new ClockMove(this.plane, this.modifier.inverse());
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
	public boolean equals(Object obj) {
		return obj instanceof ClockMove
                && ((ClockMove) obj).modifier.equals(this.modifier)
                && ((ClockMove) obj).plane == this.plane
                && ((ClockMove) obj).endPinConfig == this.endPinConfig;
	}

	@Override
	public int hashCode() {
		return this.toFormatString().hashCode();
	}

	@Override
    public String toFormatString() {
        if (this.endPinConfig) return this.plane.toFormatString();
        else return this.plane.toFormatString() + (this.plane.isRotation() ? this.modifier.getNumModifier().toFormatString() : this.modifier.toFormatString());
    }

    public boolean isEndPinConfig() {
        return this.endPinConfig;
    }
}