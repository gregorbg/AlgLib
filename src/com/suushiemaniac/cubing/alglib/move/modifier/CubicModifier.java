package com.suushiemaniac.cubing.alglib.move.modifier;

public enum CubicModifier implements Modifier {
    CW(""), DOUBLE("2"), CCW("'");

    public static CubicModifier fromNotation(String notation) {
        for (CubicModifier modifier : CubicModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    CubicModifier(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return this.notation;
    }

    @Override
    public String toFormatString() {
        return this.getNotation();
    }

    @Override
    public CubicModifier inverse() {
        return CubicModifier.values()[-this.ordinal() + CubicModifier.values().length - 1];
    }

    //TODO correct merging index;
    @Override
    public CubicModifier merge(Modifier other) {
        CubicModifier switchModifier;
        if (other instanceof CubicModifier) switchModifier = (CubicModifier) other;
        else return null;
        return switchModifier == this.inverse() ? null : CubicModifier.values()
                [(-2 * this.ordinal() * this.ordinal() + 3 * this.ordinal() + 1) + (2 * this.ordinal() * this.ordinal() - 4 * this.ordinal() + 1) * ((CubicModifier) other).ordinal()];
    }
}