package com.suushiemaniac.cubing.alglib.move.modifier;

public enum ClockDirectionModifier implements Modifier {
    POS("+"), NEG("-");

    public static ClockDirectionModifier fromNotation(String notation) {
        for (ClockDirectionModifier modifier : ClockDirectionModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    ClockDirectionModifier(String notation) {
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
    public ClockDirectionModifier inverse() {
        return ClockDirectionModifier.values()[(this.ordinal() + 1) % ClockDirectionModifier.values().length];
    }

    //TODO
    @Override
    public ClockDirectionModifier merge(Modifier other) {
        return null;
    }
}