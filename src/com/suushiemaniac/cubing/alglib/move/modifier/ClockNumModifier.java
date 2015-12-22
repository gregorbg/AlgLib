package com.suushiemaniac.cubing.alglib.move.modifier;

public enum ClockNumModifier implements Modifier {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6");

    public static ClockNumModifier fromNotation(String notation) {
        for (ClockNumModifier modifier : ClockNumModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    ClockNumModifier(String notation) {
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
    public ClockNumModifier inverse() {
        return this;
    }

    @Override
    public ClockNumModifier merge(Modifier other) {
        return null;
    }
}