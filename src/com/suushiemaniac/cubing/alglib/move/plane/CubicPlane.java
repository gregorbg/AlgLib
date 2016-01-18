package com.suushiemaniac.cubing.alglib.move.plane;

public enum CubicPlane implements Plane {
    UP("U"), DOWN("D"), LEFT("L"), RIGHT("R"), FRONT("F"), BACK("B"), UP_SLICE("u"), DOWN_SLICE("d"), LEFT_SLICE("l"), RIGHT_SLICE("r"), FRONT_SLICE("f"), BACK_SLICE("b"), MIDDLE("M"), EQUATOR("E"), SANDWICH("S"), HORIZONTAL("x"), VERTICAL("y"), SPATIAL("z");

    public static CubicPlane fromNotation(String notation) {
        for (CubicPlane plane : CubicPlane.values())
            if (plane.getNotation().equals(notation)) return plane;
        return null;
    }

    private String notation;

    CubicPlane(String notation) {
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
    public boolean isRotation() {
        return this == HORIZONTAL || this == VERTICAL || this == SPATIAL;
    }
}