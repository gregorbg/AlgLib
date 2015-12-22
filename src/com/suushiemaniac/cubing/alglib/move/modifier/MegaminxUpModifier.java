package com.suushiemaniac.cubing.alglib.move.modifier;

public enum MegaminxUpModifier implements MegaminxModifier {
    CW(""), CCW("'");

    public static MegaminxUpModifier fromNotation(String notation) {
        for (MegaminxUpModifier modifier : MegaminxUpModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    MegaminxUpModifier(String notation) {
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
    public MegaminxUpModifier inverse() {
        return MegaminxUpModifier.values()[(this.ordinal() + 1) % MegaminxUpModifier.values().length];
    }

    @Override
    public MegaminxUpModifier merge(Modifier other) {
        return null;
    }

    @Override
    public String getType() {
        return "UP";
    }
}