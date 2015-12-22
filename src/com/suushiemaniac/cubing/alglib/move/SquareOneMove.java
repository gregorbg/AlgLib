package com.suushiemaniac.cubing.alglib.move;

import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneDirectionModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneHalfModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneNumModifier;
import com.suushiemaniac.cubing.alglib.move.plane.SquareOnePlane;

public class SquareOneMove implements Move {
    private final SquareOnePlane plane = new SquareOnePlane();
    private final SquareOneModifier modifier;
    private final boolean endSlash;
    private final boolean beginSlash;

    public SquareOneMove(SquareOneModifier modifier, boolean beginSlash, boolean endSlash) {
        this.modifier = modifier;
        this.beginSlash = beginSlash;
        this.endSlash = endSlash;
    }

    public SquareOneMove(SquareOneHalfModifier modifierUp, SquareOneHalfModifier modifierDown, boolean beginSlash, boolean endSlash) {
        this.modifier = new SquareOneModifier(modifierUp, modifierDown);
        this.beginSlash = beginSlash;
        this.endSlash = endSlash;
    }

    public SquareOneMove(SquareOneDirectionModifier directionModifierUp, SquareOneNumModifier numModifierUp, SquareOneDirectionModifier directionModifierDown, SquareOneNumModifier numModifierDown, boolean beginSlash, boolean endSlash) {
        this.modifier = new SquareOneModifier(new SquareOneHalfModifier(directionModifierUp, numModifierUp), new SquareOneHalfModifier(directionModifierDown, numModifierDown));
        this.beginSlash = beginSlash;
        this.endSlash = endSlash;
    }

    @Override
    public boolean merges(Move other) {
        return other instanceof SquareOneMove
                && !this.endSlash
                && !((SquareOneMove) other).isBeginSlash()
                && !this.cancels(other)
                && this.mayAppend(other);
    }

    @Override
    public boolean cancels(Move other) {
        return other instanceof SquareOneMove
                && this.mayAppend(other)
                && !this.endSlash
                && this.modifier.getHalfModifierUp().toNumber() + ((SquareOneModifier) other.getModifier()).getHalfModifierUp().toNumber() == 0
                && this.modifier.getHalfModifierDown().toNumber() + ((SquareOneModifier) other.getModifier()).getHalfModifierDown().toNumber() == 0;
    }

    @Override
    public boolean mayAppend(Move other) {
        return !this.endSlash || !((SquareOneMove) other).beginSlash;
    }

    @Override
    public SquareOnePlane getPlane() {
        return this.plane;
    }

    @Override
    public SquareOneModifier getModifier() {
        return this.modifier;
    }

    @Override
    public SquareOneMove merge(Move other) {
        if (!(other instanceof SquareOneMove)) return null;
        return new SquareOneMove(this.modifier.merge(other.getModifier()), this.beginSlash, this.endSlash);
    }

    @Override
    public int getDepth() {
        return 1;
    }

    @Override
    public SquareOneMove inverse() {
        return new SquareOneMove(this.modifier.inverse(), this.beginSlash, this.endSlash);
    }

    @Override
    public String toFormatString() {
        return (this.beginSlash ? "/ " : "") + this.modifier.toFormatString() + (this.endSlash ? " /" : "");
    }

    public boolean isBeginSlash() {
        return this.beginSlash;
    }

    public boolean isEndSlash() {
        return this.endSlash;
    }
}