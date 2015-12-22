package com.suushiemaniac.cubing.alglib.move.modifier;

public enum MegaminxWideModifier implements MegaminxModifier {
    PLUS("++"), MINUS("--");

    public static MegaminxWideModifier fromNotation(String notation) {
        for (MegaminxWideModifier modifier : MegaminxWideModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    MegaminxWideModifier(String notation) {
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
    public MegaminxWideModifier inverse() {
        return MegaminxWideModifier.values()[(this.ordinal() + 1) % MegaminxWideModifier.values().length];
    }

    @Override
    public MegaminxWideModifier merge(Modifier other) {
        return null;
    }

    @Override
    public String getType() {
        return "WIDE";
    }
}