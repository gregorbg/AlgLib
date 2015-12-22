package com.suushiemaniac.cubing.alglib.move.plane;

public final class SquareOnePlane implements Plane {
    private final SquareOneHalfPlane halfPlaneUp = SquareOneHalfPlane.UP;
    private final SquareOneHalfPlane halfPlaneDown = SquareOneHalfPlane.DOWN;

    @Override
    public boolean isRotation() {
        return false;
    }

    @Override
    public String toFormatString() {
        return "";
    }
}
