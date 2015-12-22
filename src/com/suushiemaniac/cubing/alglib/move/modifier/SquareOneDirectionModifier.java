package com.suushiemaniac.cubing.alglib.move.modifier;

public enum SquareOneDirectionModifier implements Modifier {
    POS(""), NEG("-");

    public static SquareOneDirectionModifier fromNotation(String notation) {
        for (SquareOneDirectionModifier modifier : SquareOneDirectionModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    SquareOneDirectionModifier(String notation) {
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
    public SquareOneDirectionModifier inverse() {
        return SquareOneDirectionModifier.values()[(this.ordinal() + 1) % SquareOneDirectionModifier.values().length];
    }

    //TODO
    @Override
    public SquareOneDirectionModifier merge(Modifier other) {
        return null;
    }
}
