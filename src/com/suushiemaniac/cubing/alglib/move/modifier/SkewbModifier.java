package com.suushiemaniac.cubing.alglib.move.modifier;

public enum SkewbModifier implements Modifier {
    CW(""), CCW("'");

    public static SkewbModifier fromNotation(String notation) {
        for (SkewbModifier modifier : SkewbModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    SkewbModifier(String notation) {
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
    public SkewbModifier inverse() {
        return SkewbModifier.values()[(this.ordinal() + 1) % SkewbModifier.values().length];
    }

    @Override
    public SkewbModifier merge(Modifier other) {
        return this.inverse();
    }
}