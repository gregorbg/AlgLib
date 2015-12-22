package com.suushiemaniac.cubing.alglib.move.modifier;

public class SquareOneHalfModifier implements Modifier {
    public static SquareOneHalfModifier fromNumber(int number) {
        SquareOneDirectionModifier directionModifier = number < 0 ? SquareOneDirectionModifier.NEG : SquareOneDirectionModifier.POS;
        SquareOneNumModifier numModifier = SquareOneNumModifier.fromNotation(Math.abs(number) + "");
        return new SquareOneHalfModifier(directionModifier, numModifier);
    }

    private SquareOneDirectionModifier directionModifier;
    private SquareOneNumModifier numModifier;

    public SquareOneHalfModifier(SquareOneDirectionModifier directionModifier, SquareOneNumModifier numModifier) {
        this.directionModifier = directionModifier;
        this.numModifier = numModifier;
    }

    @Override
    public SquareOneHalfModifier inverse() {
        return new SquareOneHalfModifier(this.directionModifier.inverse(), this.numModifier);
    }

    @Override
    public SquareOneHalfModifier merge(Modifier other) {
        if (!(other instanceof SquareOneHalfModifier)) return null;
        int newRot = this.toNumber() + ((SquareOneHalfModifier) other).toNumber();
        if (newRot < -6) newRot = 6 + (newRot + 6);
        else if (newRot > 6) newRot = -6 + (newRot - 6);
        return SquareOneHalfModifier.fromNumber(newRot);
    }

    @Override
    public String toFormatString() {
        return this.directionModifier.toFormatString() + this.numModifier.toFormatString();
    }

    public int toNumber() {
        return Integer.parseInt(this.toFormatString());
    }

    public SquareOneDirectionModifier getDirectionModifier() {
        return this.directionModifier;
    }

    public SquareOneNumModifier getNumModifier() {
        return this.numModifier;
    }
}
