package com.suushiemaniac.cubing.alglib.move.modifier;

public enum SquareOneNumModifier implements Modifier {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6");

    public static SquareOneNumModifier fromNotation(String notation) {
        for (SquareOneNumModifier modifier : SquareOneNumModifier.values())
            if (modifier.getNotation().equals(notation)) return modifier;
        return null;
    }

    private String notation;

    SquareOneNumModifier(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return this.notation;
    }

    @Override
    public SquareOneNumModifier inverse() {
        return null;
    }

    @Override
    public SquareOneNumModifier merge(Modifier other) {
        return null;
    }

    @Override
    public String toFormatString() {
        return this.getNotation();
    }
}
