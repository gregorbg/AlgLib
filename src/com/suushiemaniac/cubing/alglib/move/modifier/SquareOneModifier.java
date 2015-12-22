package com.suushiemaniac.cubing.alglib.move.modifier;

public class SquareOneModifier implements Modifier {
    private SquareOneHalfModifier halfModifierUp;
    private SquareOneHalfModifier halfModifierDown;

    public SquareOneModifier(SquareOneHalfModifier halfModifierUp, SquareOneHalfModifier halfModifierDown) {
        this.halfModifierUp = halfModifierUp;
        this.halfModifierDown = halfModifierDown;
    }

    @Override
    public SquareOneModifier inverse() {
        return new SquareOneModifier(this.halfModifierUp.inverse(), this.halfModifierDown.inverse());
    }

    @Override
    public SquareOneModifier merge(Modifier other) {
        if (!(other instanceof SquareOneModifier)) return null;
        return new SquareOneModifier(this.halfModifierUp.merge(((SquareOneModifier) other).getHalfModifierUp()), this.halfModifierDown.merge(((SquareOneModifier) other).getHalfModifierDown()));
    }

    @Override
    public String toFormatString() {
        return "(" + this.halfModifierUp.toFormatString() + "," + this.halfModifierDown.toFormatString() + ")";
    }

    public SquareOneHalfModifier getHalfModifierUp() {
        return this.halfModifierUp;
    }

    public SquareOneHalfModifier getHalfModifierDown() {
        return this.halfModifierDown;
    }
}
