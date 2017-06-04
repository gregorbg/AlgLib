package com.suushiemaniac.cubing.alglib.move.modifier;

public class ClockModifier implements Modifier {
    public static final ClockModifier endPinModifier = new ClockModifier(ClockNumModifier.ZERO, ClockDirectionModifier.NEG);

    public static ClockModifier fromNumber(int number) {
        ClockNumModifier numModifier = ClockNumModifier.fromNotation(Math.abs(number) + "");
        ClockDirectionModifier directionModifier = number < 0 ? ClockDirectionModifier.NEG : ClockDirectionModifier.POS;
        return new ClockModifier(numModifier, directionModifier);
    }

    private ClockNumModifier numModifier;
    private ClockDirectionModifier directionModifier;

    public ClockModifier(ClockNumModifier numModifier, ClockDirectionModifier directionModifier) {
        this.numModifier = numModifier;
        this.directionModifier = directionModifier;
    }

    public ClockNumModifier getNumModifier() {
        return this.numModifier;
    }

    public ClockDirectionModifier getDirectionModifier() {
        return this.directionModifier;
    }

    @Override
    public ClockModifier inverse() {
        return new ClockModifier(this.numModifier, this.directionModifier.inverse());
    }

    @Override
    public ClockModifier merge(Modifier other) {
        if (!(other instanceof ClockModifier)) return null;
        int newRot = this.toNumber() + ((ClockModifier) other).toNumber();
        if (newRot < -6) newRot = 6 + (newRot + 6);
        else if (newRot > 6) newRot = -6 + (newRot - 6);
        return ClockModifier.fromNumber(newRot);
    }

    @Override
    public String toFormatString() {
        return this.numModifier.toFormatString() + this.directionModifier.toFormatString();
    }

    public String toNumString() {
        return this.directionModifier.toFormatString() + this.numModifier.toFormatString();
    }

    public int toNumber() {
        return Integer.parseInt(this.toNumString());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ClockModifier
                && ((ClockModifier) obj).numModifier == this.numModifier
                && ((ClockModifier) obj).directionModifier == this.directionModifier;
    }

    @Override
    public int hashCode() {
        return this.toFormatString().hashCode();
    }
}