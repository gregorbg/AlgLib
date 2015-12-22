package com.suushiemaniac.cubing.alglib.move.modifier;

public enum PyraminxModifier implements Modifier {
    CW(""), CCW("'");

    public static PyraminxModifier fromNotation(String notation) {
        for (PyraminxModifier modifier : PyraminxModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    PyraminxModifier(String notation) {
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
    public PyraminxModifier inverse() {
        return PyraminxModifier.values()[(this.ordinal() + 1) % PyraminxModifier.values().length];
    }

    @Override
    public PyraminxModifier merge(Modifier other) {
        return this.inverse();
    }
}