package com.suushiemaniac.cubing.alglib.move.plane;

public enum SquareOneHalfPlane implements Plane {
    UP(""), DOWN("");

    private String notation;

    SquareOneHalfPlane(String notation) {
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
        return false;
    }
}